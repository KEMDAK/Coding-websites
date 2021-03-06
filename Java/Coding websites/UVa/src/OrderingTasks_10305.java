import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class OrderingTasks_10305 {

	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static Stack<Integer> order;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(true){
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			int n = Integer.parseInt(s.nextToken());
			int m = Integer.parseInt(s.nextToken());
			
			if(n == 0 && m == 0)
				break;
			
			adj = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int j = 0; j < m; j++) {
				s = new StringTokenizer(in.readLine());
				
				int src = Integer.parseInt(s.nextToken()) - 1;
				int dest = Integer.parseInt(s.nextToken()) - 1;
				
				adj[src].add(dest);
			}
			
			visited = new boolean[n];
			order = new Stack<>();
			for (int i = 0; i < n; i++) {
				if(!visited[i])
					dfs(i);
			}
			
			for (int i = 0; i < n - 1; i++)
				out.print((order.pop() + 1) + " ");
			out.println((order.pop() + 1));
		}
		
		out.flush();
		out.close();
	}

	public static void dfs(int i) {
		visited[i] = true;
		
		for (int v : adj[i]) {
			if (!visited[v])
				dfs(v);
		}
		
		order.push(i);
	}
}
