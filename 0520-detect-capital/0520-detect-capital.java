class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        char firstLetter = word.charAt(0);

        int count = 0;
        for(int i=0; i<n; i++){
            char ch = word.charAt(i);
            if(ch >= 'A' && ch <= 'Z')
                count++;
        }

        if(count == n || count == 0)
            return true;
        else if(firstLetter >= 'A' && firstLetter <= 'Z' && count == 1)
            return true;
        return false;
    }
}