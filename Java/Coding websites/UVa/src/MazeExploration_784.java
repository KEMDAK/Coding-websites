import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class CellMaze {
	int i, j;

	public CellMaze(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class MazeExploration_784 {

	static ArrayList<ArrayList<Character>> maze;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int rows;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		while (T-- > 0) {
			maze = new ArrayList<>();
			String line = "";

			int startX = 0;
			int startY = 0;

			for (int i = 0; true; i++) {
				line = in.readLine();
				if (line.charAt(0) == '_')
					break;

				ArrayList<Character> temp = new ArrayList<>();
				for (int j = 0; j < line.length(); j++) {
					temp.add(line.charAt(j));
					if (line.charAt(j) == '*') {
						startX = i;
						startY = j;
					}
				}
				maze.add(temp);
			}

			rows = maze.size();

			bfs(startX, startY);

			for (int i = 0; i < maze.size(); i++) {
				for (int j = 0; j < maze.get(i).size(); j++) {
					out.append(maze.get(i).get(j));
				}
				out.append("\n");
			}
			if (T > 0)
				out.append(line + "\n");
			else
				out.append(line);
		}

		System.out.println(out);
	}

	public static boolean valid(int x, int y, int limitY) {
		return ((x >= 0 && y >= 0) && (x < rows && y < limitY));
	}

	private static void bfs(int i, int j) {

		Queue<CellMaze> next = new LinkedList<CellMaze>();
		next.add(new CellMaze(i, j));

		maze.get(i).set(j, '#');
		while (!next.isEmpty()) {
			CellMaze current = next.remove();
			for (int k = 0; k < dx.length; k++) {
				int row = current.i + dx[k];
				int column = current.j + dy[k];
				if ((valid(row, column, maze.get(row).size()) && maze.get(row)
						.get(column) == ' ')) {
					maze.get(row).set(column, '#');
					;
					next.add(new CellMaze(row, column));
				}
			}
		}
	}
}
