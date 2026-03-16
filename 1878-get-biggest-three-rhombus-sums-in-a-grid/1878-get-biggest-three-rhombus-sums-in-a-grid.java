class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                set.add(grid[i][j]); // size 0 rhombus

                for(int k=1; i-k>=0 && i+k<m && j-k>=0 && j+k<n; k++){

                    int sum = 0;

                    int r=i-k,c=j;

                    // top->right
                    for(int t=0;t<k;t++) sum += grid[r+t][c+t];

                    // right->bottom
                    for(int t=0;t<k;t++) sum += grid[r+k+t][c+k-t];

                    // bottom->left
                    for(int t=0;t<k;t++) sum += grid[r+2*k-t][c-t];

                    // left->top
                    for(int t=0;t<k;t++) sum += grid[r+k-t][c-k+t];

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3,set.size());
        int[] res = new int[size];

        for(int i=0; i<size;i++){
            res[i]=set.pollLast();
        }

        return res;
    }
}