class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        // Early exit: last index must be '0' to be reachable
        if (s.charAt(n - 1) == '1') return false;

        // Difference array to track how many valid positions can reach index i
        int[] arr = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            // Apply difference array increment at this index
            count += arr[i];

            // Index i is a valid jump source if it's '0' and reachable (or is the start)
            if (i == 0 || (s.charAt(i) == '0' && count > 0)) {
                // Mark the jump range [i+minJump, i+maxJump] as reachable using difference array
                if (i + minJump < n)
                    arr[i + minJump] += 1;
                if (i + maxJump + 1 < n) 
                    arr[i + maxJump + 1] -= 1;
            }
        }

        // count > 0 means at least one valid path reached the last index
        return count > 0;
    }
}