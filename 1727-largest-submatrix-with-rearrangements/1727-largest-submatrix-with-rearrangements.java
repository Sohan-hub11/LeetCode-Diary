class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i>0 && matrix[i][j]>0){
                    matrix[i][j] += matrix[i-1][j];
                }
            }
        
        
            int[] temp = matrix[i].clone();
            Arrays.sort(temp);             
        
            for(int k=0; k<n; k++){
                int width = n-k;
                ans = Math.max(ans, temp[k]*width);
            }
        }

        return ans;
    }
}