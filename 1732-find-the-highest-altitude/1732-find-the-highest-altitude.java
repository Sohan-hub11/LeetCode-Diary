class Solution {
    public int largestAltitude(int[] gain) {
        //T.C -- O(n), S.C -- O(1)

        int ans = Integer.MIN_VALUE;
        int curr = 0;
        for(int num: gain){
            ans = Math.max(ans, curr);
            curr += num;
        }

        return Math.max(ans, curr);
    }
}