class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int cur_val = nums[i];
            // cur_val + x = target
            // x = target -cur_val
            int x = target - cur_val;
            if(map.containsKey(x)) {
                return new int[] { map.get(x), i };
            }
            map.put(cur_val, i);
        }         
        return null;
    }
}