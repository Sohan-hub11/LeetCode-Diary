class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        int n = queries.length;
        int i=0, j=0;

        while(i < n){
            if(chackEquality(queries[i], dictionary)){
                ans.add(queries[i]);
                j++;
            }
            i++;
        }

        return ans;
    }
    private boolean chackEquality(String s1, String[] s2){
        int n = s2.length;
        int len = s1.length();
        int i=0, count = 0;
        
        for(int j=0; j<n; j++){
            count = 0;
            i = 0;
            while(count<3 && i<len){
                if(s1.charAt(i) != s2[j].charAt(i))
                    count++;
                i++;
            }
            if(count < 3)
                break;
        }
        return count<3 ? true : false;
    }
}