/* Instead of checking every bit manually, we can shift the number right by one position.
*/
class Solution {
    public boolean consecutiveSetBits(int n) {
        //T.C -- O(1), S.C -- O(1)
        return isPowerOfTwo(n & (n << 1));
    }
    boolean isPowerOfTwo(int n){
        return n>0 && (n & (n-1)) == 0;
    }
}