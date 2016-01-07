import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

class PlayingWithBalls {
	static long odds = 0;
	static long space = 0;

	public static void trick(long w, long b) {
		if (w < 0 || b < 0)
			return;
		if (w + b < 2) {
			if (w == 0 && b == 1)
				odds++;
			space++;
			return;
		}
		trick(w + 1, b - 2);
		trick(w - 1, b);
		trick(w - 1, b);
	}

	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			int c = Integer.parseInt(in.readLine());
			for (int i = 0; i < c; i++) {
				StringTokenizer s = new StringTokenizer(in.readLine());
				long w = Integer.parseInt(s.nextToken());
				long b = Long.parseLong(s.nextToken());
				odds = 0;
				space = 0;
				trick(w, b);
				double result = odds / (space * 1.0);
				DecimalFormat d = new DecimalFormat("0.000000");
				System.out.println(d.format(result));
			}
		} catch (Exception e) {
			return;
		}
	}
}
