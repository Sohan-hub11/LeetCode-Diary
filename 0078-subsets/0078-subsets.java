class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int subset = 1 << n;
        List<List<Integer>> result = new ArrayList<>();

        for(int num=0; num<subset; num++){
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                if((1 & (num >> i)) == 1){
                    list.add(nums[i]);
                }
            }

            result.add(list);
        }

        return result;
    }
}