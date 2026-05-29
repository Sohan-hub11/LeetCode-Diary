class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++){
            int num = nums[i];
            int sum = 0;

            while(num != 0){
                int r = num % 10;
                sum += r;
                num /= 10;
            }
            nums[i] = sum;
        }

        return findMinValue(nums);
    }

    int findMinValue(int[] nums){
        int min = Integer.MAX_VALUE;

        for(int num: nums){
            min = Math.min(min, num);
        }

        return min;
    }
}