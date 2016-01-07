import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class Labyrinth_LABYR1 {

	static int[][] labyrinth;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int C, R;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		while (T-- > 0) {

			StringTokenizer s = new StringTokenizer(in.readLine());

			C = Integer.parseInt(s.nextToken());
			R = Integer.parseInt(s.nextToken());

			labyrinth = new int[R][C];

			for (int i = 0; i < R; i++) {
				String line = in.readLine();
				for (int j = 0; j < line.length(); j++) {
					if (line.charAt(j) == '#')
						labyrinth[i][j] = -2;
					else if (line.charAt(j) == '.')
						labyrinth[i][j] = -1;
				}
			}

			int i = 0;
			int j = 0;

			for (i = 0; i < labyrinth.length; i++) {
				int counter = 0;
				for (j = 0; j < labyrinth[i].length; j++) {
					if (labyrinth[i][j] == -1) {
						for (int k = 0; k < dx.length; k++) {
							int row = i + dx[k];
							int column = j + dy[k];
							if ((valid(row, column) && labyrinth[row][column] == -2)
									|| !valid(row, column)) {
								counter++;
							}
							if (counter == 3)
								break;
						}
						if (counter == 3)
							break;
					}
				}
				if (counter == 3)
					break;
			}

			// System.out.println(i + " : " + j);

			bfs(i, j);

			// for (int j2 = 0; j2 < labyrinth.length; j2++) {
			// System.out.println(Arrays.toString(labyrinth[j2]));
			// }

			int max = -1;
			int maxI = 0;
			int maxJ = 0;

			for (int j2 = 0; j2 < labyrinth.length; j2++) {
				for (int k = 0; k < labyrinth[j2].length; k++) {
					if (labyrinth[j2][k] != -2) {
						if (labyrinth[j2][k] > max) {
							max = labyrinth[j2][k];
							maxI = j2;
							maxJ = k;
						}
						labyrinth[j2][k] = -1;
					}
				}
			}

			// for (int j2 = 0; j2 < labyrinth.length; j2++) {
			// System.out.println(Arrays.toString(labyrinth[j2]));
			// }

			bfs(maxI, maxJ);

			// for (int j2 = 0; j2 < labyrinth.length; j2++) {
			// System.out.println(Arrays.toString(labyrinth[j2]));
			// }

			for (int j2 = 0; j2 < labyrinth.length; j2++) {
				for (int k = 0; k < labyrinth[j2].length; k++) {
					if (labyrinth[j2][k] != -2) {
						if (labyrinth[j2][k] > max) {
							max = labyrinth[j2][k];
						}
					}
				}
			}

			out.append("Maximum rope length is " + max + ".\n");
		}
		System.out.print(out.toString());

	}

	private static void bfs(int i, int j) {

		Queue<Cell> next = new LinkedList<Cell>();
		next.add(new Cell(i, j));

		labyrinth[i][j] = 0;
		while (!next.isEmpty()) {
			Cell current = next.remove();
			for (int k = 0; k < dx.length; k++) {
				int row = current.i + dx[k];
				int column = current.j + dy[k];
				if ((valid(row, column) && labyrinth[row][column] == -1)) {
					labyrinth[row][column] = (labyrinth[current.i][current.j] + 1);
					next.add(new Cell(row, column));
				}
			}
		}
	}

	public static boolean valid(int x, int y) {
		return ((x >= 0 && y >= 0) && (x < R && y < C));
	}

}
