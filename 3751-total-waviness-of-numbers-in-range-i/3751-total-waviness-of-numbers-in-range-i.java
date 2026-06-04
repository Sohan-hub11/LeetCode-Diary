class Solution {
    public int totalWaviness(int num1, int num2) {
        //T.C --O(n), S.C -- O(1)
        
        int ans = 0;

        for(int i=num1; i<=num2; i++){
            ans += getWaviness(i);
        }

        return ans;
    }

    int getWaviness(int num){
        String s = Integer.toString(num);

        int peak = 0, valley = 0;

        for(int i=1; i<s.length()-1; i++){
            char ch1 = s.charAt(i-1);
            char ch2 = s.charAt(i);
            char ch3 = s.charAt(i+1);

            if(ch1-'0' < ch2-'0' && ch2-'0' > ch3-'0')
                peak++;

            if(ch1-'0' > ch2-'0' && ch2-'0' < ch3-'0')
                valley++;
        }

        return peak+valley;
    }
}