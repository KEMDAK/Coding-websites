import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Lotto_441 {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new  BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new  PrintWriter(System.out);

		int c= 0;
		while(true){
			StringTokenizer s = new StringTokenizer(in.readLine());

			int n = Integer.parseInt(s.nextToken());

			if(n == 0)
				break;

			if(c != 0)
				out.println();
			c++;

			int[] numbers = new int[n];

			for (int i = 0; i < n; i++) {
				numbers[i] = Integer.parseInt(s.nextToken());
			}

			for (int i = 0; i <= n - 6; i++) {
				for (int j = i + 1; j <= n - 5; j++) {
					for (int k = j + 1; k <= n - 4; k++) {
						for (int l = k + 1; l <= n - 3; l++) {
							for (int m = l + 1; m <= n - 2; m++) {
								for (int p = m + 1; p < n; p++) {
									out.printf("%d %d %d %d %d %d\n", numbers[i], numbers[j], numbers[k], numbers[l], numbers[m], numbers[p]);
								}
							}
						}
					}
				}
			}
		}
		out.flush();
		out.close();
	}
}