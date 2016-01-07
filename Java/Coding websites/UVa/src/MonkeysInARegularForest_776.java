import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Cell {
	int i, j;

	public Cell(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class MonkeysInARegularForest_776 {

	static ArrayList<ArrayList<Character>> forest;
	static int[][] res;
	static int rows;
	static int columns;
	static int[] dx = { -1, 0, 1, 0, 1, -1, -1, 1 };
	static int[] dy = { 0, -1, 0, 1, -1, 1, -1, 1 };
	static int monkeysEnum;
	static PrintWriter out;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		while (in.ready()) { // in.ready()
			forest = new ArrayList<>();

			rows = 0;
			while (in.ready()) { // in.ready()
				String line = in.readLine();
				if (line.equals("%"))
					break;

				StringTokenizer s = new StringTokenizer(line);

				ArrayList<Character> temp = new ArrayList<>();
				for (columns = 0; s.hasMoreTokens(); columns++) {
					temp.add(s.nextToken().charAt(0));
				}
				forest.add(temp);
				rows++;
			}

			res = new int[rows][columns];

			monkeysEnum = 1;

			for (int i = 0; i < res.length; i++) {
				for (int j = 0; j < res[i].length; j++) {
					if (res[i][j] == 0) {
						bfs(i, j);
						monkeysEnum++;
					}
				}
			}

			print();
			out.println("%");
		}

		out.flush();
		out.close();
	}

	public static void print() {
		int[] maxD = maxInColumn();
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				int num = res[i][j];
				int temp = num;
				int count = 0;
				while (temp != 0) {
					temp /= 10;
					count++;
				}
				for (int j2 = 0; j2 < maxD[j] - count; j2++)
					out.print(" ");
				if (j != res[i].length - 1)
					out.print(num + " ");
				else
					out.print(num);
			}
			out.println();
		}

	}

	private static int[] maxInColumn() {
		int[] result = new int[res[0].length];
		for (int i = 0; i < res[0].length; i++) {
			int max = res[0][i];
			for (int j = 1; j < res.length; j++) {
				if (res[j][i] > max)
					max = res[j][i];
			}
			int count = 0;
			while (max != 0) {
				max /= 10;
				count++;
			}
			result[i] = count;
		}
		return result;
	}

	public static boolean valid(int x, int y) {
		return ((x >= 0 && y >= 0) && (x < rows && y < columns));
	}

	private static void bfs(int i, int j) {

		Queue<CellRank> next = new LinkedList<CellRank>();
		next.add(new CellRank(i, j));

		res[i][j] = monkeysEnum;
		while (!next.isEmpty()) {
			CellRank current = next.remove();
			for (int k = 0; k < dx.length; k++) {
				int row = current.i + dx[k];
				int column = current.j + dy[k];
				if ((valid(row, column)
						&& forest.get(row).get(column) == forest.get(i).get(j) && (res[row][column] == 0))) {
					res[row][column] = monkeysEnum;
					next.add(new CellRank(row, column));
				}
			}
		}
	}
}
