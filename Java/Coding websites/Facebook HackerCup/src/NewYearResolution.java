import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NewYearResolution {

	static int gP, gC, gF;

	public static boolean diet(int p, int c, int f, int[][] a, int i) {
		if ((p > gP || c > gC || f > gF))
			return false;
		if ((p == gP && c == gC && f == gF))
			return true;
		if (i == a.length)
			return false;
		return diet(p + a[i][0], c + a[i][1], f + a[i][2], a, i + 1)
				|| diet(p, c, f, a, i + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		int t = Integer.parseInt(s.nextToken());
		String r = "";
		for (int i = 1; i <= t; i++) {
			s = new StringTokenizer(in.readLine());
			gP = Integer.parseInt(s.nextToken());
			gC = Integer.parseInt(s.nextToken());
			gF = Integer.parseInt(s.nextToken());
			s = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(s.nextToken());
			int meals[][] = new int[n][3];
			for (int j = 0; j < n; j++) {
				s = new StringTokenizer(in.readLine());
				for (int k = 0; k < 3; k++) {
					meals[j][k] = Integer.parseInt(s.nextToken());
				}
			}
			r += ("Case #" + i + ": " + (diet(0, 0, 0, meals, 0) ? "yes" : "no"))
					+ "\n";
		}
		System.out.println("\n" + r);
	}
}
