class Solution {
    public int largestAltitude(int[] gain) {
        //T.C -- O(n), S.C -- O(1)

        int ans = 0;
        int curr = 0;
        for(int num: gain){
            curr += num;
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}