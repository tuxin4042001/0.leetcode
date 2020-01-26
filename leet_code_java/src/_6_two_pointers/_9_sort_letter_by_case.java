package _6_two_pointers;

public class _9_sort_letter_by_case {
	public void sortLetters(char[] chars) {
		// write your code here
		if (chars.length < 2) {
			return;
		}
		int start = 0, end = chars.length - 1;
		while (start < end) {
			while (start < end && Character.isLowerCase(chars[start]))
				start++;
			while (start < end && Character.isUpperCase(chars[end]))
				end--;
			if (start < end) {
				swap(chars, start, end);
			}
		}
		return;
	}

	public void swap(char[] chars, int start, int end) {
		char temp = chars[start];
		chars[start] = chars[end];
		chars[end] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
