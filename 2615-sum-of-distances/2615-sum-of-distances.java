 class Solution {
    public long[] distance(int[] nums) {
        long[] ans = new long[nums.length];

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        for(List<Integer> list: map.values()){
            int n = list.size();

            long rightSide = 0;
            long leftSide = 0;

            for(int i=0; i<n; i++){
                rightSide += list.get(i);
            }

            for(int i=0; i<n; i++){
                rightSide -= list.get(i);

                long currSum = 0;

                //left side

                currSum += ((long)list.get(i)*i - leftSide);

                //right side

                currSum += (rightSide - (n-i-1)*(long)list.get(i));

                leftSide += list.get(i);
                
                ans[list.get(i)] = currSum;
            }
        }

        return ans;
    }
}