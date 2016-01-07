import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class DominoEffect_318 {

	static int[][] adj;
	static double[] visitingtTime;
//	static int[] color;
	static double totaltime;

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		for (int system = 1; true; system++) {
			String line = in.readLine();

			if(line.equals("0 0"))
				break;

			StringTokenizer s = new StringTokenizer(line);

			int n, m;

			n = Integer.parseInt(s.nextToken());
			m = Integer.parseInt(s.nextToken());

			adj = new int[n][n];
			visitingtTime = new double[n];
//			color = new int[n];

			for (int i = 0; i < adj.length; i++) 
				Arrays.fill(adj[i], -1);

			Arrays.fill(visitingtTime, -1);

			for (int i = 0; i < m; i++){
				s = new StringTokenizer(in.readLine());

				int a, b, l;

				a = Integer.parseInt(s.nextToken()) - 1;
				b = Integer.parseInt(s.nextToken()) - 1;
				l = Integer.parseInt(s.nextToken());

				adj[a][b] = l;
				adj[b][a] = l;
			}
			
			totaltime = 0;

			bfs();

			out.println(totaltime);
		}
		
		out.flush();
		out.close();
	}

	public static void bfs() {
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.add(new Node(0, 0));
		
		HashSet<Double> doneLevels = new HashSet<Double>();
		
		while(!q.isEmpty()){
			Node src = q.remove();

			if(visitingtTime[src.node] != -1) continue;
			
			visitingtTime[src.node] = src.vTime;
			
			for (int i = 0; i < adj[src.node].length; i++) {
				if(adj[src.node][i] != -1){
					
					if(visitingtTime[i] == -1){
						q.add(new Node(i, visitingtTime[src.node] + adj[src.node][i]));
					}
					else if((visitingtTime[src.node] < adj[src.node][i] + visitingtTime[i] && visitingtTime[src.node] > visitingtTime[i]) || visitingtTime[src.node] == visitingtTime[i]){
						totaltime += (adj[src.node][i] - Math.abs(visitingtTime[i] - visitingtTime[src.node])) / 2 * 1.0;
					}
					else if((!doneLevels.contains(src.vTime)) && (visitingtTime[src.node] != visitingtTime[i] + adj[src.node][i] || visitingtTime[src.node] >= totaltime)){ 
							totaltime += adj[src.node][i];
							doneLevels.add(src.vTime);
					}
				}
			}
		}
	}
}

class Node implements Comparable<Node>{
	int node;
	double vTime;
	
	public Node(int node, double vTime) {
		this.node = node;
		this.vTime = vTime;
	}

	@Override
	public int compareTo(Node n) {
		if(vTime > n.vTime)
			return 1;
		else if(vTime < n.vTime)
			return -1;
		else
			return 0;
	}
	
	@Override
	public String toString() {
		return "(" + node + ", " + vTime + ")";
	}
	
}






















