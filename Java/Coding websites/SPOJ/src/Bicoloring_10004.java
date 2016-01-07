import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bicoloring_10004 {

	static ArrayList<Integer>[] adj;
	static Queue<Integer> next;
	static int[] color;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			int L = Integer.parseInt(in.readLine());

			adj = new ArrayList[N];

			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<>();
			}

			for (int i = 0; i < L; i++) {
				StringTokenizer s = new StringTokenizer(in.readLine());
				int first = Integer.parseInt(s.nextToken());
				int second = Integer.parseInt(s.nextToken());

				adj[first].add(second);
				adj[second].add(first);
			}

			next = new LinkedList<Integer>();

			color = new int[N];

			Arrays.fill(color, -1);

			out.println((bfs()) ? "BICOLORABLE." : "NOT BICOLORABLE.");
		}

		out.flush();
		out.close();
	}

	public static boolean bfs() {
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
