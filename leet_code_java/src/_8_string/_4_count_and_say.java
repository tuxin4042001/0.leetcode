package _8_string;

public class _4_count_and_say {
	
	/* Notice: 1. int i = 1; i < n; i++, means start count and say for the second round
                  for the first round, result still is "1"
               2. when the perv.charAt(j) == say, only increase the count
               3. when the prev.charAt(j) != say, count and say and init the count and say
               4. finally count and say for the last element prev.charAt(prev.length() - 1)
    */
	public String countAndSay(int n) {
		String curr = "1";
		String prev;
		int count;
		char say;
		for (int i = 1; i < n; i++) {
			prev = curr;
			curr = "";
			count = 1;
			say = prev.charAt(0);
			int len = prev.length();
			for (int j = 1; j < len; j++) {
				if (prev.charAt(j) == say) {
					count++;
				} else {
					curr = curr + count + say;
					count = 1;
					say = prev.charAt(j);
				}
			}
			curr = curr + count + say;
		}
		return curr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
