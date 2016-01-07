import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LongestPathInATree_PT07Z {

	static ArrayList<Integer>[] adj;
	static int[] dist;
	static Queue<Integer> next;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		adj = new ArrayList[N];

		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer s = new StringTokenizer(in.readLine());
			int first = Integer.parseInt(s.nextToken()) - 1;
			int second = Integer.parseInt(s.nextToken()) - 1;

			adj[first].add(second);
			adj[second].add(first);
		}

		dist = new int[N];

		next = new LinkedList<Integer>();

		int max = -1;
		int maxIndex = -1;

		Arrays.fill(dist, -1);

		for (int i = 0; i < adj.length; i++) {
			if (adj[i].size() == 1) {

				bfs(i);
				break;
			}
		}

		for (int j = 0; j < dist.length; j++) {
			if (dist[j] > max) {
				max = dist[j];
				maxIndex = j;
			}
		}

		Arrays.fill(dist, -1);

		bfs(maxIndex);

		max = -1;

		for (int j = 0; j < dist.length; j++) {
			if (dist[j] > max) {
				max = dist[j];
				maxIndex = j;
			}
		}

		System.out.println(max);
	}

	public static void bfs(int node) {
		next.add(node);

		dist[node] = 0;

		while (!next.isEmpty()) {
			int s = next.remove();

			for (int i = 0; i < adj[s].size(); i++) {
				if (dist[adj[s].get(i)] == -1) {
					next.add(adj[s].get(i));
					dist[adj[s].get(i)] = dist[s] + 1;
				}
			}
		}
	}
}
