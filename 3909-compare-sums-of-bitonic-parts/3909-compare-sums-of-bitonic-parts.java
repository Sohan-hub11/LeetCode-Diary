class Solution {
    public int compareBitonicSums(int[] nums) {
        
        int maxIndex = findMax(nums);

        long sum1=0, sum2=0;
        
        for(int i=0; i<=maxIndex; i++){
            sum1 += nums[i];
        }

        for(int i=maxIndex; i<nums.length; i++){
            sum2 += nums[i];
        }

        if(sum1 > sum2)
            return 0;
        if(sum2 > sum1)
            return 1;

        return -1;
    }

    private int findMax(int[] nums){
        int i = 0;

        while(i < nums.length-1 && nums[i] < nums[i+1]){
            i++;
        }

        return i;
    }
}