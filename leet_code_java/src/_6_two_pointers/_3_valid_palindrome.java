package _6_two_pointers;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Example 1:
 * 
 * Input: "A man, a plan, a canal: Panama" Output: true Explanation:
 * "amanaplanacanalpanama"
 * 
 * Example 2:
 * 
 * Input: "race a car" Output: false Explanation: "raceacar"
 * 
 * @author terry00
 *
 */

public class _3_valid_palindrome {
	/**
	 * @param s: A string
	 * @return: Whether the string is a valid palindrome
	 */
	public boolean isPalindrome(String s) {
		// write your code here
		if (s == null || s.length() == 0) {
			return true;
		}
		int start = 0, end = s.length() - 1;
		while (start < end) {
			if (Character.isLetterOrDigit(s.charAt(start)) && Character.isLetterOrDigit(s.charAt(end))) {
				if (Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end))) {
					start++;
					end--;
				} else {
					return false;
				}
			} else if (!Character.isAlphabetic(s.charAt(start))) {
				start++;
			} else {
				end--;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
