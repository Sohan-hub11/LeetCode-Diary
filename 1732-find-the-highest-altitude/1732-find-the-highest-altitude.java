class Solution {
    public int largestAltitude(int[] gain) {
        //T.C -- O(2n+1), S.C -- O(n+1)
        
        int ans = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int sum = 0;
        for(int num: gain){
            sum += num;
            list.add(sum);
        }

        for(int i=0; i<list.size(); i++){
            ans = Math.max(ans, list.get(i));
        }

        return ans;
    }
}