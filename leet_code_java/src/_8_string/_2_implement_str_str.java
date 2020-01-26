package _8_string;

public class _2_implement_str_str {

	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null || haystack.length() < needle.length()) {
			return -1;
		}
		if (needle.equals("")) {
			return 0;
		}
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			if (haystack.substring(i, i + needle.length()).equals(needle)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_2_implement_str_str st = new _2_implement_str_str();
		String haystack = "a";
		String needle = "a";
		int result = st.strStr(haystack, needle);
		System.out.print(result);
	}

}
