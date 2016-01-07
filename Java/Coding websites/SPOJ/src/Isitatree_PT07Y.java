import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Isitatree_PT07Y {

	static ArrayList<Integer> adj[];
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer s = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(s.nextToken());
		int M = Integer.parseInt(s.nextToken());

		if (M == N - 1) {
			adj = new ArrayList[N];

			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				s = new StringTokenizer(in.readLine());

				int src = Integer.parseInt(s.nextToken()) - 1;
				int dist = Integer.parseInt(s.nextToken()) - 1;

				adj[src].add(dist);
				adj[dist].add(src);
			}

			visited = new boolean[N];

			dfs(0);

			for (int i = 0; i < visited.length; i++) {
				if (!visited[i]) {
					System.out.println("NO");
					return;
				}
			}
			System.out.println("YES");
		} else
			System.out.println("NO");
	}

	public static void dfs(int node) {
		visited[node] = true;

		for (int i = 0; i < adj[node].size(); i++) {
			if (!visited[adj[node].get(i)])
				dfs(adj[node].get(i));
		}
	}
}