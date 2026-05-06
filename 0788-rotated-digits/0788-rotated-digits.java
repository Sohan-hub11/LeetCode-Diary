class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for(int i=1; i<=n; i++){
            if(validDigit(i))
                count++;
        }

        return count;
    }

    boolean validDigit(int i){
        boolean isValid = true;
        boolean isChanged = false;
        
        while(i > 0){
            int rem = i % 10;
            
            if(rem== 3 || rem == 4 || rem == 7){
                isValid = false;
                break;
            }

            if(rem== 2 || rem == 5 || rem == 6 || rem == 9){
                isChanged = true;
            }

            i = i / 10;
        }

        return isValid && isChanged;
    }
}