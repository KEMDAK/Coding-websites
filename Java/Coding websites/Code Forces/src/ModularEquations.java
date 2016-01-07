import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class ModularEquations {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		long a = Long.parseLong(s.nextToken());
		long b = Long.parseLong(s.nextToken());
		long c = 0;
		long x = a;
		while (x > 0) {
			if (a % x == b) {
				c++;
				// System.out.println(x);
			}
			x--;
		}
		if (a == b)
			System.out.println("infinity");
		else
			System.out.println(c);
	}
}