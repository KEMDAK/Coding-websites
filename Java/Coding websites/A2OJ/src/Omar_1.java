import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Omar_1 {
	public static void main(String[] args) throws NumberFormatException,IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line;
		int t = Integer.parseInt(in.readLine());
		for (int i = 0; i < t; i++) {
			line = in.readLine();
			StringTokenizer s = new StringTokenizer(line);
			int sum = Integer.parseInt(s.nextToken())
					+ Integer.parseInt(s.nextToken());

			System.out.println(sum);
		}
	}
}
