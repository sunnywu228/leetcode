package leetcode;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @author chengyangwu
 *
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() == 0) return true;
        
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            
            if (!isAlphanumeric(a)) {
                i ++;
                continue;
            } 
            
            if (!isAlphanumeric(b)) {
                j --;
                continue;
            }
            
            if (Character.toLowerCase(a) != Character.toLowerCase(b)) return false;
            i ++;
            j --;
        }
        return true;
    }
    
    public boolean isAlphanumeric (char a) {
        return (a <= 'Z' && a >= 'A') || (a >= 'a' && a <= 'z') || (a >= '0' && a <= '9');
    }
}
