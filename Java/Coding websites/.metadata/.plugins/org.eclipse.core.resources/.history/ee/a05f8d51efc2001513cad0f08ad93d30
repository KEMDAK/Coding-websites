import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Party {

	static ArrayList<Integer>[] adj;
	static int[] dist;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int n = Integer.parseInt(in.readLine());
		
		adj = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		ArrayList<Integer> managers = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			int parent = Integer.parseInt(in.readLine()) - 1;
			
			if(parent == -2){
				managers.add(i);
				continue;
			}
			
			adj[parent].add(i);
		}

		int res = 1;
		
		for (int m : managers) {
			dist = new int[n];
			Arrays.fill(dist, -1);

			res = Math.max(res, bfs(m));
		}
		
		out.println(res);
		
		out.flush();
		out.close();
	}

	public static int bfs(int m) {
		Queue<Integer> q = new LinkedList<>();
		q.add(m);
		dist[m] = 1;
		
		while(!q.isEmpty()){
			int u = q.poll();
			
			for (int v : adj[u]) {
				if(dist[v] == -1){
					dist[v] = dist[u] + 1;
					q.add(v);
				}
			}
		}
		
		int max = 0;
		
		for (int i = 0; i < dist.length; i++) {
			max = Math.max(max, dist[i]);
		}
		
		return max;
	}
}
