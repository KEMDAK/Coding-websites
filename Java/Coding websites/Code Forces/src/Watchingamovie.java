import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Watchingamovie {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(s.nextToken());
		long x = Long.parseLong(s.nextToken());
		long m = 1;
		long t = 0;
		for (int i = 0; i < n; i++) {
			s = new StringTokenizer(in.readLine());
			m += ((Long.parseLong(s.nextToken()) - m) / x) * x;
			long temp = (Long.parseLong(s.nextToken()) - m) + 1;
			t += temp;
			m += temp;
		}
		System.out.println(t);
	}
}
