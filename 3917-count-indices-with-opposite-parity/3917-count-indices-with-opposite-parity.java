class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int countOdd = 0;
        int countEven = 0;

        for(int i=0; i<n; i++){
            if(nums[i] % 2 == 0)
                countEven++;
            else
                countOdd++;
        }

        for(int i=0; i<n; i++){
            if(nums[i] % 2 == 0)
                countEven--;
            else
                countOdd--;

            if(nums[i] % 2 == 0)
                ans[i] = countOdd;
            else
                ans[i] = countEven;
        }

        return ans;
    }
}