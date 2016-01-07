import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Taxi {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] x = new int[n];
		StringTokenizer s = new StringTokenizer(in.readLine());
		for (int i = 0; s.hasMoreTokens(); i++)
			x[i] = Integer.parseInt(s.nextToken());
		Arrays.sort(x);
		int c = 0;
		int neg1 = 0;
		for (int i = x.length - 1; i >= neg1; i--) {
			if (x[i] == -1)
				continue;
			int t = x[i];
			x[i] = -1;
			if (t != 4) {
				for (int j = neg1; j < i; j++) {
					if (x[j] == -1)
						continue;
					if (t + x[j] > 4)
						break;
					else {
						t += x[j];
						x[j] = -1;
						neg1 = j;
					}
				}
			}
			c++;
		}
		System.out.println(c);
	}
}
