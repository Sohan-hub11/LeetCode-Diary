class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                int rightIdx = (i + nums[i]) % n;
                result[i] = nums[rightIdx];
            } else if(nums[i] < 0){
                if(i == 0){
                    int leftIdx 
                }
                int leftIdx = (i + Math.abs(nums[i])) % n;
                result[i] = nums[leftIdx];
            } else {
                result[i] = nums[i];
            }
        }

        return result;
    }
}