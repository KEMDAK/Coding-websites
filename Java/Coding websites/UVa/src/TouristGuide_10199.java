import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TouristGuide_10199 {

	static ArrayList<Integer>[] adjList;
	static int[] dfs_low, dfs_num, parent;
	static int counter, root, rootChildren;
	static boolean[] artPoints;
	static int artP;

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = 1;

		while(true){
			int n = in.nextInt();

			if(n == 0)
				break;

			if(t > 1)
				out.println();

			TreeMap<String, Integer> map = new TreeMap<>();
			String[] names = new String[n];

			for (int i = 0; i < n; i++) {
				String s = in.nextLine();

				map.put(s, i);
				names[i] = s;
			}

			adjList = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adjList[i] = new ArrayList<>();
			}
			dfs_low = new int[n];
			dfs_num = new int[n];
			parent = new int[n];
			artPoints = new boolean[n];
			counter = 0;
			artP = 0;

			int m = in.nextInt();

			for (int i = 0; i < m; i++) {
				int src = map.get(in.Next());
				int dest = map.get(in.Next());

				adjList[src].add(dest);
				adjList[dest].add(src);
			}

			for(int i = 0; i < n; ++i)
				if(dfs_num[i] == 0)
				{
					root = i;
					rootChildren = 0;
					dfs(i);	
					artPoints[i] = rootChildren > 1;
				}

			for (int i = 0; i < n; i++) {
				if(artPoints[i])
					artP++;
			}

			ArrayList<String> res = new ArrayList<>();

			out.printf("City map #%d: %d camera(s) found\n", t++, artP);
			for (int i = 0; i < n; i++) {
				if(artPoints[i])
					res.add(names[i]);
			}

			Collections.sort(res);
			for (String s : res) {
				out.println(s);				
			}

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
