import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class CellRank {
	int i, j;

	public CellRank(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

class Language implements Comparable<Language> {
	char sign;
	int states;

	public Language(char sign, int states) {
		this.sign = sign;
		this.states = states;
	}

	public int compareTo(Language l) {
		if (this.states != l.states)
			return l.states - this.states;
		return this.sign - l.sign;
	}

	public boolean equals(Object o) {
		Language l = (Language) o;
		return (this.sign == l.sign);
	}
}

public class RanktheLanguages_10336 {

	static char[][] world;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int H, W;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int N = Integer.parseInt(in.readLine());

		for (int test = 1; N-- > 0; test++) {
			StringTokenizer s = new StringTokenizer(in.readLine());

			H = Integer.parseInt(s.nextToken());
			W = Integer.parseInt(s.nextToken());

			world = new char[H][W];

			for (int i = 0; i < H; i++) {
				String line = in.readLine();
				for (int j = 0; j < W; j++) {
					world[i][j] = line.charAt(j);
				}
			}

			visited = new boolean[H][W];

			ArrayList<Language> languges = new ArrayList<Language>();

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (!visited[i][j]) {
						bfs(i, j);
						int index = languges.indexOf(new Language(world[i][j],
								0));
						if (index == -1)
							languges.add(new Language(world[i][j], 1));
						else
							languges.get(index).states++;
					}
				}
			}

			Collections.sort(languges);

			out.println("World #" + test);

			for (int i = 0; i < languges.size(); i++) {
				out.println(languges.get(i).sign + ": "
						+ languges.get(i).states);
			}
		}

		out.flush();
		out.close();
	}

	public static boolean valid(int x, int y) {
		return ((x >= 0 && y >= 0) && (x < H && y < W));
	}

	private static void bfs(int i, int j) {

		Queue<CellRank> next = new LinkedList<CellRank>();
		next.add(new CellRank(i, j));

		visited[i][j] = true;
		while (!next.isEmpty()) {
			CellRank current = next.remove();
			for (int k = 0; k < dx.length; k++) {
				int row = current.i + dx[k];
				int column = current.j + dy[k];
				if ((valid(row, column) && world[row][column] == world[i][j])
						&& !visited[row][column]) {
					visited[row][column] = true;
					next.add(new CellRank(row, column));
				}
			}
		}
	}
}
