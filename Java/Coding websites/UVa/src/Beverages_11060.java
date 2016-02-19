import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Beverages_11060 {

	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int T = 1;
		
		while(in.Ready()){
			int n = in.nextInt();
			
			TreeMap<String, Integer> map = new TreeMap<>();
			String[] revMap = new String[n];
			
			for (int i = 0; i < n; i++) {
				String name = in.next();
				
				map.put(name, i);
				revMap[i] = name;
			}
			
			ArrayList<Integer>[] adj = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adj[i] = new ArrayList<>();
			}
			int[] inDegree = new int[n];
			
			int m = in.nextInt();
			
			for (int i = 0; i < m; i++) {
				int src = map.get(in.next());
				int dest = map.get(in.next());
				
				adj[src].add(dest);
				inDegree[dest]++;
			}
			
			ArrayList<Integer> result = new ArrayList<>();
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			for (int i = 0; i < n; i++) {
				if(inDegree[i] == 0)
					pq.add(i);
			}
			
			while(!pq.isEmpty()){
				int u = pq.poll();
				result.add(u);
				
				for (int v : adj[u]) {
					if(--inDegree[v] == 0)
						pq.add(v);
				}
			}
			
			out.printf("Case #%d: Dilbert should drink beverages in this order:", T++);
			for (int x : result) {
				out.printf(" %s", revMap[x]);
			}
			
			out.println(".\n");
			
			in.nextLine();
		}
		
		out.flush();
		out.close();
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

	    public String next() throws IOException {
	        while (st == null || !st.hasMoreTokens())
	            st = new StringTokenizer(br.readLine());
	        return st.nextToken();
	    }

	    public String nextLine() throws IOException {
	        return br.readLine();
	    }

	    public int nextInt() throws IOException {
	        return Integer.parseInt(next());
	    }

	    public long nextLong() throws IOException {
	        return Long.parseLong(next());
	    }

	    public double nextDouble() throws IOException {
	        return Double.parseDouble(next());
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
