class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                if (checkBalanced(freq)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    private boolean checkBalanced(int[] freq) {
        int common = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0)
                continue;
            if (common == 0)
                common = freq[i];
            if (common != freq[i])
                return false;
        }

        return true;
    }
}