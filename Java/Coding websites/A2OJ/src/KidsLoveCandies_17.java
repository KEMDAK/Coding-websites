import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KidsLoveCandies_17 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());

		while (T-- > 0) {
			StringTokenizer s = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(s.nextToken());
			int K = Integer.parseInt(s.nextToken());

			int result = 0;

			s = new StringTokenizer(in.readLine());

			while (s.hasMoreTokens()) {
				result += Integer.parseInt(s.nextToken()) / K;
			}

			out.println(result);
		}

		out.flush();
		out.close();
	}
}
