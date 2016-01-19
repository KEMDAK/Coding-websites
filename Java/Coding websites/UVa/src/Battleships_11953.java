import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Battleships_11953 {

	static int N;
	static char[][] map;
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			
			map = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				String s = in.readLine();
				
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			int count = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 'x'){
						count++;
						dfs(i, j);
					}
				}
			}
			
			out.printf("Case %d: %d\n", t, count);
		}
		
		out.flush();
		out.close();
	}

	public static void dfs(int i, int j) {
		map[i][j] = '.';
		
		for (int k = 0; k < 4; k++) {
			int newI = i + dy[k];
			int newJ = j + dx[k];
			
			if(valid(newI, newJ))
				dfs(newI, newJ);
		}
	}
	
	public static boolean valid(int i, int j){
		return i >= 0 && j >= 0 && i < N && j < N && (map[i][j] == 'x' || map[i][j] == '@');
	}
}
