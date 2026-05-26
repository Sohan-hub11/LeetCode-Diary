class Solution {
    public int reverse(int x) {
        int rev = 0;
        while(x != 0){
            int n = x%10;

            //check for over flow before multiplying by 10.
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && n > 7)){
                return 0;
            }

            //check for under flow before multiplying by 10.
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && n < -8)){
                return 0;
            }

            rev = rev*10+n;
            x = x/10;
        }

        return rev;
    }
}