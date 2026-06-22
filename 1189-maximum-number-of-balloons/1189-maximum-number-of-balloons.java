class Solution {
    public int maxNumberOfBalloons(String text) {
        //T.C -- O(n), S.C -- O(26)
        
        int[] charac = new int[26];
        for(int i=0; i<text.length(); i++){
            char ch = text.charAt(i);
            charac[ch - 'a']++;
        }

        //b,a,l,o,n

        int min = charac['b' - 'a'];
        min = Math.min(min, charac[0]);
        min = Math.min(min, charac['l' - 'a']/2);
        min = Math.min(min, charac['o' - 'a']/2);
        min = Math.min(min, charac['n' - 'a']);

        return min;
    }
}