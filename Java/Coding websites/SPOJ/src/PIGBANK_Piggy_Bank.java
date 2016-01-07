import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class PIGBANK_Piggy_Bank {
	static int weights[];
	static int values[];
	static long dp[][];
	static final int INF = 25000001;

	public static long piggyMoney(int coin, int remW) {
		if (remW == 0)
			return 0;
		if (coin == weights.length || remW < 0)
			return INF;
		if (dp[coin][remW] != -1)
			return dp[coin][remW];

		long take = values[coin] + (piggyMoney(coin, remW - weights[coin]));
		long leave = piggyMoney(coin + 1, remW);

		return dp[coin][remW] = Math.min(take, leave);

	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line;
		int t = Integer.parseInt(in.readLine());
		for (int i = 0; i < t; i++) {
			line = in.readLine();
			StringTokenizer s = new StringTokenizer(line);
			int remW = Integer.parseInt(s.nextToken()) * -1
					+ Integer.parseInt(s.nextToken());

			line = in.readLine();
			int n = Integer.parseInt(line);

			dp = new long[n][remW + 1];
			for (int k = 0; k < dp.length; k++) {
				Arrays.fill(dp[k], -1);
			}

			weights = new int[n];
			values = new int[n];

			for (int j = 0; j < n; j++) {
				line = in.readLine();
				s = new StringTokenizer(line);

				values[j] = Integer.parseInt(s.nextToken());
				weights[j] = Integer.parseInt(s.nextToken());
			}

			long minMoney = piggyMoney(0, remW);
			if (minMoney == INF)
				System.out.println("This is impossible.");
			else
				System.out
						.println("The minimum amount of money in the piggy-bank is "
								+ minMoney + ".");
		}
	}
}
