import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class StreetDirections_610 {

	static ArrayList<Integer>[] adjList;
	static int[] dfs_low, dfs_num, parent;
	static int V, counter;
	static TreeSet<Edge> set;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int t = 1;

		while(true){
			StringTokenizer s = new StringTokenizer(in.readLine());

			int n = Integer.parseInt(s.nextToken());
			int m = Integer.parseInt(s.nextToken());

			if(n == 0 && m == 0)
				break;

			V = n;

			adjList = new ArrayList[V];
			for (int i = 0; i < V; i++) {
				adjList[i] = new ArrayList<>();
			}

			for (int i = 0; i < m; i++) {
				s = new StringTokenizer(in.readLine());

				int src = Integer.parseInt(s.nextToken()) - 1;
				int dest = Integer.parseInt(s.nextToken()) - 1;

				adjList[src].add(dest);
				adjList[dest].add(src);
			}

			parent = new int[V];
			dfs_low = new int[V];
			dfs_num = new int[V];
			set = new TreeSet<>();
			counter = 0;

			for(int i = 0; i < V; ++i)
				if(dfs_num[i] == 0)
					dfs(i);

			out.println(t++ + "\n");

			for (Edge edge : set) {
				out.println((edge.src + 1) + " " + (edge.dest + 1));
			}

			out.println("#");
		}

		out.flush();
		out.close();
	}

	static void dfs(int u) {
		dfs_num[u] = dfs_low[u] = ++counter;
		for(int v: adjList[u]){
			if(dfs_num[v] == 0)
			{
				parent[v] = u;
				set.add(new Edge(u, v));

				dfs(v);

				if(dfs_low[v] > dfs_num[u]){
					set.add(new Edge(v, u));
				}

				dfs_low[u] = Math.min(dfs_low[v], dfs_low[u]);
			}
			else
				if(parent[u] != v){
					dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);

					if(dfs_num[u] <= dfs_num[v]){
						set.remove(new Edge(u, v));
					}
					else
						set.add(new Edge(u, v));
				}
		}
	}

	static class Edge implements Comparable<Edge>{
		int src, dest;

		public Edge(int src, int dest) {
			this.src = src;
			this.dest = dest;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.src != o.src)
				return this.src - o.src;
			return this.dest - o.dest;
		}

		@Override
		public String toString() {
			return this.src + " " + this.dest;
		}
	}
}
