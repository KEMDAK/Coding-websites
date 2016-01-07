import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WritingCode {
	static int n, m, b, mod;
	static int[] prog;
	static int dp[][][];

	public static int goodPlans(int p, int lines, int bugs) {
		if (bugs > b)
			return 0;
		if (lines == 0)
			return 1;
		if (p == prog.length)
			return 0;
		if (dp[p][lines][bugs] != -1) {
			return dp[p][lines][bugs];
		}

		int take = goodPlans(p, lines - 1, bugs + prog[p]);
		int leave = goodPlans(p + 1, lines, bugs);

		return dp[p][lines][bugs] = (take + leave) % mod;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		n = Integer.parseInt(s.nextToken());
		m = Integer.parseInt(s.nextToken());
		b = Integer.parseInt(s.nextToken());
		mod = Integer.parseInt(s.nextToken());

		s = new StringTokenizer(in.readLine());

		prog = new int[n];
		for (int i = 0; i < n; i++) {
			prog[i] = Integer.parseInt(s.nextToken());
		}

		dp = new int[n][m + 1][b + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		System.out.println(goodPlans(0, m, 0));
	}
}
