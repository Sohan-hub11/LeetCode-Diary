class Solution {
    public int minimumDistance(int[] nums) {
        //Store in HashMap
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int dist = Integer.MAX_VALUE;

        for(Integer key: map.keySet()){
            if(map.get(key).size() < 3)
                continue;

            List<Integer> temp = map.get(key);
            for(int i=0; i<temp.size()-2; i++){
                int x = temp.get(i+1) - temp.get(i);
                int y = temp.get(i+2) - temp.get(i+1);
                int z = temp.get(i+2) - temp.get(i);
                dist = Math.min(dist,(x+y+z));
            }
        }

        return dist == Integer.MAX_VALUE ? -1 : dist;
    }
}