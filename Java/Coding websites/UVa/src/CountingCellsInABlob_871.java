import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CountingCellsInABlob_871 {

	static ArrayList<ArrayList<Integer>> adj;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0, 1, -1, -1, 1 };
	static int[] dy = { 0, -1, 0, 1, -1, 1, -1, 1 };
	static int max;
	static int current;
	static int rows, columns;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());

		in.readLine();

		while (T-- > 0) {

			adj = new ArrayList<>();

			rows = 0;
			columns = 0;

			while (in.ready()) {
				String l = in.readLine();
				if (l.isEmpty())
					break;

				columns = l.length();
				if (l.charAt(columns - 1) == ' ')
					columns--;

				ArrayList<Integer> temp = new ArrayList<>();
				for (int i = 0; i < l.length(); i++) {
					temp.add((Integer.parseInt(l.charAt(i) + "")));
				}

				adj.add(temp);
				rows++;
			}

			visited = new boolean[rows][columns];

			max = current = 0;

			for (int i = 0; i < visited.length; i++) {
				for (int j = 0; j < visited[i].length; j++) {
					if (!visited[i][j] && adj.get(i).get(j) == 1) {
						current = 0;
						dfs(i, j);
						if (current > max)
							max = current;
					}
				}
			}

			if (T > 0)
				out.println(max + "\n");
			else
				out.println(max);

		}

		out.flush();
		out.close();
	}

	public static boolean valid(int x, int y) {
		return ((x >= 0 && y >= 0) && (x < rows && y < columns));
	}

	public static void dfs(int i, int j) {
		visited[i][j] = true;
		current++;

		for (int k = 0; k < dx.length; k++) {
			int row = i + dx[k];
			int column = j + dy[k];
			if ((valid(row, column) && adj.get(row).get(column) == 1 && !visited[row][column])) {
				dfs(row, column);
			}
		}
	}
}
