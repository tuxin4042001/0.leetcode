package _6_two_pointers;

public class _3_valid_palindrome {

	public boolean isPalindrome(String s) {
		// write your code here
		if (s == null || s.length() == 0) {
			return true;
		}
		int start = 0, end = s.length() - 1;
		while (start < end) {
			if (Character.isLetterOrDigit(s.charAt(start)) && Character.isLetterOrDigit(s.charAt(end))) {
				if (Character.toUpperCase(s.charAt(start)) != Character.toUpperCase(s.charAt(end))) {
					return false;
				} else {
					start++;
					end--;
				}
			}
			while (start < end && !Character.isLetterOrDigit(s.charAt(start)))
				start++;
			while (start < end && !Character.isLetterOrDigit(s.charAt(end)))
				end--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
