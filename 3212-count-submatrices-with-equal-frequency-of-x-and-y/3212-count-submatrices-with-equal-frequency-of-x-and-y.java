class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        //T.C => O(m*n)
        //S.C => O(m*n)
        
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int[][] prefix = new int[m+1][n+1];
        boolean[] seen = new boolean[n+1];

        for(int i=1; i<=m; i++){
            boolean seenRow = false;
            for(int j=1; j<=n; j++){
                char ch = grid[i-1][j-1];
                if(ch == 'X')
                    seen[j] = true;
                if(seen[j])
                    seenRow = true;

                int val = (ch == 'X') ? 1 : (ch == 'Y') ? -1 : 0;
                prefix[i][j] = val + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];

                if(prefix[i][j] == 0 && (seen[j] || seenRow))
                    ans++;
            }             
        }

        return ans;
    }
}