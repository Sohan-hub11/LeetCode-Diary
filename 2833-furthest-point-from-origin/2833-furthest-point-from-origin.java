/* Optimized Way*/
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int Ldist=0, Rdist=0;
        int dash = 0;
        for(int i=0; i<n; i++){
            char ch = moves.charAt(i);

            if(ch == 'L') {
                Ldist++;
            }
            else if(ch == 'R') {
                Rdist++;
            }
            else {
                dash++;
            }
        }

        return Math.max(Ldist + dash - Rdist, Rdist + dash - Ldist);
    }
}



/* class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();

        int l=0, r=0;
        for(int i=0; i<n; i++){
            char ch = moves.charAt(i);
            if(ch == 'L')
                l++;
            if(ch == 'R')
                r++;
        }

        int dist = 0;

        if(l >= r){
            for(int i=0; i<n; i++){
                char ch = moves.charAt(i);
                if(ch == 'L' || ch == '_') {
                    dist--;
                } else {
                    dist++;
                }
            }
        } else {
            for(int i=0; i<n; i++){
                char ch = moves.charAt(i);
                if(ch == 'R' || ch == '_') {
                    dist++;
                } else {
                    dist--;
                }
            }
        }

        return Math.abs(dist);
    }
} */