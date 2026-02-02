class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int bottles = numBottles;
        while(bottles >= numExchange){
            int remainings = (bottles / numExchange) + (bottles % numExchange);
            ans += bottles / numExchange;
            bottles = remainings;
        }
        return ans;
    }
}