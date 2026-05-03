class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;

        int[] closest = new int[n];

        //find closest.
        for(int i=0; i<n; i++){
            int left = i - 1;
            int right = i + 1;

            if(left < 0) closest[i] = right;
            else if(right >= n) closest[i] = left;
            else {
                int d1 = nums[i] - nums[left];
                int d2 = nums[right] - nums[i];

                if(d1 <= d2) closest[i] = left;
                else closest[i] = right;
            }
        }

        // find cost arrays
        int[] costRight = new int[n];
        int[] costLeft = new int[n];

        for(int i = 0; i < n - 1; i++){
            if(closest[i] == i + 1) costRight[i] = 1;
            else costRight[i] = nums[i+1] - nums[i];
        }

        for(int i = 1; i < n; i++){
            if(closest[i] == i - 1) costLeft[i] = 1;
            else costLeft[i] = nums[i] - nums[i-1];
        }

        // find prefix sums
        long[] prefRight = new long[n];
        long[] prefLeft = new long[n];

        for(int i = 1; i < n; i++){
            prefRight[i] = prefRight[i-1] + costRight[i-1];
        }

        for(int i = n - 2; i >= 0; i--){
            prefLeft[i] = prefLeft[i+1] + costLeft[i+1];
        }

        // get answer queries
        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];

            if(l < r){
                ans[i] = (int)(prefRight[r] - prefRight[l]);
            } else {
                ans[i] = (int)(prefLeft[r] - prefLeft[l]);
            }
        }

        return ans;    
        
    }
}