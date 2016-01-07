import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PashaandString {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder line = new StringBuilder(in.readLine());

		int linelength = line.length();

		int m = Integer.parseInt(in.readLine());

		StringTokenizer s = new StringTokenizer(in.readLine());

		int[] reverses = new int[linelength / 2];
		while (m-- > 0) {
			reverses[Integer.parseInt(s.nextToken()) - 1]++;
		}

		int[] sum = new int[linelength / 2];
		int acc = 0;

		for (int i = 0; i < reverses.length; i++) {
			acc += reverses[i];
			sum[i] = acc;
		}

		for (int i = 0; i < sum.length; i++) {
			if (sum[i] % 2 != 0) {
				char temp = line.charAt(i);
				line.setCharAt(i, line.charAt(linelength - i - 1));
				line.setCharAt(linelength - i - 1, temp);
			}
		}

		System.out.println(line);
	}
}
