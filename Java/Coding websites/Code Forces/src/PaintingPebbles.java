import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PaintingPebbles {

	static int[][] res;
	static int n, k, max, min;
	static String s;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer m = new StringTokenizer(in.readLine());
		n = Integer.parseInt(m.nextToken());
		k = Integer.parseInt(m.nextToken());
		s = in.readLine();
		m = new StringTokenizer(s);
		max = -1;
		min = 101;
		res = new int[n][];
		for (int i = 0; i < n; i++) {
			int l = Integer.parseInt(m.nextToken());
			if (l > max)
				max = l;
			if (l < min)
				min = l;
			res[i] = new int[l];
		}
		System.out.println(paint());
	}

	private static String paint() {
		if (max - k > min) {
			return "NO";
		}
		String f = "YES\n";
		for (int i = 0; i < res.length; i++) {
			if (res[i].length <= k) {
				int c = 1;
				for (int j = 0; j < res[i].length; j++) {
					res[i][j] = c++;
					f += res[i][j] + " ";
				}
			} else {
				int c = 1;
				int o = res[i].length - k;
				for (int j = 0; j < res[i].length; j++) {
					if (o >= 1) {
						if (c > k) {
							c %= k;
							res[i][j] = c++;
						} else {
							res[i][j] = c;
						}
						f += res[i][j] + " ";
						j++;
						o--;
					}
					if (j < res[i].length) {
						res[i][j] = c++;
						f += res[i][j] + " ";
					}
				}
			}
			f += "\n";
		}
		return f;
	}
}
