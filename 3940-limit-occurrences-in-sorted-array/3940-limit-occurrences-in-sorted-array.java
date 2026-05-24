class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        /* Idea --> 
        for each num:
            if ans.size() < k OR ans[ans.size()-k] != num:
                add num */
        
        // T.C -- O(n), S.C -- O(1)

        List<Integer> list = new ArrayList<>();

        for(int num: nums){
            if(list.size()<k || list.get(list.size()-k) != num){
                list.add(num);
            }
        }

        int[] result = new int[list.size()];

        for(int i=0; i<result.length; i++){
            result[i] = list.get(i);
        }

        return result;
    }
}