class Solution {
    public long maxTotalValue(int[] nums, int k) {
        //T.C -- O(n), S.C -- O(1)

        long max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for(int num: nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return k*(max - min);
    }
}