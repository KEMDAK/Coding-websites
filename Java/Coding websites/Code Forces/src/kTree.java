import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kTree {

	static long d, k;
	static final int mod = 1000000007;
	static int dp[][];

	public static int p(int sum, int path) {
		if (sum == 0 && path > 0)
			return 1;
		if (sum == 0 && path == 0)
			return 0;
		if (dp[sum][path] != -1) {
			return dp[sum][path];
		}
		int ans = 0;
		for (int i = 1; i <= k; i++) {
			int newPath = path;
			if (i >= d)
				newPath = 1;
			if (sum - i >= 0) {
				ans += p(sum - i, newPath);
				ans %= mod;
			}

		}
		return dp[sum][path] = ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(s.nextToken());
		k = Integer.parseInt(s.nextToken());
		d = Integer.parseInt(s.nextToken());
		dp = new int[n + 1][2];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(p(n, 0) % 1000000007);
	}
}
