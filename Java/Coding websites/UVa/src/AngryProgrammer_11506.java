import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AngryProgrammer_11506 {

	static int V, SRC, DEST;
	static int[][] res;
	static ArrayList<Integer>[] adj;
	static int[] ptr;
	static int[] dist;
	static int MF;
	static final int INF = (int) 2e9;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while(true){
			int M = sc.nextInt();
			int W = sc.nextInt();

			if(M == 0 && W == 0)
				break;
			
			V = M * 2;
			SRC = 0;
			DEST = V - 2;

			res = new int[V][V];
			adj = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adj[i] = new ArrayList<>();
			
			for (int i = 0; i < M - 2; i++) {
				int node = sc.nextInt() - 1;
				int cost = sc.nextInt();
				
				adj[in(node)].add(out(node));
				adj[out(node)].add(in(node));
				res[in(node)][out(node)] = cost;
				res[out(node)][in(node)] = 0;
			}
			
			adj[0].add(1);
			adj[1].add(0);
			res[0][1] = INF;
			res[1][0] = 0;
			adj[V - 2].add(V - 1);
			adj[V - 1].add(V - 2);
			res[V - 2][V - 1] = INF;
			res[V - 1][V - 2] = 0;
			
			for (int i = 0; i < W; i++) {
				int src = sc.nextInt() - 1;
				int dest = sc.nextInt() - 1;
				int cost = sc.nextInt();
				
				adj[out(src)].add(in(dest));
				adj[in(src)].add(out(dest));
				adj[out(dest)].add(in(src));
				adj[in(dest)].add(out(src));
				res[out(src)][in(dest)] = cost;
				res[in(src)][out(dest)] = 0;
				res[out(dest)][in(src)] = cost;
				res[in(dest)][out(src)] = 0; 
			}
			
			long res = maxFlow();
			
			out.println(res);
		}
		
		out.flush();
		out.close();
	}
	
	public static long maxFlow() {
		MF = 0;
		while(bfs()){
			while(true){
				ptr = new int[V];
				long f = dfs(SRC, INF);
				
				if(f == 0) break;
				
				MF += f;
			}
		}
		
		return MF;
	}

	public static long dfs(int u, int flow) {
		if(u == DEST)
			return flow;
		
		for (; ptr[u] < adj[u].size(); ptr[u]++) {
			int v = adj[u].get(ptr[u]);
			if(dist[u] + 1 == dist[v] && res[u][v] > 0){
				long f = dfs(v, Math.min(flow, res[u][v]));
				
				if(f > 0){
					res[u][v] -= f;
					res[v][u] += f;
					
					return f;
				}
			}
		}
		
		return 0;
	}

	public static boolean bfs() {
		dist = new int[V];
		Arrays.fill(dist, -1);
		dist[SRC] = 0;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(SRC);
		
		while(!q.isEmpty()){
			int u = q.poll();
			
			if(u == DEST)
				return true;
			
			for (Integer v : adj[u]) {
				if(dist[v] == -1 && res[u][v] > 0){
					dist[v] = dist[u] + 1;
					q.add(v);
				}
			}
		}
		
		return false;
	}

	public static int in(int node){
		return (node * 2);
	}
	
	public static int out(int node){
		return (node * 2) + 1;
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(FileReader f) {
			br = new BufferedReader(f);
		}

		public Scanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		public String Next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(Next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(Next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(Next());
		}

		public boolean Ready() throws IOException {
			return br.ready();
		}

		public void waitForInput(long time) {
			long ct = System.currentTimeMillis();
			while(System.currentTimeMillis() - ct < time) {};
		}

	}
}
