import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GraphConnectivity_459 {
	static ArrayList<Integer> adj[];
	static boolean visited[];

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		br.readLine();
		while (t-- > 0) {

			char c = br.readLine().charAt(0);
			int n = c - 'A';
			n++;

			adj = new ArrayList[n];

			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<>();
			}

			while (br.ready()) {
				String line = br.readLine();
				if (line.isEmpty())
					break;
				int first = line.charAt(0) - 'A';
				int second = line.charAt(1) - 'A';

				adj[first].add(second);
				adj[second].add(first);
			}

			visited = new boolean[n];
			int count = 0;
			for (int i = 0; i < visited.length; i++) {
				if (!visited[i]) {
					count++;
					dfs(i);
				}
			}

			System.out.println(count);
			if (t > 0)
				System.out.println();

		}
	}

	public static void dfs(int node) {
		visited[node] = true;

		for (int i = 0; i < adj[node].size(); i++) {
			if (!visited[adj[node].get(i)])
				dfs(adj[node].get(i));
		}
	}
}
