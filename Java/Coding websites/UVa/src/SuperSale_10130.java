import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class SuperSale_10130 {
	static int weights[];
	static int values[];
	static long dp[][];
	static final int INF = -301;

	public static long familyCarry(int object, int remW) {
		if (remW < 0)
			return INF;
		if (remW == 0 || object == weights.length)
			return 0;
		if (dp[object][remW] != -1)
			return dp[object][remW];

		long take = values[object]
				+ (familyCarry(object + 1, remW - weights[object]));
		long leave = familyCarry(object + 1, remW);

		return dp[object][remW] = Math.max(take, leave);

	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line;
		int t = Integer.parseInt(in.readLine());
		for (int i = 0; i < t; i++) {

			line = in.readLine();
			int n = Integer.parseInt(line);

			weights = new int[n];
			values = new int[n];

			for (int j = 0; j < n; j++) {
				line = in.readLine();
				StringTokenizer s = new StringTokenizer(line);

				values[j] = Integer.parseInt(s.nextToken());
				weights[j] = Integer.parseInt(s.nextToken());
			}

			int g = Integer.parseInt(in.readLine());
			long ans = 0;

			for (int j = 0; j < g; j++) {
				int remW = Integer.parseInt(in.readLine());

				dp = new long[n][remW + 1];
				for (int k = 0; k < dp.length; k++) {
					Arrays.fill(dp[k], -1);
				}

				ans += familyCarry(0, remW);
			}

			System.out.println(ans);
		}
	}
}
