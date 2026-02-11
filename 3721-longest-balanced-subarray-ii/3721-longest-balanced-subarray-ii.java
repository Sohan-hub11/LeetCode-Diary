class Solution {
    int[] segMin,segMax,lazy;
    int n;
    
    public int longestBalanced(int[] nums) {
        n = nums.length;

        segMin = new int[4 * n];
        segMax = new int[4 * n];
        lazy = new int[4 * n];

        int maxCount = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int val = (nums[i] % 2 == 0) ? 1 : -1;

            int prev = mp.getOrDefault(nums[i], -1);

            if (prev != -1) { //if the element seen at past.
            //[0...prev] we are adding -val at the range.
                updateRange(1, 0, n - 1, 0, prev, -val);
            }

            //[0...i] we are adding +val at the range
            updateRange(1, 0, n - 1, 0, i, val);

            int l = findLeftMostZero(1, 0, n - 1);
            if (l != -1) {
                maxCount = Math.max(maxCount, i - l + 1);
            }

            mp.put(nums[i], i);
        }

        return maxCount;
    }

    private void push(int node, int start, int end) {
        if (lazy[node] != 0) {
            segMin[node] += lazy[node];
            segMax[node] += lazy[node];

            if (start != end) {
                lazy[2 * node] += lazy[node];
                lazy[2 * node + 1] += lazy[node];
            }

            lazy[node] = 0;
        }
    }

    private void updateRange(int node, int start, int end, int l, int r, int val) {
        push(node, start, end);

        if (start > r || end < l) return;

        if (l <= start && end <= r) {
            lazy[node] += val;
            push(node, start, end);
            return;
        }

        int mid = (start + end) / 2;

        updateRange(2 * node, start, mid, l, r, val);
        updateRange(2 * node + 1, mid + 1, end, l, r, val);

        segMin[node] = Math.min(segMin[2 * node], segMin[2 * node + 1]);
        segMax[node] = Math.max(segMax[2 * node], segMax[2 * node + 1]);
    }

    private int findLeftMostZero(int node, int start, int end) {
        push(node, start, end);

        if (segMin[node] > 0 || segMax[node] < 0) return -1;

        if (start == end) return start;

        int mid = (start + end) / 2;

        int left = findLeftMostZero(2 * node, start, mid);
        if (left != -1) return left;

        return findLeftMostZero(2 * node + 1, mid + 1, end);
    }
}