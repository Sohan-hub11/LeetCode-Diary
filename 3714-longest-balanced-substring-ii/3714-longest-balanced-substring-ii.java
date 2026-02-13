class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        //Case 1 : if it has only one Distinct Character.
        for(int i=0; i<n;){
            int len = 0;
            char ch = s.charAt(i);
            // Count consecutive occurrences of the same character
            while(i<n && ch == s.charAt(i)){
                i++;
                len++;
            }
            maxLen = Math.max(maxLen, len);
        }

        //Case 2 : if it has 2 Distinct Chracter.
        maxLen = Math.max(maxLen, getLength(s, 'a'));
        maxLen = Math.max(maxLen, getLength(s, 'b'));
        maxLen = Math.max(maxLen, getLength(s, 'c'));

        //Case 3 : all Distinct Characters.
        //(a-b) == curr(a-b) && (a-c) == curr(a-c).
        //String (a-b)#(a-c)
        HashMap<String, Integer> prev = new HashMap<>();
        prev.put("0#0", -1);
        int c1=0, c2=0, c3=0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == 'a')
                c1++;
            else if(ch == 'b')
                c2++;
            else
                c3++;
            
            int diff1 = c1 - c2;
            int diff2 = c1 - c3;
            String key = diff1 + "#" + diff2;
            if(prev.containsKey(key)){
                maxLen = Math.max(maxLen, i - prev.get(key));
            } else {
                prev.put(key, i);
            }

        }

        return maxLen;
    }

    private int getLength(String s, char skip){
        int maxL = 0;
        int n = s.length();

        // a --> b,c
        // b --> a,c
        // c --> a,b
        char first = (skip == 'a') ? 'b' : 'a';
        char second = (skip == 'c') ? 'b' : 'c';
        int i = 0;

        // Process string in segments, separated by the skip character
        while( i < n) {
            int c1 = 0, c2 = 0; // Counters for first and second characters
            
            // HashMap stores difference -> first occurrence index
            // For balanced substring: c1 == c2, so c1-c2 == 0
            HashMap<Integer, Integer> prev = new HashMap<>();
            prev.put(0, i-1); // Base case: difference 0 before current segment
            
            // Process continuous segment without skip character
            // Example: "ababcababc" with skip='c'
            while( i < n && s.charAt(i)!=skip) {
                char ch = s.charAt(i);
                // Update counters
                if(ch==first)
                    c1++;
                else c2++;
                
                // Check if we've seen this difference before
                if(prev.containsKey(c1-c2)) {
                    // Substring from prev index to current is balanced
                    maxL = Math.max(maxL, i-prev.get(c1-c2));
                } 
                else prev.put(c1-c2, i); // Store first occurrence of this difference
                i++;
            }
            i++; // Skip the 'skip' character
            
        }

        return maxL;

    }
}