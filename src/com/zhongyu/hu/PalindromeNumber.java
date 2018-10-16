/**
 * 
 * 
 * @author ZYHU
 * 
 * 9. Palindrome Number
 * 
 * 
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 */
public class PalindromeNumber {

	public boolean isPalindrome(int x) {
        int a = 0, b = x;
        while(b > 0){
            a = a * 10 + b % 10;
            b /= 10;
        }
        if(a == x)
            return true;
        else
            return false;
        
    }
}
