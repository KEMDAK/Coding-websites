import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ClawDecomposition_11396 {

	static ArrayList<Integer>[] adj;
	static int[] color;
	static int V;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			V = Integer.parseInt(in.readLine());

			if (V == 0)
				break;

			adj = new ArrayList[V];
			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<>();
			}

			while (true) {
				String edge = in.readLine();

				if (edge.equals("0 0"))
					break;

				StringTokenizer s = new StringTokenizer(edge);

				int src = Integer.parseInt(s.nextToken()) - 1;
				int dist = Integer.parseInt(s.nextToken()) - 1;

				adj[src].add(dist);
				adj[dist].add(src);
			}

			color = new int[V];

			Arrays.fill(color, -1);

			if (isBipartite())
				out.println("YES");
			else
				out.println("NO");
		}

		out.flush();
		out.close();
	}

	public static boolean isBipartite() {
		Queue<Integer> next = new LinkedList<Integer>();
		next.add(0);
		color[0] = 0;

		while (!next.isEmpty()) {
			int s = next.remove();

			for (int i = 0; i < adj[s].size(); i++) {
				if (color[adj[s].get(i)] == color[s])
					return false;
				if (color[adj[s].get(i)] == -1) {
					next.add(adj[s].get(i));
					color[adj[s].get(i)] = (color[s] + 1) % 2;
				}
			}
		}
		return true;
	}
}
