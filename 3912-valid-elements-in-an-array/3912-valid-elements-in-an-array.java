class Solution {
    public List<Integer> findValidElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = Integer.MIN_VALUE;
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(leftMax[i-1], nums[i-1]);
        }

        rightMax[n-1] = Integer.MIN_VALUE;
        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], nums[i+1]);
        }

        for(int i=0; i<n; i++){
            if(i==0 || i==n-1 || nums[i]>leftMax[i] || nums[i]>rightMax[i])
                ans.add(nums[i]);
        }
        
        return ans;
    }
}