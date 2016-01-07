import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class FavoriteDice {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(in.readLine());
		for (int i = 0; i < c; i++) {
			StringTokenizer s = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(s.nextToken());
			double result = 0;
			DecimalFormat d = new DecimalFormat("#.00");
			for (int j = 1; j <= n; j++) {
				result += n / (j * 1.0);
			}
			System.out.println(d.format(result));
		}
	}

}
