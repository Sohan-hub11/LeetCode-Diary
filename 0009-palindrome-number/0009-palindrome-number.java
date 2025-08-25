import java.util.*;
class Solution {
    public static boolean isPalindrome(int x) {
        int palindrome = x;//copied the number into a variable.
        int reverse = 0;
        while(palindrome > 0){ //negative number are never palindrome.
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }
        if (x == reverse){ //if the reverse is similar to the original number then it will be palindrome.
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int palindrome = s.nextInt();
        if (isPalindrome(palindrome)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}