class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
    int n = items.length;
    
    int MAXF = 1500;
    
    int[] freq = new int[MAXF + 1];
    for (int[] item : items) {
        freq[item[0]]++;
    }
    
    int[] countMultiples = new int[MAXF + 1];
            for (int f = 1; f <= MAXF; f++) {
                for (int mul = f; mul <= MAXF; mul += f) {
                    countMultiples[f] += freq[mul];
                }
            }
    
            int[] dp = new int[budget + 1];
    
    for (int[] item : items) {
        int factor = item[0];
        int price = item[1];
    
        int gain = countMultiples[factor] - 1; // exclude itself
    
        int[] ndp = dp.clone(); // option: buy 0 copies
    
    for (int rem = 0; rem < price; rem++) {
        int best = Integer.MIN_VALUE;
    
                int k = 0;
                for (int b = rem; b <= budget; b += price, k++) {
    
                    if (k >= 1) {
                        ndp[b] = Math.max(ndp[b], best + k + gain);
                    }
    
                    best = Math.max(best, dp[b] - k);
                }
            }
    
            dp = ndp;
        }
    
        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, dp[b]);
        }
    
        return ans;
    }
}