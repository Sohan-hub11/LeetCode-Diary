class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int start = Math.max(1, n - k);
        int end = n + k;
        int ans = 0;
        for (int i=start; i<= end; i++){
            if((n & i) == 0)
                ans += i;
        }

        return ans;
    }
}