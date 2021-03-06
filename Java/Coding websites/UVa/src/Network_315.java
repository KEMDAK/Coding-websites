import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Network_315 {
	
    static ArrayList<Integer>[] adjList;
    static int[] dfs_low, dfs_num, parent;
    static int V, counter, root, rootChildren;
    static boolean[] artPoints;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(true){
			int n = Integer.parseInt(in.readLine());
			
			if(n == 0)
				break;
			
			adjList = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adjList[i] = new ArrayList<>();
			dfs_low = new int[n];
			dfs_num = new int[n];
			parent = new int[n];
			artPoints = new boolean[n];
			V = n;
			counter = 0;
			
			while(true){
				StringTokenizer s = new StringTokenizer(in.readLine());
				
				int src = Integer.parseInt(s.nextToken()) - 1;
				
				if(src == -1)
					break;
				
				while(s.hasMoreTokens()){
					int dest = Integer.parseInt(s.nextToken()) - 1;
					
					adjList[src].add(dest);
					adjList[dest].add(src);
				}
			}
			
			for(int i = 0; i < V; ++i)
			    if(dfs_num[i] == 0){
				root = i;
				rootChildren = 0;
				dfs(i);	
				artPoints[i] = rootChildren > 1;
			    }
			
			int res = 0;
			for (int i = 0; i < artPoints.length; i++)
				if(artPoints[i])
					res++;
			
			out.println(res);
		}
		
		out.flush();
		out.close();
	}

	public static void dfs(int u) {
		dfs_num[u] = dfs_low[u] = ++counter;
		for(int v: adjList[u])
		    if(dfs_num[v] == 0)
		    {
			parent[v] = u;
			if (u == root)
			    rootChildren++;
			dfs(v);
			if(dfs_low[v] >= dfs_num[u])
			    artPoints[u] = true;
			dfs_low[u] = Math.min(dfs_low[v], dfs_low[u]);
		    }
		    else
			if(parent[u] != v)
			    dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
	    }
}
