import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Wormholes_558 {


	private static final int INF = 1000000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int t = Integer.parseInt(in.readLine());

		while(t-- > 0){
			StringTokenizer s = new StringTokenizer(in.readLine());

			int n = Integer.parseInt(s.nextToken());
			int m = Integer.parseInt(s.nextToken());

			ArrayList<Edge>[] adj = new ArrayList[n];
			for (int i = 0; i < n; i++) 
				adj[i] = new ArrayList<>();

			for (int i = 0; i < m; i++) {
				s = new StringTokenizer(in.readLine());

				int src = Integer.parseInt(s.nextToken());
				int dest = Integer.parseInt(s.nextToken());
				int cost = Integer.parseInt(s.nextToken());

				adj[src].add(new Edge(dest, cost));
			}

			int[] dist = new int[n];
			Arrays.fill(dist, INF);
			dist[0] = 0;
			boolean modified = true;
			for(int k = 0; modified && k < n - 1; ++k)
			{
				modified = false;
				for(int u = 0; u < n; ++u)
					for(Edge nxt: adj[u])	
						if(dist[u] + nxt.cost < dist[nxt.dest])
						{
							modified = true;
							dist[nxt.dest] = dist[u] + nxt.cost;
						}
			}

			boolean negative_cycle_exists = false;
			for(int u = 0; u < n; ++u)
				for(Edge nxt: adj[u])
					if(dist[u] + nxt.cost < dist[nxt.dest])
						negative_cycle_exists = true;
			
			out.println(negative_cycle_exists? "possible" : "not possible");
		}
		
		out.flush();
		out.close();
	}

	static class Edge{
		int dest, cost;

		public Edge(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}
}

