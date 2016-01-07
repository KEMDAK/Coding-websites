import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DominoPiling {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		int m = Integer.parseInt(s.nextToken());
		int n = Integer.parseInt(s.nextToken());
		System.out.println((((m / 2) * n) + ((m % 2) * (n / 2))));
	}
}
