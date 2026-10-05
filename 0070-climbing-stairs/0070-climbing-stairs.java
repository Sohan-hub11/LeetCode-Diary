class Solution {
    public int climbStairs(int n) {
        if(n <= 2)
            return n;
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = dp[1] + dp[2];

        for(int i=4; i<dp.length; i++){
            dp[1] = dp[2];
            dp[2] = dp[3];
            dp[3] = dp[1] + dp[2];
        }
        return dp[3];
    }
}