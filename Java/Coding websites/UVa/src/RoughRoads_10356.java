import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class RoughRoads_10356 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int t = 1;

		while(in.ready()){
			StringTokenizer s = new StringTokenizer(in.readLine());

			int n = Integer.parseInt(s.nextToken());
			int r = Integer.parseInt(s.nextToken());

			int[][] adj = new int[n][n];
			for (int i = 0; i < r; i++) {
				s = new StringTokenizer(in.readLine());

				int src = Integer.parseInt(s.nextToken());
				int dest = Integer.parseInt(s.nextToken());
				int cost = Integer.parseInt(s.nextToken());

				adj[src][dest] = cost;
				adj[dest][src] = cost;
			}

			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0, false));
			int[] costC = new int[n];
			int[] costW = new int[n];
			Arrays.fill(costC, -1);
			Arrays.fill(costW, -1);

			costW[0] = 0;
			while(!pq.isEmpty()){
				Node cur = pq.poll();
				if(!cur.state && cur.name == n - 1) break;
				if(!cur.state){
					if(costW[cur.name] != -1 && cur.cost > costW[cur.name]) continue;
				}
				else if(costC[cur.name] != -1 && cur.cost > costC[cur.name]) continue;

				for (int i = 0; i < n; i++) {
					if(adj[cur.name][i] != 0){

						if(!cur.state){
							if(costC[i] == -1 || costC[i] > cur.cost + adj[cur.name][i]){
								costC[i] = cur.cost + adj[cur.name][i];
								pq.add(new Node(i, cur.cost + adj[cur.name][i], !cur.state));
							}
						}
						else{
							if(costW[i] == -1 || costW[i] > cur.cost + adj[cur.name][i]){
								costW[i] = cur.cost + adj[cur.name][i];
								pq.add(new Node(i, cur.cost + adj[cur.name][i], !cur.state));
							}
						}
					}
				}
			}

			out.printf("Set #%d\n%s\n", t++, costW[n - 1] == -1 ? "?" : costW[n - 1] + "");
		}

		out.flush();
		out.close();
	}

	static class Node implements Comparable<Node>{
		int name, cost;
		boolean state;

		public Node(int name, int cost, boolean state) {
			this.name = name;
			this.cost = cost;
			this .state = state;
		}

		@Override
		public int compareTo(Node o) {
			if(this.cost != o.cost)
				return this.cost - o.cost;
			return o.name - this.name;
		}

		@Override
		public String toString() {
			return "(" + name + ", " + cost + ", " + state + ")";
		}
	}
}
