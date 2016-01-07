import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LetsGoRolling implements Comparable {

	long x;
	long cost;

	public LetsGoRolling(int x, int cost) {
		this.x = x;
		this.cost = cost;
	}

	public int compareTo(Object o) {
		Long l = this.x;
		Long m = ((LetsGoRolling) o).x;
		return l.compareTo(m);
	}

	public String toString() {
		return x + ":" + cost;
	}

	static LetsGoRolling[] m;
	static long[][] dp;

	public static long min(long pin, int pointer, long cost) {
		if (pointer == m.length)
			return cost;
		if (dp[(int) pin][pointer] != -1)
			return dp[(int) pin][pointer];
		dp[(int) pin][pointer] = cost;
		long ex = min(pin, pointer + 1, (cost + Math.abs(m[pointer].x - pin)));
		long in = min(m[pointer].x, pointer + 1, (cost + m[pointer].cost));
		return Math.min(ex, in);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(s.nextToken());
		m = new LetsGoRolling[n];
		for (int i = 0; i < n; i++) {
			s = new StringTokenizer(in.readLine());
			m[i] = new LetsGoRolling(Integer.parseInt(s.nextToken()),
					Integer.parseInt(s.nextToken()));
		}
		Arrays.sort(m);
		// dp=new long[m[m.length-1].x][m.length];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(min(m[0].x, 1, m[0].cost));
	}
}
