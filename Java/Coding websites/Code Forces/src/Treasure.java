import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Treasure {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		String x = s.nextToken();
		String f = "";
		long c = 0;
		long ch = 0;
		for (int i = 0; i < x.length(); i++) {
			if (x.charAt(i) == '(') {
				c++;
				ch++;
			} else if (x.charAt(i) == ')') {
				c--;
				ch--;
			} else {
				int j = i + 1;
				int test = 0;
				boolean flag = false;
				while (j < x.length()) {
					if (!flag && x.charAt(j) == '(') {
						flag = true;
						i = j - 1;
					}
					if ((test < 0 && x.charAt(j) == '(')) {
						i = j - 1;
						break;
					}

					if (x.charAt(j) == '#')
						break;
					if (x.charAt(j) == '(') {
						test++;
						if (!flag)
							ch++;
					}
					if (x.charAt(j) == ')') {
						test--;
						if (!flag)
							ch--;
					}
					j++;
				}
				// while (j<x.length()&&x.charAt(j)!='('){
				// if (x.charAt(j)!='#'){
				// c--;
				// ch--;
				// }
				// j++;
				// }
				// if (j==x.length()||x.charAt(j)=='#'){
				// j--;
				// }
				// i=j-1;
				if (test < 0) {
					c += test;
				}
				f += c + "\n";
				c = 0;
			}
		}
		if (ch > 0)
			System.out.println(f);
		else
			System.out.println(-1);
	}
}
