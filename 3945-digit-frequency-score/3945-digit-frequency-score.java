class Solution {
    public int digitFrequencyScore(int n) {
        int sum = 0;
        int[] count = new int[11];
        
        while(n != 0){
            int r = n%10;
            count[r]++;

            n /= 10;
        }

        for(int i=0; i<11; i++){
            sum += i * count[i];
        }

        return sum;
    }
}