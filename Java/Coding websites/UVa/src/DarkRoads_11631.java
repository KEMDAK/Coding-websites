import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DarkRoads_11631 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(true){
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			int n = Integer.parseInt(s.nextToken());
			int m = Integer.parseInt(s.nextToken());
			
			if(n == 0 && m == 0)
				break;
			
			ArrayList<Edge>[] adj = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adj[i] = new ArrayList<>();
			}
			
			long total = 0;
			
			for (int i = 0; i < m; i++) {
				s = new StringTokenizer(in.readLine());
				
				int src = Integer.parseInt(s.nextToken());
				int dest = Integer.parseInt(s.nextToken());
				int cost = Integer.parseInt(s.nextToken());
				
				total += cost;
				
				adj[src].add(new Edge(src, dest, cost));
				adj[dest].add(new Edge(dest, src, cost));
			}
		
			PriorityQueue<Edge> pq = new PriorityQueue<>(m + 2);
			pq.add(new Edge(0, 0, 0));
			boolean[] visited = new boolean[n];
			long res = 0;
			
			while(!pq.isEmpty()){
				Edge cur = pq.poll();
				if(visited[cur.dest])
					continue;
				visited[cur.dest] = true;

				res += cur.cost;
				
				for (Edge e : adj[cur.dest]) {
					if(!visited[e.dest])
						pq.add(e);
				}
			}
			
			out.println(total - res);
		}
		
		out.flush();
		out.close();
	}
	
	static class Edge implements Comparable<Edge>{
		int src, dest, cost;

		public Edge(int src, int dest, int cost) {
			this.src = src;
			this.dest = dest;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.cost != o.cost)
				return this.cost - o.cost;
			if(this.src != o.src)
				return this.src - o.src;
			return this.dest - o.dest;
		}

		@Override
		public String toString() {
			return "(" + this.src + ", " + this.dest + ")";
		}
	}
}
