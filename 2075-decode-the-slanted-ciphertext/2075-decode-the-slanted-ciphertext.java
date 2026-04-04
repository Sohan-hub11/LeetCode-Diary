class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        // T.C -- O(n)+O(n)
        // S.C -- O(n)
        
        int n = encodedText.length();
        int cols = n/rows;
        char[][] mat = new char[rows][cols];
        int i = 0, j = 0;

        //Building matrix string from encoded string.
        for(int idx=0; idx<n; idx++){
            mat[i][j] = encodedText.charAt(idx);
            if(j < cols-1){
                j++;
            } else {
                i++;
                j = 0;
            }
        }

        //Decoding
        StringBuilder sb = new StringBuilder();
        for(int y=0; y<cols; y++){
            int slant = 0;
            for(int x=0; x<rows; x++){
                if(y+slant < cols){
                    sb.append(mat[x][y+slant]);
                    slant++;
                }
                 
            }
        }

        return sb.toString().stripTrailing();
    }
}