class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
       //T.C -- O(n)
       //T.C -- O(1);
       
       int n = nums.length;
       int ans = n+1;
       for(int i=0; i<n; i++) {
        if(nums[i] == target)
            ans = Math.min(ans, Math.abs(i - start));
       }

       return ans;
    }
}