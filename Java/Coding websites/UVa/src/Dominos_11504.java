import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Dominos_11504 {

	static ArrayList<Integer>[] adjList;
	static int V, counter, SCC, dfs_num[], dfs_low[];
	static boolean[] inSCC;
	static LinkedList<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = in.nextInt();

		while(t-- > 0){

			int n = in.nextInt();
			int m = in.nextInt();

			adjList = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adjList[i] = new ArrayList<>();
			}
			V = n;
			counter = 0;
			SCC = 0;
			dfs_num = new int[n];
			dfs_low = new int[n];
			inSCC = new boolean[n];
			list = new LinkedList<>();
			
			for (int i = 0; i < m; i++) {
				int src = in.nextInt() - 1;
				int dest = in.nextInt() - 1;

				adjList[src].add(dest);
			}

			
			
			for(int i = 0; i < V; ++i)
				if(dfs_num[i] == 0)
					tarjanSCC(i);

			TreeSet<Integer> set = new TreeSet<>();
			for (int i = 0; i < dfs_low.length; i++) {
				set.add(dfs_low[i]);
			}

			for (int i = 0; i < n; i++) {
				for (int j : adjList[i]) {
					if(dfs_low[i] != dfs_low[j])
						set.remove(dfs_low[j]);
				}
			}
			
			out.println(set.size());
		}

		out.flush();
		out.close();
	}

	public static void tarjanSCC(int u) {
		dfs_num[u] = dfs_low[u] = ++counter;
		list.addFirst(u);

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
				int v = list.removeFirst();
				inSCC[v] = true;
				if(v == u)
					break;
			}
			SCC++;
		}
	}
	
	private static class Scanner {
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