import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tram {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int max = 0;
		int cur = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer s = new StringTokenizer(in.readLine());
			cur -= Integer.parseInt(s.nextToken());
			cur += Integer.parseInt(s.nextToken());
			if (cur > max)
				max = cur;

		}
		System.out.println(max);
	}
}
