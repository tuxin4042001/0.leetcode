package _8_string;

public class _1_zigzag_conversion {
	public String convert(String s, int numRows) {
		if (numRows <= 1) {
			return s;
		}
		StringBuffer[] sb = new StringBuffer[numRows];
		for (int i = 0; i < numRows; i++) {
			sb[i] = new StringBuffer();
		}
		int start = 0;
		while (start < s.length()) {
			for (int i = 0; i < numRows && start < s.length(); i++) {
				sb[i].append(s.charAt(start++));
			}
			for (int j = numRows - 2; j > 0 && start < s.length(); j--) {
				sb[j].append(s.charAt(start++));
			}
		}
		String result = "";
		for (int i = 0; i < numRows; i++) {
			result += sb[i].toString();
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
