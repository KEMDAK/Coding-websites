import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dominator_11902 {

	static boolean[] visited;
	static boolean[] ref;
	static int adj[][];
	static boolean[][] res;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());

		for (int l = 1; l <= T; l++) {

			int N = Integer.parseInt(in.readLine());

			adj = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer s = new StringTokenizer(in.readLine());
				for (int k = 0; s.hasMoreTokens(); k++) {
					int j = Integer.parseInt(s.nextToken());
					adj[i][k] = j;
				}
			}
			ref = new boolean[N];
			visited = new boolean[N];
			res = new boolean[N][N];

			dfs(0);

			for (int i = 0; i < visited.length; i++) {
				if (visited[i])
					res[0][i] = true;
			}
			for (int i = 0; i < visited.length; i++) {
				ref[i] = visited[i];
			}

			for (int i = 0; i < ref.length; i++) {
				if (ref[i]) {
					Arrays.fill(visited, false);
					visited[i] = true;

					dfs(0);

					for (int j = 0; j < visited.length; j++) {
						if ((ref[j] && !visited[j]) || i == j) {
							res[i][j] = true;
						}
					}
				}
			}

			out.println("Case " + l + ":");
			int row = 0;
			int column = 0;
			int size = (2 * N) + 1;

			for (int i = 0; i < size; i++) {
				if (i % 2 == 0) {
					out.print("+");
					for (int j = 0; j < size - 2; j++) {
						out.print("-");
					}
					out.print("+");
				} else {
					column = 0;
					for (int j = 0; j < size; j++) {
						if (j % 2 == 0) {
							out.print("|");
						} else {
							if (res[row][column])
								out.print("Y");
							else
								out.print("N");
							column++;
						}
					}
					row++;
				}
				out.println();
			}
		}

		out.flush();
		out.close();
	}

	public static void dfs(int node) {
		visited[node] = true;

		for (int i = 0; i < adj[node].length; i++) {
			if (adj[node][i] == 1 && !visited[i])
				dfs(i);
		}
	}
}
