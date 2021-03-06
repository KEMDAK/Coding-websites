import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class DemandingDilemma_11550 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int t = Integer.parseInt(in.readLine());

		while(t-- > 0){
			StringTokenizer s = new StringTokenizer(in.readLine());

			int n = Integer.parseInt(s.nextToken());
			int m = Integer.parseInt(s.nextToken());

			int[][] mat = new int[n][m];

			for (int i = 0; i < n; i++) {
				s = new StringTokenizer(in.readLine());

				for (int j = 0; j < m; j++) {
					mat[i][j] = Integer.parseInt(s.nextToken());
				}
			}

			boolean valid = true;
			TreeSet<Edge> set = new TreeSet<>();

			for (int j = 0; j < m; j++) {
				int c = 0;
				int src = -1;
				int dest = -1;
				for (int i = 0; i < n; i++) {
					if(mat[i][j] == 1){
						c++;
						if(src == -1)
							src = i;
						else
							dest = i;
					}
				}

				if(c == 2 && !set.contains(new Edge(src, dest))){
					set.add(new Edge(src, dest));
					set.add(new Edge(dest, src));
				}
				else{
					valid = false;
					break;
				}
			}

//			out.println(set);
			if(valid)
				out.println("Yes");
			else
				out.println("No");
		}

		out.flush();
		out.close();
	}

	static class Edge implements Comparable<Edge>{
		int src, dest;

		public Edge(int src, int dest) {
			this.src = src;
			this.dest = dest;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.src != o.src)
				return this.src - o.src;
			return this.dest - o.dest;
		}

		@Override
		public String toString() {
			return "(" + this.src + ", " + this.dest + ")";
		}
	}
}
