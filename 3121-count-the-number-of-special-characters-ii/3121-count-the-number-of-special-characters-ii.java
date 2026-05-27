class Solution {
    public int numberOfSpecialChars(String word) {
        //T.C -- O(n + 26), S.C -- O(26 + 26)
        
        int n = word.length();

        int[] lower = new int[26];
        int[] upper = new int[26];
        Arrays.fill(lower, -1);
        Arrays.fill(upper, -1);

        for(int i=0; i<n; i++){
            char ch = word.charAt(i);

            //store the last occurrence index of every lowercase char.
            if(ch >= 'a' && ch <= 'z')
                lower[ch - 'a'] = i; 

            //store the first occurrence index of every uppercase char.
            else {
                if(upper[ch - 'A'] == -1)
                    upper[ch - 'A'] = i; 
            }
        }

        int count = 0;
        for(int i=0; i<26; i++){
            if(lower[i] != -1 && upper[i] != -1 && lower[i] < upper[i])
                count++;
        }

        return count;
    }
}