import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class LetMeCountTheWays_357 {
	static final int types[] = { 50, 25, 10, 5, 1 };
	static long dp[][];

	public static long coinChange(int type, int change) {
		if (change == 0)
			return 1;
		if (change < 0)
			return 0;
		if (type == types.length)
			return 0;
		if (dp[type][change] != -1)
			return dp[type][change];

		long take = coinChange(type, change - types[type]);
		long leave = coinChange(type + 1, change);

		return dp[type][change] = take + leave;

	}

	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line = "";

		dp = new long[5][31000];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		try {
			while (in.ready()) {

				line = in.readLine();

				int change = Integer.parseInt(line);

				long ways = coinChange(0, change);
				if (ways == 1)
					System.out.println("There is only " + ways
							+ " way to produce " + change + " cents change.");
				else
					System.out.println("There are " + ways
							+ " ways to produce " + change + " cents change.");
			}
		} catch (NumberFormatException e) {
		} catch (IOException e) {
		}
	}
}
