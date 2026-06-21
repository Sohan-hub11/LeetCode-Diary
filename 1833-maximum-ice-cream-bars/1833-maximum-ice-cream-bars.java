class Solution {
    public int maxIceCream(int[] costs, int coins) {
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