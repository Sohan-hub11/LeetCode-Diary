class Solution {
    public int numSpecial(int[][] mat) {
        //T.C => O(m*n)
        //S.C => O(m+n)
        
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;

        int[] rows = new int[m];
        int[] cols = new int[n];
        
        //putting +1 in rows and cols whenever it finds 1. 
        //To mark the any extra 1 in that rows and col.
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        //Actual Checking
       
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rows[i] == 1 && cols[j] == 1 && mat[i][j] == 1)
                    ans++;
            }
        }

        return ans;

    }
}