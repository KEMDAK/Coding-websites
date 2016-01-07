import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ApplemanAndEasyTask {

	static int n;
	static char[][] checkerboard;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static int count(int i, int j){
		int counter = 0;
		
		for (int k = 0; k < dx.length; k++) {
			int r = i + dx[k];
			int c = j + dy[k];
			
			if(valid(r, c) && checkerboard[r][c] == 'o')
				counter++;
		}
		
		return counter;
	}
	
	public static boolean valid(int i, int j){
		return (i < n && i >=0 && j < n && j >= 0);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		checkerboard = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			String s = in.readLine();
			for (int j = 0; j < n; j++) {
				checkerboard[i][j] = s.charAt(j);
			}
		}
		
		for (int i = 0; i < checkerboard.length; i++) {
			for (int j = 0; j < checkerboard[i].length; j++) {
				if(count(i, j) % 2 !=0){
					System.out.println("NO");
					return;
				}
			}
		}
		
		System.out.println("YES");
	}
}
