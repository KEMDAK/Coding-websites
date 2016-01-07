import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class BitMap {

	static int[][] graph;
	static int[][] cost;
	static int[][] visited;

	public static void distance(int i, int j, int c, int io, int jo) {
		if (i < 0 || i >= cost.length || j < 0 || j >= cost[i].length
				|| (visited[i][j] != -1)) {
			return;
		}
		visited[i][j] = c;
		if (cost[i][j] == 0) {
			cost[io][jo] = c;
			return;
		}
		if (!around(i, j, io, jo, c)) {
			distance(i + 1, j, c + 1, io, jo);
			distance(i - 1, j, c + 1, io, jo);
			distance(i, j + 1, c + 1, io, jo);
			distance(i, j - 1, c + 1, io, jo);
		} else
			return;
	}

	private static boolean around(int i, int j, int io, int jo, int c) {
		if (i + 1 < cost.length && cost[i + 1][j] == 0) {
			cost[i][j] = 1;
			cost[io][jo] = c + 1;
			return true;
		}
		if (i - 1 >= 0 && cost[i - 1][j] == 0) {
			cost[i][j] = 1;
			cost[io][jo] = c + 1;
			return true;
		}
		if (j + 1 < cost[i].length && cost[i][j + 1] == 0) {
			cost[i][j] = 1;
			cost[io][jo] = c + 1;
			return true;
		}
		if (j - 1 >= 0 && cost[i][j - 1] == 0) {
			cost[i][j] = 1;
			cost[io][jo] = c + 1;
			return true;
		}
		if (i + 1 < cost.length && cost[i + 1][j] > 0) {
			cost[i][j] = cost[i + 1][j] + 1;
			return true;
		}
		if (i - 1 >= 0 && cost[i - 1][j] > 0) {
			cost[i][j] = cost[i - 1][j] + 1;
			return true;
		}
		if (j + 1 < cost[i].length && cost[i][j + 1] > 0) {
			cost[i][j] = cost[i][j + 1] + 1;
			return true;
		}
		if (j - 1 >= 0 && cost[i][j - 1] > 0) {
			cost[i][j] = cost[i][j - 1] + 1;
			return true;
		}

		return false;
	}

	public static String bitMap(int x[][]) {
		String f = "";
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				if (x[i][j] == 1)
					cost[i][j] = 0;
			}
		}
		for (int i = 0; i < cost.length; i++) {
			for (int j = 0; j < cost[i].length; j++) {
				for (int k = 0; k < visited.length; k++) {
					Arrays.fill(visited[k], -1);
				}
				if (cost[i][j] == -1) {
					distance(i, j, 0, i, j);
				}
			}
		}
		for (int i = 0; i < cost.length; i++) {
			int j;
			for (j = 0; j < cost[i].length - 1; j++) {
				f += cost[i][j] + " ";
			}
			f += cost[i][j];
			f += "\n";
		}
		return f;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		String f = "";
		for (int i = 0; i < t; i++) {
			StringTokenizer s = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(s.nextToken());
			int m = Integer.parseInt(s.nextToken());
			graph = new int[n][m];
			cost = new int[n][m];
			visited = new int[n][m];
			for (int j = 0; j < n; j++) {
				Arrays.fill(cost[j], -1);
			}
			for (int j = 0; j < n; j++) {
				String st = in.readLine();
				for (int k = 0; k < st.length(); k++) {
					graph[j][k] = st.charAt(k) - '0';
				}
			}
			f += bitMap(graph);
			System.out.println();
		}
		System.out.println(f);

	}

}
