import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class OrderingTasks_10305 {

	static ArrayList<Integer> adj[];
	static boolean visited[];
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			StringTokenizer s = new StringTokenizer(in.readLine());

			int N = Integer.parseInt(s.nextToken());
			int M = Integer.parseInt(s.nextToken());

			if (N == 0 && M == 0)
				break;

			adj = new ArrayList[N];

			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				s = new StringTokenizer(in.readLine());

				int src = Integer.parseInt(s.nextToken()) - 1;
				int dist = Integer.parseInt(s.nextToken()) - 1;

				adj[dist].add(src);
			}

			visited = new boolean[N];

			stack = new Stack<>();

			for (int i = 0; i < visited.length; i++)
				if (!visited[i])
					dfs(i);

			String st = "" + stack.pop();
			while (!stack.isEmpty())
				st = stack.pop() + " " + st;

			out.println(st);
		}

		out.flush();
		out.close();
	}

	public static void dfs(int node) {
		visited[node] = true;

		for (int i = 0; i < adj[node].size(); i++) {
			if (!visited[adj[node].get(i)])
				dfs(adj[node].get(i));
		}
		stack.push(node + 1);
	}
}
