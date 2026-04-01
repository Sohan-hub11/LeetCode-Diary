class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++)
            indices.add(i);

        // Sort by position so we process collisions in spatial order
        Collections.sort(indices, (a, b) -> positions[a] - positions[b]);

        // Stack holds indices of right-moving robots awaiting potential collision
        Stack<Integer> rightMovers = new Stack<>();

        for (int i : indices) {
            if (directions.charAt(i) == 'R') {
                rightMovers.push(i);
                continue;
            }

            // Current robot moves left — resolve collisions with all right-movers behind it
            while (!rightMovers.isEmpty() && healths[i] > 0) {
                int topIndex = rightMovers.peek();

                if (healths[topIndex] > healths[i]) {
                    // Right-mover survives, left-mover is destroyed
                    healths[topIndex]--;
                    healths[i] = 0;
                } else if (healths[topIndex] < healths[i]) {
                    // Left-mover survives, right-mover is destroyed
                    healths[rightMovers.pop()]= 0;
                    healths[i]--;
                } else {
                    // Both destroyed
                    healths[rightMovers.pop()] = 0;
                    healths[i] = 0;
                }
            }
        }

        // Collect survivors in original input order
        List<Integer> survivors = new ArrayList<>();
        for (int remainingHealth : healths) {
            if (remainingHealth > 0)
                survivors.add(remainingHealth);
        }

        return survivors;
    }
}