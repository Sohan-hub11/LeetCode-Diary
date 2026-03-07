class Solution {
    public int minFlips(String s) {
        String str = s + s;
        int n = s.length();
        int ans = Integer.MAX_VALUE;

        int one = 0, zero = 0;
        for(int i=0; i<2*n; i++){
            char ch = str.charAt(i);
            if(i%2 == 0){
                if(ch == '0')
                    one++;
                else
                    zero++;
            } else {
                if(ch == '0')
                    zero++;
                else
                    one++;
            }

            if(i >= n-1){ 
            //this gives a comple string....accordingly answer will return
                ans = Math.min(ans, Math.min(one, zero));

                //eleminating prev bit( Window Shrinking)
                int prev = i-n+1;
                char pch = str.charAt(prev);
                if(prev%2 == 0){
                    if(pch == '0')
                        one--;
                    else
                        zero--;
                } else {
                    if(pch == '0')
                        zero--;
                    else
                        one--;
                }
            }    
            
            
        }

        return ans;
    }
}