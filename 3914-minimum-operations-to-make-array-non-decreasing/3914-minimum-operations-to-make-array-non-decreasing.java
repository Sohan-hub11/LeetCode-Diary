class Solution {
    public long minOperations(int[] nums) {
        long ans = 0;

        for(int i=0; i< nums.length-1; i++){
            if(nums[i] > nums[i+1])
                ans += nums[i] - nums[i+1];
        }

        return ans;
    }
}