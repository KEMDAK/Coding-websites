import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PashaandPixels {

	static int n, m, k;
	static boolean[][] game;
	
	public static boolean check(int i, int j) {
		if (valid(i-1, j-1) && game[i-1][j-1] && valid(i-1, j) && game[i-1][j] && valid(i, j-1) && game[i][j-1])
			return true;
		if (valid(i-1, j+1) && game[i-1][j+1] && valid(i-1, j) && game[i-1][j] && valid(i, j+1) && game[i][j+1])
			return true;
		if (valid(i+1, j-1) && game[i+1][j-1] && valid(i, j-1) && game[i][j-1] && valid(i+1, j) && game[i+1][j])
			return true;
		if (valid(i+1, j+1) && game[i+1][j+1] && valid(i+1, j) && game[i+1][j] && valid(i, j+1) && game[i][j+1])
			return true;
		return false;
		
	}
	
	public static boolean valid(int i, int j){
		return (i >= 0 && i < n && j >= 0 && j < m);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		n = Integer.parseInt(s.nextToken());
		m = Integer.parseInt(s.nextToken());
		k = Integer.parseInt(s.nextToken());
		game = new boolean[n][m];
		int ans = 0;
		for (int l = 1; l <= k; l++) {
			s = new StringTokenizer(in.readLine());
			int i = Integer.parseInt(s.nextToken()) - 1;
			int j = Integer.parseInt(s.nextToken()) - 1;
			game[i][j] = true;
			if (check(i, j)) {
				ans = l;
				break;
			}
		}
		System.out.println(ans);
	}
}
