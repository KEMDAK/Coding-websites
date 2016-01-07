import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheNewPresident_14 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());

		while (T-- > 0) {
			StringTokenizer s = new StringTokenizer(in.readLine());

			int C = Integer.parseInt(s.nextToken());
			int V = Integer.parseInt(s.nextToken());

			int[][] votes = new int[V][C];

			for (int i = 0; i < votes.length; i++) {
				s = new StringTokenizer(in.readLine());
				for (int j = 0; j < votes[i].length; j++) {
					votes[i][j] = Integer.parseInt(s.nextToken());
				}
			}

			int round = 1;

			float results[] = new float[C];

			for (int i = 0; i < votes.length; i++) {
				results[votes[i][0] - 1] += 1.0 / V;
			}

			float max = 0;
			int maxC = 1;

			for (int i = 0; i < results.length; i++) {
				if (results[i] > max) {
					max = results[i];
					maxC = i + 1;
				}
			}

			if (max > 0.5) {
				out.println(maxC + " " + round);
				continue;
			}

			round++;

			float max2 = 0;
			int maxC2 = 1;

			for (int i = 0; i < results.length; i++) {
				if (results[i] > max2 && i + 1 != maxC) {
					max2 = results[i];
					maxC2 = i + 1;
				}
			}

			results = new float[C];

			for (int i = 0; i < votes.length; i++) {
				for (int j = 0; j < votes[i].length; j++) {
					if (votes[i][j] == maxC || votes[i][j] == maxC2) {
						results[votes[i][j] - 1] += 1.0 / V;
						break;
					}
				}
			}

			float winner = 0;
			int winnerC = 1;

			for (int i = 0; i < results.length; i++) {
				if (results[i] > winner) {
					winner = results[i];
					winnerC = i + 1;
				}
			}

			out.println(winnerC + " " + round);
		}

		out.flush();
		out.close();
	}
}
