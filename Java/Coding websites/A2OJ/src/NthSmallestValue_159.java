import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NthSmallestValue_159 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());

		while (T-- > 0) {
			int[] arr = new int[10];

			StringTokenizer s = new StringTokenizer(in.readLine());

			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(s.nextToken());
			}

			Arrays.sort(arr);

			out.println(arr[1]);
		}

		out.flush();
		out.close();
	}
}
