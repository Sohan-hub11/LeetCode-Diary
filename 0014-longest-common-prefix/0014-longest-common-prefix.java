class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        
        //Sorting string by length.
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        
        //checking each character.
        for(int i=0; i<Math.min(first.length(),last.length()); i++){
            if(first.charAt(i) == last.charAt(i)){
                sb.append(first.charAt(i));
            } else {
                break;
            }
            
        }

        return sb.toString();
    }
}