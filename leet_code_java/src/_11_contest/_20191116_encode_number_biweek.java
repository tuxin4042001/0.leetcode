package _11_contest;

public class _20191116_encode_number_biweek {
	// 5108. Encode Number
	// Given a non-negative integer num, Return its encoding string.
	// The encoding is done by converting the integer to a string using a secret
	// function that you should deduce from the following table:
	// more details pleas see the pdf file under same folder
	public String encode(int num) {
		if (num < 0 || num > Math.pow(10, 9)) {
			return null;
		}
		String result = "";
		int power = 0;
		int remainder = 0;
		while (num > Math.pow(2, power) - 1) {
			remainder = (int) (num - Math.pow(2, power));
			if (remainder < Math.pow(2, power + 1)) {
				result = Integer.toBinaryString(remainder);
			}
			num = remainder;
			power++;
		}
		return result;
	}

	public String encode2(int num) {
		return (num > 0) ? encode((num - 1) / 2) + "10".charAt(num % 2) : "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 4;
		_20191116_encode_number_biweek e = new _20191116_encode_number_biweek();
		String result = e.encode(num);
		System.out.print(result);
	}
}
