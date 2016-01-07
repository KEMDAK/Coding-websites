import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NextRound {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(s.nextToken());
		int k = Integer.parseInt(s.nextToken());
		s = new StringTokenizer(in.readLine());
		int c = 0;
		for (int i = 0; i < k - 1; i++)
			if (Integer.parseInt(s.nextToken()) > 0)
				c++;
		int kth = Integer.parseInt(s.nextToken());
		if (kth > 0) {
			c = +k;
			for (int i = 0; i < n - k; i++) {
				if (Integer.parseInt(s.nextToken()) == kth)
					c++;
			}
		}
		System.out.println(c);
	}
}
