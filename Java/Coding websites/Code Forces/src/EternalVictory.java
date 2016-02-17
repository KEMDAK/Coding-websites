import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EternalVictory {

	static ArrayList<Edge>[] adj;
	static int[] parent;
	static int counter, n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());

		adj = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer s = new StringTokenizer(in.readLine());

			int src = Integer.parseInt(s.nextToken()) - 1;
			int dest = Integer.parseInt(s.nextToken()) - 1;
			int cost = Integer.parseInt(s.nextToken());

			adj[src].add(new Edge(dest, cost));
			adj[dest].add(new Edge(src, cost));
		}

		parent = new int[n];
		java.util.Arrays.fill(parent, -1);
		counter = 0;
		long res = dfs(0);

		System.out.println(res);
	}

	public static long dfs(int i) {
		counter++;
		if(counter == n)
			return 0;
		if(adj[i].size() == 1 && adj[i].get(0).dest == parent[i])
			return 0;

		long res = 0;
		long max = 0;

		for (Edge e : adj[i]) {
			if(parent[i] == e.dest) continue;
			
			parent[e.dest] = i;
			long cur = dfs(e.dest) + e.cost;
System.out.println("i: " + (i + 1) + " v: " + (e.dest + 1) + " " + cur);
//			if(cur >= max){
//				if(max != 1000000)
//					res += max * 2;
//				max = cur;
			res += cur * 2;
//			}
		}
		
		return res;// + (max * 2);
	}

	static class Edge{
		int dest, cost;

		public Edge(int dest, int cost){
			this.dest = dest;
			this.cost = cost;
		}
	}
}
