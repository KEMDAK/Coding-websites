import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

	static final int types[] = { 50, 25, 10, 5, 1 };
	static int dp[][];

	public static int coinChange(int type, int change) {
		if (change == 0)
			return 1;
		if (change < 0)
			return 0;
		if (type == types.length)
			return 0;
		if (dp[type][change] != -1)
			return dp[type][change];

		int take = coinChange(type, change - types[type]);
		int leave = coinChange(type + 1, change);

		return dp[type][change] = take + leave;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line = "";

		dp = new int[6][8000];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		while (in.ready()) {
			line = in.readLine();
			int change = Integer.parseInt(line);

			System.out.println(coinChange(0, change));
		}

	}

}
