class Solution {
    public int fib(int n) {
        if(n <= 1)
            return n;
        
        if(n == 2)
            return 1;

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        
        for(int i=3; i<dp.length; i++){
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = dp[1] + dp[0];
        }
        
        return dp[2];
    }


}