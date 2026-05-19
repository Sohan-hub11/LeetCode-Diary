class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> map = new HashSet<>();

        if(nums1[nums1.length-1] < nums2[0] || nums2[nums2.length-1] < nums1[0]){
            return -1;
        }
        
        for(int num: nums1){
            map.add(num);
        }

        int min = Integer.MAX_VALUE;

        for(int num: nums2){
            if(map.contains(num)){
                min = Math.min(min, num);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}