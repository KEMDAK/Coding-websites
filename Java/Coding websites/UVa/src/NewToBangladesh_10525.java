import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NewToBangladesh_10525 {
	
	private static final int INF = 1000000000;
	static int[][] parent;
	static int[][] sTime;
	static int[][] dist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int t = Integer.parseInt(in.readLine());

		while(t-- > 0){
			in.readLine();

			StringTokenizer s = new StringTokenizer(in.readLine());

			int n = Integer.parseInt(s.nextToken());
			int m = Integer.parseInt(s.nextToken());

			ArrayList<road>[] adj = new ArrayList[n];
			parent = new int[n][n];
			sTime = new int[n][n];
			dist = new int[n][n];

			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					parent[i][j] = i;

			for (int i = 0; i < n; i++){
				Arrays.fill(sTime[i], INF);
				sTime[i][i] = 0;
			}

			for (int i = 0; i < m; i++) {
				s = new StringTokenizer(in.readLine());

				int src = Integer.parseInt(s.nextToken()) - 1;
				int dest = Integer.parseInt(s.nextToken()) - 1;
				int time = Integer.parseInt(s.nextToken());
				int length = Integer.parseInt(s.nextToken());
				
				if(sTime[src][dest] > time){
					dist[src][dest] = length;
					sTime[src][dest] = time;
					dist[dest][src] = length;
					sTime[dest][src] = time;
				}
				
				if(sTime[src][dest] == time && dist[src][dest] > length){
					dist[src][dest] = length;
					dist[dest][src] = length;
				}
			}

			for(int k = 0; k < n; k++)
				for(int i = 0; i < n; i++)
					for(int j = 0; j < n; j++)
						if(sTime[i][j] > sTime[i][k] + sTime[k][j]) {
							sTime[i][j] = sTime[i][k] + sTime[k][j];
							dist[i][j] = dist[i][k] + dist[k][j];
							parent[i][j] = parent[k][j];
						}
						else if(sTime[i][j] == sTime[i][k] + sTime[k][j] && dist[i][j] > dist[i][k] + dist[k][j]) {
							dist[i][j] = dist[i][k] + dist[k][j];
							parent[i][j] = parent[k][j];
						}

			int q = Integer.parseInt(in.readLine());

			for (int i = 0; i < q; i++) {
				s = new StringTokenizer(in.readLine());

				int src = Integer.parseInt(s.nextToken()) - 1;
				int dest = Integer.parseInt(s.nextToken()) - 1;

				if(src == dest){
					out.printf("Distance and time to reach destination is %d & %d.\n", 0, 0);
					continue;
				}
				
				if(sTime[src][dest] != INF){
					int length = dist[src][dest];
					out.printf("Distance and time to reach destination is %d & %d.\n", length, sTime[src][dest]);
				}
				else
					out.println("No Path.");
			}

			if(t > 0)
				out.println();
		}

		out.flush();
		out.close();
	}

	static class road{
		int dest, time, length;

		public road(int dest, int time, int length) {
			this.dest = dest;
			this.time = time;
			this.length = length;
		}
	}
}
