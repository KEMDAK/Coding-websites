import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class HighSecurity {

	static char[][] map;
	static boolean valid;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new FileReader("high_security.txt"));
		PrintWriter out = new PrintWriter(new File("High_Security_out.txt"));

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());

			map = new char[2][N];
			for (int i = 0; i < 2; i++) {
				String s = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j);
				}
			}

			int ans = 0;

			for (int j = 0; j < N; j++) {
				for (int i = 0; i < 2; i++) {
					valid = false;

					if(map[i][j] == '.'){
						fill(i, j);
						ans++;
					}
				}
			}

			out.printf("Case #%d: %d\n", t, ans);
		}

		out.flush();
		out.close();
	}

	public static void fill(int i, int j){
		int besti = 0;
		int bestj = 0;
		for (; j < N; j++) {
			if(map[i][j] == 'X') break;

			if(map[(i + 1) % 2][j] == '.' && !valid){
				besti = (i + 1) % 2;
				bestj = j;

				if((j - 1 < 0 || map[(i + 1) % 2][j - 1] == 'X') && (j + 1 >= N || map[(i + 1) % 2][j + 1] == 'X')){
					valid = true;
				}
			}

			map[i][j] = '*';
		}

		map[besti][bestj] = '*';
	}
}
