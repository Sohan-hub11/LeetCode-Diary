class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        //T.C -- O(k*k)
        //S.C -- O(1)
        
        int top = x;
        int bottom = x+k-1;

        while(top < bottom){
            //Swap top row with bottom row
            for(int i=y; i<y+k; i++){
                int temp = grid[top][i];
                grid[top][i] = grid[bottom][i];
                grid[bottom][i] = temp;
            }
            top++;
            bottom--;
        }

        return grid;
    }
}