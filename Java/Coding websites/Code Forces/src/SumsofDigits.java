import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumsofDigits {

	static String res[];

	public static String secondGrade1dig(int x) {
		String f = "";
		for (int i = 0; i < x; i++) {
			f += 1;
		}
		return f;
	}

	public static String thirdGrade(int x, String y) {
		int dig = y.length();
		String f = "" + x;
		for (int i = 0; i < dig; i++)
			f += 0;
		return f;
	}

	public static String secondGradegeneral(int x) {
		String f = "";
		do {
			if (x > 9) {
				f += 9;
				x -= 9;
			} else {
				f += x;
				x -= x;
			}
		} while (x != 0);
		return f;
	}

	public static String print() {
		String f = "";
		for (int i = 0; i < res.length - 1; i++) {
			f += res[i] + "\n";
		}
		f += res[res.length - 1];
		return f;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		res = new String[n];
		res[0] = in.readLine();
		for (int i = 1; i < n; i++) {
			String num = in.readLine();
			if (num.length() < 2) {
				if (Integer.parseInt(num) > Integer.parseInt(res[i - 1])) {
					res[i] = num;
					continue;
				}
				if (Integer.parseInt(secondGrade1dig(Integer.parseInt(num))) > Integer
						.parseInt(res[i - 1])) {
					res[i] = secondGrade1dig(Integer.parseInt(num));
					continue;
				}
				res[i] = thirdGrade(Integer.parseInt(num), res[i - 1]);
				continue;
			} else {
				if (Integer.parseInt(num) > Integer.parseInt(res[i - 1])) {
					res[i] = num;
					continue;
				}
				String SGGN = secondGradegeneral(Integer.parseInt(num));
				if (Integer.parseInt(SGGN) > Integer.parseInt(res[i - 1])) {
					res[i] = SGGN;
				} else {
					while (Integer.parseInt(SGGN) > Integer
							.parseInt(res[i - 1])) {
						SGGN += 0;
					}
					res[i] = SGGN;
				}
			}
		}
		System.out.print(print());
	}
}
