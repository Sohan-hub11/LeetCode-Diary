class Solution {
    public int minOperations(int[][] grid, int x) {
        //T.C -- O(m*n log(m*n))
        //S.C -- O(m*n)
        
        int m = grid.length;
        int n = grid[0].length;
        int idx = 0;
        int[] arr = new int[m*n];
        int rem = grid[0][0] % x;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]%x != rem)
                    return -1;
                arr[idx++] = grid[i][j];
            }
        }

        Arrays.sort(arr);

        int ans = 0;
        int mid = arr.length/2;
        for(int i=0; i<arr.length; i++){
            ans += (Math.abs(arr[mid] - arr[i])/x);
        }

        return ans;
    }
}