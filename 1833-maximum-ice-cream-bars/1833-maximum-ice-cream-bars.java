class Solution {
    public int maxIceCream(int[] costs, int coins) {
        //T.C -- O(n), S.C -- O(n)

        Arrays.sort(costs);
        int ans = 0;
        for(int cost: costs){
            if(coins == 0)
                break;
            
            if(cost <= coins){
                coins -= cost;
                ans++;
            }
        }

        return ans;
    }
}