class Solution {
    public int sumOfPrimesInRange(int n) {
       int rev = 0;
        int num = n;
        while(n > 0){
            int rem = n % 10;
            rev = rev * 10 + rem;
            n = n/10;
        }

        int sumPrime = 0;

        int max = Math.max(num, rev);
        int min = Math.min(num, rev);

        for(int i=min; i<=max; i++){
            if(checkPrime(i))
                sumPrime += i;
        }
        
        return sumPrime;
    }

    boolean checkPrime(int n){
        if(n <= 1)
            return false;

        for(int i=2; i<n; i++){
            if(n % i == 0)
                return false;
        }

        return true;
    }
}