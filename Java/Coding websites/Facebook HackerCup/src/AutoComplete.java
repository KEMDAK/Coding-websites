import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AutoComplete {

	static String[] words;
	static String[] abv;

	public static boolean find(String[] x, String s) {
		for (int i = 0; i < x.length; i++) {
			if (x[i] != null && x[i].equals(s))
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		int t = Integer.parseInt(s.nextToken());
		System.out.println();
		for (int i = 1; i <= t; i++) {
			s = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(s.nextToken());
			words = new String[n];
			abv = new String[n];
			int c = 0;
			for (int j = 0; j < n; j++) {
				String st = in.readLine();
				if (!find(words, st)) {
					words[j] = st;
				}
			}
			for (int j = 0; j < n; j++) {
				String st = words[j];
				String ab = "";
				int k = 1;
				do {
					ab = st.substring(0, k);
					if (ab.equals(st))
						break;
					if (k != st.length())
						k++;
				} while ((find(words, ab)) || (find(abv, ab)));
				abv[j] = ab;
				c += ab.length();
			}
			System.out.println("Case #" + i + ": " + c);
		}
	}
}
