import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BalloonsColors_6 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());

		while (T-- > 0) {
			StringTokenizer s = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(s.nextToken());
			int X = Integer.parseInt(s.nextToken());
			int Y = Integer.parseInt(s.nextToken());

			boolean easy = false;
			boolean hard = false;

			s = new StringTokenizer(in.readLine());

			easy = (Integer.parseInt(s.nextToken()) == X);
			for (int i = 1; i < N - 1; i++) {
				s.nextToken();
			}

			hard = (Integer.parseInt(s.nextToken()) == Y);

			if (easy && hard)
				out.println("BOTH");
			else if (easy && !hard)
				out.println("EASY");
			else if (!easy && hard)
				out.println("HARD");
			else
				out.println("OKAY");
		}

		out.flush();
		out.close();
	}
}
