class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        //T.C -- O(m*n)
        //S.C -- O(m+n)

        int m = grid.length, n = grid[0].length;
        long[] rows = new long[m];
        long[] cols = new long[n];
        long sum = getSum(grid, rows, cols);
        
        // horizontal check
        long currsum = rows[0];
        for(int i=1; i<m; i++) {
            if(currsum==sum-currsum)
                return true;
            currsum += rows[i];
        }

        // vertical check
        currsum = cols[0];
        for(int j=1; j<n; j++) {
            if(currsum==sum-currsum)
                return true;
            currsum += cols[j];
        }

        return false;

    }

    long getSum(int[][] grid, long[] rows, long[] cols) {
        long sum = 0;
        
        // rowsum
        for(int i=0; i<grid.length; i++) {
            long rowsum = 0;
            for(int j=0; j<grid[0].length; j++) {
                sum += grid[i][j];
                rowsum += grid[i][j];
            }
            rows[i] = rowsum;
        }
        // colsum
        for(int j=0; j<grid[0].length; j++) {
            long colsum = 0;
            for(int i=0; i<grid.length; i++) {
                colsum += grid[i][j];
            }
            cols[j] = colsum;
        }

        return sum;
    }
}