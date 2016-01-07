import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ContestHallPreparation_22 {

	static int[][] hall;
	static ArrayList<Integer> visited;
	static int[] dx = { -1, 0, 1, 0, 1, -1, -1, 1 };
	static int[] dy = { 0, -1, 0, 1, -1, 1, -1, 1 };
	static int N, M, count;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());

		while (T-- > 0) {
			StringTokenizer s = new StringTokenizer(in.readLine());

			N = Integer.parseInt(s.nextToken());
			M = Integer.parseInt(s.nextToken());

			hall = new int[N][M];

			for (int i = 0; i < N; i++) {
				s = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					hall[i][j] = Integer.parseInt(s.nextToken());
				}
			}
			count = 0;

			visited = new ArrayList<Integer>();

			for (int i = 0; i < hall.length; i++) {
				for (int j = 0; j < hall[i].length; j++) {
					if (hall[i][j] != -1 && !visited.contains(hall[i][j])) {
						check(i, j);
					}
				}
			}

			out.println(count);
		}

		out.flush();
		out.close();
	}

	public static boolean valid(int x, int y) {
		return ((x >= 0 && y >= 0) && (x < N && y < M));
	}

	public static void check(int i, int j) {
		for (int k = 0; k < dx.length; k++) {
			int row = i + dx[k];
			int column = j + dy[k];
			if ((valid(row, column) && hall[row][column] == hall[i][j])
					&& !visited.contains(hall[i][j])) {
				visited.add(hall[i][j]);
				count++;
			}
		}
	}
}
