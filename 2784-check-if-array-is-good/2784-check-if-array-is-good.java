class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n];

        int max = maxElement(nums);

        for(int num : nums) {
            if(num < nums.length)
                freq[num]++;
        }

        if(n != max+1)
            return false;
        if(freq[max] != 2)
            return false;

        for(int i=1; i<freq.length; i++){
            if(freq[i] == 0)
                return false;
        }

        return true;
    }
    
    private int maxElement(int[] nums){
        int max = 0;

        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        return max;
    }
}