class Solution {
    public String sortVowels(String s) {
        int n = s.length();

        
        char[] v = {'a','e','i','o','u'};
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> firstPos = new HashMap<>();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                freq.put(ch, freq.getOrDefault(ch, 0)+1);
                firstPos.putIfAbsent(ch, i);
            }
        }

        List<Character> order = new ArrayList<>();
        for(char c: v){
            if(freq.containsKey(c))
                order.add(c);
        }
        Collections.sort(order,(a,b)->{
            if(!freq.get(a).equals(freq.get(b))){
                return freq.get(b) - freq.get(a);
            }
            return firstPos.get(a) - firstPos.get(b);
        });

        List<Character> sortedVowels = new ArrayList<>();
        for(char c: order){
            int count = freq.get(c);
            while(count-- > 0){
                sortedVowels.add(c);
            }
        }

        StringBuilder res = new StringBuilder(s);
        int idx = 0;
        for(int i =0; i<n; i++){
            if(isVowel(s.charAt(i))){
                res.setCharAt(i, sortedVowels.get(idx++));
            }
        }

        return res.toString();
    }

    private boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}