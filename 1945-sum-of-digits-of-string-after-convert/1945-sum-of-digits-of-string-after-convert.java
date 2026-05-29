class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;

        // Convert characters and get initial digit sum
        for (char ch : s.toCharArray()) {
            int val = ch - 'a' + 1;

            while (val > 0) {
                sum += val % 10;
                val /= 10;
            }
        }

        // Remaining k-1 transition.
        for(int i=1; i<k; i++){
            sum = getSum(sum);
        }

        return sum;
    }

    int getSum(int nums){
        int sum = 0;
        while(nums != 0){
            int r = nums % 10;
            sum += r;
            nums /= 10;
        }

        return sum;
    }
}