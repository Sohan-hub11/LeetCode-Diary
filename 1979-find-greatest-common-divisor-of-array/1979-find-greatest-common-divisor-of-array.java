class Solution {
    public int findGCD(int[] nums) {
        // O(n + log(min))
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num: nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return gcd(max, min);
    }

    int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}