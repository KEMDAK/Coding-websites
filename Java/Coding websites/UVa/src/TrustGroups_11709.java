import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TrustGroups_11709 {

	static ArrayList<Integer>[] adjList;
	static int V, counter, SCC, dfs_num[], dfs_low[];
	static boolean[] inSCC;
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while(true){
			StringTokenizer s = new StringTokenizer(in.readLine());

			V = Integer.parseInt(s.nextToken());
			int E = Integer.parseInt(s.nextToken());

			if(V == 0 && E == 0)
				break;
			
			TreeMap<String, Integer> map = new TreeMap<>();

			for (int i = 0; i < V; i++){
				s = new StringTokenizer(in.readLine());
				map.put(s.nextToken() + s.nextToken(), i);
			}

			adjList = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<>();
			counter = 0;
			SCC = 0;
			dfs_num = new int[V];
			dfs_low = new int[V];
			inSCC = new boolean[V];
			stack = new Stack<>();
			
			for (int i = 0; i < E; i++) {
				s = new StringTokenizer(in.readLine());
				int src = map.get(s.nextToken() + s.nextToken());
				s = new StringTokenizer(in.readLine());
				int dest = map.get(s.nextToken() + s.nextToken());
				
				adjList[src].add(dest);
			}

			for(int i = 0; i < V; ++i)
				if(dfs_num[i] == 0)
					tarjanSCC(i);
			
			out.println(SCC);
		}
		
		out.flush();
		out.close();
	}
	
    static void tarjanSCC(int u) {
	dfs_num[u] = dfs_low[u] = ++counter;
	stack.push(u);

	for(int v: adjList[u]) {
	    if(dfs_num[v] == 0)
		tarjanSCC(v);
	    if(!inSCC[v])
		dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);	
	}
	if(dfs_num[u] == dfs_low[u]) {
	    //SCC found
	    while(true)
	    {
    		int v = stack.pop();
    		inSCC[v] = true;
    		if(v == u)
    		    break;
    	    }
    	  SCC++;
	}


    }
}
