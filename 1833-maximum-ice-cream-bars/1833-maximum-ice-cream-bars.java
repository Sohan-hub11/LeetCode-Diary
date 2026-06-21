/* Brute Force Approach */

/* 
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        //T.C -- O(n + n logn), S.C -- O(n)

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
*/

/* Using Counting Sort */

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        //T.C -- O(n), S.C -- O(n)

        int ans = 0;
        int[] count = new int[100001];

        for(int cost: costs){
            count[cost]++;
        }

        for(int i=1; i<count.length; i++){
            while(count[i] > 0 && i <= coins){
                ans++;
                coins -= i;
                count[i]--;
            }
        }

        return ans;
    }
}