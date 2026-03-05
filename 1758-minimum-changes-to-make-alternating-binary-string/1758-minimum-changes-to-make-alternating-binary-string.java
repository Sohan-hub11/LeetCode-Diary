class Solution {
    public int minOperations(String s) {
        int zeroStart = 0, oneStart = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(i%2 == 0) {
                if(ch == '0')
                    oneStart++;
                else
                    zeroStart++;
            }
            else {
                if(ch == '1')
                    oneStart++;
                else
                    zeroStart++;
            }
        }

        return Math.min(oneStart, zeroStart);
    }
}