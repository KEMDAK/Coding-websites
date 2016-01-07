import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class pos implements Comparable<pos> {
	int i, j, T;

	public pos(int i, int j, int T) {
		this.i = i;
		this.j = j;
		this.T = T;
	}

	public int compareTo(pos o) {
		if (this.T > o.T)
			return -1;
		if (this.T < o.T)
			return 1;
		return 0;
	}
}

class LuciusDungeon {

	static int[][] hp;
	static boolean[][] used;

	public static void canIHelp(int a, int b, int t) {

		PriorityQueue<pos> q = new PriorityQueue<pos>();
		q.add(new pos(0, 0, t - hp[0][0]));
		while (!q.isEmpty()) {
			pos p = q.remove();
			used[p.i][p.j] = true;
			if (p.T >= 0) {
				// System.out.println(p.i + " "+ p.j +" "+ p.T);
				if (p.i - 1 > 0 && !used[p.i - 1][p.j])
					q.add(new pos(p.i - 1, p.j, p.T - hp[p.i - 1][p.j]));
				if (p.j - 1 > 0 && !used[p.i][p.j - 1])
					q.add(new pos(p.i, p.j - 1, p.T - hp[p.i][p.j - 1]));
				if (p.i + 1 < hp.length && !used[p.i + 1][p.j])
					q.add(new pos(p.i + 1, p.j, p.T - hp[p.i + 1][p.j]));
				if (p.j + 1 < hp[p.i].length && !used[p.i][p.j + 1])
					q.add(new pos(p.i, p.j + 1, p.T - hp[p.i][p.j + 1]));
			}
			if (p.i == a && p.j == b && p.T >= 0) {
				System.out.println("YES\n" + p.T);
				return;
			}

		}
		System.out.println("NO");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
		for (int i = 0; i < cases; i++) {
			StringTokenizer s = new StringTokenizer(in.readLine());
			int m = Integer.parseInt(s.nextToken());
			int n = Integer.parseInt(s.nextToken());
			hp = new int[m][n];
			used = new boolean[m][n];
			for (int j = 0; j < hp.length; j++) {
				s = new StringTokenizer(in.readLine());
				for (int k = 0; k < hp[j].length; k++) {
					hp[j][k] = Integer.parseInt(s.nextToken());
				}
			}
			s = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(s.nextToken());
			int b = Integer.parseInt(s.nextToken());
			int t = Integer.parseInt(s.nextToken());
			if (i == 0)
				System.out.println("");
			canIHelp(a - 1, b - 1, t);
		}
	}
}
