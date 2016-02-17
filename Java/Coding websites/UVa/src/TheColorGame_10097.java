import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TheColorGame_10097 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int test = 1;
		
		while(true){
			int n = Integer.parseInt(in.readLine());
			
			if(n == 0)
				break;
			
			ArrayList<Edge>[] adj = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < n; i++) {
				StringTokenizer s = new StringTokenizer(in.readLine());
				
				for (int j = 0; j < n; j++) {
					int dest = Integer.parseInt(s.nextToken()) - 1;
					
					if(dest == -1) continue;
					
					adj[i].add(new Edge(dest, j));
				}
			}
			
			StringTokenizer s = new StringTokenizer(in.readLine());
			int N1 = Integer.parseInt(s.nextToken()) - 1;
			int N2 = Integer.parseInt(s.nextToken()) - 1;
			int N3 = Integer.parseInt(s.nextToken()) - 1;
			
			int[][] dist = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(dist[i], 2000000000);
			}
			Queue<Token> q = new LinkedList<Token>();
			q.add(new Token(N1, N2));
			dist[N1][N2] = 0;
			
			int res = -1;
			
			while(!q.isEmpty()){
				Token t = q.poll();
				
				if(t.t1 == N3 || t.t2 == N3){
					res = dist[t.t1][t.t2];
					break;
				}
				
				for (int i = 0; i < adj[t.t1].size(); i++) {
					Edge v = adj[t.t1].get(i);
					if(dist[v.dest][t.t2] == 2000000000 && v.color == t.t2){
						dist[v.dest][t.t2] = dist[t.t1][t.t2] + 1;
						q.add(new Token(v.dest, t.t2));
					}
				}
				
				for (int i = 0; i < adj[t.t2].size(); i++) {
					Edge v = adj[t.t2].get(i);
					if(dist[t.t1][v.dest] == 2000000000 && v.color == t.t1){
						dist[t.t1][v.dest] = dist[t.t1][t.t2] + 1;
						q.add(new Token(t.t1, v.dest));
					}
				}
			}
			
			out.printf("Game #%d\n", test++);
			if(res == -1)
				out.printf("Destination is Not Reachable !\n");
			else
				out.printf("Minimum Number of Moves = %d\n", res);
			
			out.println();
		}
		
		out.flush();
		out.close();
	}
	
	private static class Token{
		int t1, t2;
		
		public Token(int t1, int t2){
			this.t1 = t1;
			this.t2 = t2;
		}
	}
	
	private static class Edge{
		int dest, color;
		
		public Edge(int dest, int color){
			this.dest = dest;
			this.color = color;
		}
	}
}
