import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Troubleof13_Dots_10819 {

	static int[] prices;
	static int[] fav;
	static int initM;
	static int dp[][];
	static final int INF = -501;

	public static int whatToBuy(int item, int remM) {
		if (remM < 0)
			return INF;
		if (remM == 0 || item == prices.length)
			return 0;
		if (dp[item][remM] != -1)
			return dp[item][remM];

		int take = fav[item] + whatToBuy(item + 1, remM - prices[item]);
		int leave = whatToBuy(item + 1, remM);

		return dp[item][remM] = Math.max(take, leave);
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while ((line = in.readLine()) != null) {
			StringTokenizer s = new StringTokenizer(line);

			initM = Integer.parseInt(s.nextToken());
			int n = Integer.parseInt(s.nextToken());

			prices = new int[n];
			fav = new int[n];

			for (int j = 0; j < n; j++) {
				line = in.readLine();
				s = new StringTokenizer(line);
				prices[j] = Integer.parseInt(s.nextToken());
				fav[j] = Integer.parseInt(s.nextToken());
			}

			dp = new int[n][initM + 1];

			for (int j = 0; j < dp.length; j++)
				Arrays.fill(dp[j], -1);

			System.out.println(whatToBuy(0, initM));
		}
	}

}
