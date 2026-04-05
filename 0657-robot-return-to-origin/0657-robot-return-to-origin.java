class Solution {
    public boolean judgeCircle(String moves) {
        // T.C -- O(n)
        // S.C -- O(n)
        
        int yDir = 0, xDir = 0;
        int n = moves.length();
        for(int i=0; i<n; i++){
            char ch = moves.charAt(i);

            if(ch == 'U')
                yDir++;
            else if(ch == 'D')
                yDir--;
            else if(ch == 'R')
                xDir++;
            else
                xDir--;
        }

        return xDir == 0 && yDir == 0;
    }
}