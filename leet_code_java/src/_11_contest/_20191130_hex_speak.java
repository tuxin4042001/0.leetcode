package _11_contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _20191130_hex_speak {
	Set<Character> chars = new HashSet<Character>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', '1', '0'));

	public String toHexspeak(String num) {
		Long n = Long.parseLong(num);
		if (n <= 0 && n > Math.pow(10, 12)) {
			return "ERROR";
		}
		String numString = Long.toHexString(n).toUpperCase();
		StringBuilder sb = new StringBuilder(numString);
		for (int i = 0; i < numString.length(); i++) {
			if (!chars.contains(numString.charAt(i))) {
				return "ERROR";
			} else if (numString.charAt(i) == '1') {
				sb.setCharAt(i, 'I');
			} else if (numString.charAt(i) == '0') {
				sb.setCharAt(i, 'O');
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "257";
		_20191130_hex_speak hs = new _20191130_hex_speak();
		String result = hs.toHexspeak(num);
		System.out.print(result);
	}

}
