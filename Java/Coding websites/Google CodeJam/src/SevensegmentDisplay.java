import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SevensegmentDisplay {

	static String zero = "11111100";
	static String one = "01100001";
	static String two = "11011012";
	static String three = "11110013";
	static String four = "01100114";
	static String five = "10110115";
	static String six = "10111116";
	static String seven = "11100007";
	static String eight = "11111118";
	static String nine = "11110119";
	static String[] num = { zero, one, two, three, four, five, six, seven,
			eight, nine };

	public static String and(String valid, String fin) {
		String re = "";
		for (int i = 0; i < valid.length(); i++) {
			if (valid.charAt(i) == '1' && fin.charAt(i) == '1')
				re += 1;
			else
				re += 0;
		}
		return re;
	}

	public static String estimator(String[] x) {
		String valid = "";
		for (int i = 0; i < 7; i++) {
			int f = 0;
			for (int j = 0; j < x.length; j++) {
				if (x[j].charAt(i) == '1') {
					f = 1;
					break;
				}
			}
			valid += f;
		}
		// return valid;
		Stack<Integer> prob = new Stack<Integer>();
		Stack<Integer> temp = new Stack<Integer>();
		boolean f1 = false;
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < valid.length(); j++) {
				if (valid.charAt(j) == '1') {
					if (!f1) {
						f1 = true;
						for (int k = 0; k < num.length; k++) {
							if (x[i].charAt(j) == num[k].charAt(j))
								prob.push((num[k].charAt(num[k].length() - 1)) - '0');
						}
					} else {
						while (!prob.isEmpty()) {
							int now = prob.pop().intValue();
							if (x[i].charAt(j) == num[now].charAt(j))
								temp.push(now);
						}
						while (!temp.isEmpty())
							prob.push(temp.pop());
					}
				}
			}
			while (!prob.isEmpty())
				temp.push(prob.pop());
			while (!temp.isEmpty()) {
				int t = (temp.pop().intValue()) - 1;
				if (t == -1)
					t = 9;
				prob.push(t);
			}
		}
		int fin = 0;
		if (prob.isEmpty())
			return "ERROR!";
		else
			fin = prob.pop().intValue();
		if (prob.isEmpty())
			return and(valid, num[fin].substring(0, num[fin].length() - 1));
		else
			return "ERROR!";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		int t = Integer.parseInt(s.nextToken());
		String f = "";
		for (int i = 1; i <= t; i++) {
			s = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(s.nextToken());
			String[] x = new String[n];
			for (int j = 0; j < x.length; j++)
				x[j] = s.nextToken();
			f += "Case #" + i + ": " + estimator(x) + "\n";
		}
		System.out.println(f);

	}
}
