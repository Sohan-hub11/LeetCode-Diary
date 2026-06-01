class Solution {
    public int minimumCost(int[] cost) {
        //T.C -- O(n/3), S.C -- O(1)
        
        int n = cost.length;
        
        Arrays.sort(cost);

        int sum = 0;
        for(int i=n-1; i>=0; i -=3){
            if(i == 0){
                sum += cost[i];
                break;
            }

            sum += cost[i] + cost[i-1];
        }

        return sum;
    }
}