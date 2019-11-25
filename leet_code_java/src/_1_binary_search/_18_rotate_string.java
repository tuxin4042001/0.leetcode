package _1_binary_search;

public class _18_rotate_string {
	/**
	 * @param str:    An array of char
	 * @param offset: An integer
	 * @return: nothing
	 */
	public void rotateString(char[] str, int offset) {
		// write your code here
		if (str == null || str.length == 0) {
			return;
		}
		int realOffset = offset % str.length;
		rotate(str, 0, str.length - realOffset - 1);
		rotate(str, str.length - realOffset, str.length - 1);
		rotate(str, 0, str.length - 1);
	}

	private void rotate(char[] str, int start, int end) {
		char temp = '\0';
		while (start < end) {
			temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String args[]) {
		String string = "cppjavapy";
		char[] str = string.toCharArray();
 		int offset = 25;
		_18_rotate_string obj = new _18_rotate_string();
		obj.rotateString(str, offset);
		System.out.println(str);
	}

}
