class Solution {
    public boolean check(int[] nums) {
        //T.C -- O(n)
        //S.C -- O(1)

        int n = nums.length;

        int index = -1;
        for(int i=1; i<n; i++){
            if(nums[i] < nums[i-1]){
                if(index == -1)
                    index = i;
                else
                    return false;
            }
        }

        //sorted & rotated with x=0.
        if(index == -1)
            return true;
        if(nums[0] >= nums[n-1])
            return true;
        
        return false;
    }
}