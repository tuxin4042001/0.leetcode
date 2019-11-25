package _8_string;

public class _3_longest_palindromic_substring {

	//�ⷨһ:������palindrome��ż��palindrome���
	//     a.����ż���, b a b,��a�����������, isPalindrome(s, 1 - 0, 1)
	//                      ��b����ż�����, isPalindrome(s, 2 - 1 - 1, 2)
	//     b.maxLenΪ�Ѿ��ó����palindrome����,����maxLen�ľͲ�������
	public String longestPalindrome(String s) {
		if (s.length() < 2) {
			return s;
		}
		int maxLen = 0;
		String maxStr = "";
		for (int i = 0; i < s.length(); i++) {
			if (isPalindrome(s, i - maxLen - 1, i)) {
				maxStr = s.substring(i - maxLen - 1, i + 1);
				maxLen = maxLen + 2;
			} else if (isPalindrome(s, i - maxLen, i)) {
				maxStr = s.substring(i - maxLen, i + 1);
				maxLen = maxLen + 1;
			}
		}
		return maxStr;
	}

	public boolean isPalindrome(String str, int start, int end) {
		if (start < 0) {
			return false;
		}
		while (start < end) {
			if (!Character.isLetterOrDigit(str.charAt(start))) {
				return false;
			} else if (!Character.isLetterOrDigit(str.charAt(end))) {
				return false;
			} else if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
