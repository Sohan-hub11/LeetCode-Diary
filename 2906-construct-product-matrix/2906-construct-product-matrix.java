class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = 12345;
        int[][] ans = new int[m][n];
        long left=1, right=1;

        //Top to Bottom Traversal
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans[i][j] = (int)left;
                left = (left * grid[i][j]) % mod;
            }
        }

        //Bottom to Top Traversal
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                ans[i][j] = (int)(right * ans[i][j]) % mod;
                right = (right * grid[i][j]) % mod;
            }
        }

        return ans;
    }
}