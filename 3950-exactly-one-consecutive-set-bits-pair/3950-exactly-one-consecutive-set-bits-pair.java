class Solution {
    public boolean consecutiveSetBits(int n) {
        return isPowerOfTwo(n & (n << 1));
    }
    boolean isPowerOfTwo(int n){
        return n>0 && (n & (n-1)) == 0;
    }
}