class Solution {
    public int countPrimeSetBits(int left, int right) {
       //store all prime number 1 -> 32 (possible set bits in int).
       HashSet<Integer> set = new HashSet<>(
        Arrays.asList(2,3,5,7,11,13,17,19,31)
       );

       int ans=0;
       for(int i=left; i<=right; i++){
        int setsBit = Integer.bitCount(i);
        if(set.contains(setsBit))
            ans++;
       }
       return ans;
    }
}