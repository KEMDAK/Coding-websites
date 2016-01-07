import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class DividingCoins_562 {

	static int[] coins;
	static int dp[][];
	static final int INF = -25001;

	public static int maxOfHalf(int coin, int remM) {
		if (remM < 0)
			return INF;
		if (remM == 0 || coin == coins.length)
			return 0;
		if (dp[coin][remM] != -1)
			return dp[coin][remM];

		int take = coins[coin] + maxOfHalf(coin + 1, remM - coins[coin]);
		int leave = maxOfHalf(coin + 1, remM);

		return dp[coin][remM] = Math.max(take, leave);
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(in.readLine());

		for (int i = 0; i < t; i++) {
			int m = Integer.parseInt(in.readLine());

			coins = new int[m];
			String line = in.readLine();
			StringTokenizer s = new StringTokenizer(line);
			int total = 0;

			for (int j = 0; j < m; j++) {
				int value = Integer.parseInt(s.nextToken());
				coins[j] = value;
				total += value;
			}

			dp = new int[m][total / 2 + 1];

			for (int j = 0; j < dp.length; j++) {
				Arrays.fill(dp[j], -1);
			}

			System.out.println(((total / 2) - maxOfHalf(0, total / 2)) * 2
					+ (total % 2));
		}
	}

}
