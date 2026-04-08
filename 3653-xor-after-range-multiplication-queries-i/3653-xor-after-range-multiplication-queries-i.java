class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        //T.C -- O(q + n)
        //S.C -- O(n)
        
        int mod = 1000_000_007;
        int n = nums.length;

        for(int q[]: queries){
            int idx = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            while(idx <= r){
                long curr = nums[idx];
                curr = (curr * v) % mod;
                nums[idx] = (int)curr;
                idx += k;
            }
        }

        int ans = nums[0];
        for(int i=1; i<n; i++){
            ans = ans ^ nums[i];
        }

        return ans;
    }
}