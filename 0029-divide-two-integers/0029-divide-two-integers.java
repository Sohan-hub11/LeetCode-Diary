class Solution {
    public int divide(int dividend, int divisor) {
        long n = dividend;
        long d = divisor;

        if(n == Integer.MIN_VALUE && d == -1)
            return Integer.MAX_VALUE;
        if(n == d)
            return 1;
        boolean sign = true;
        if(n >= 0 && d < 0)
            sign = false;
        if(n < 0 && d >= 0)
            sign = false;

        n = Math.abs(n);
        d = Math.abs(d);

        long ans = 0;
        while(n >= d){
            int count = 0;
            while(n >= (d << (count+1))){
                count++;
            }

            ans += 1 << count;
            n = n - (d << count);
        }

        if(ans == Integer.MAX_VALUE && sign)
            return Integer.MAX_VALUE;
        if(ans == Integer.MIN_VALUE && !sign)
            return Integer.MIN_VALUE;

        return sign ? (int) ans : (int) (-1 * ans);
    }
}