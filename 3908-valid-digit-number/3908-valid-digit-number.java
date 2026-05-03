class Solution {
    public boolean validDigit(int n, int x) {
        String s = String.valueOf(n);
        char ch = (char)(x + '0');

        if(s.charAt(0) == ch)
            return false;

        return s.indexOf(ch) != -1;
    }
}