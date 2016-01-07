import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArtUnion {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer s = new StringTokenizer(in.readLine());

		int m = Integer.parseInt(s.nextToken());
		int n = Integer.parseInt(s.nextToken());

		int[][] time = new int[m][n];

		for (int i = 0; i < m; i++) {
			s = new StringTokenizer(in.readLine());

			for (int j = 0; j < n; j++){
				time[i][j] = Integer.parseInt(s.nextToken());
			}
		}

		for (int j = 1; j < m; j++)
			time[j][0] += time[j-1][0];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if(j == 0)
					time[j][i] += time[j][i - 1]; 
				else
					time[j][i] += Math.max(time[j - 1][i], time[j][i - 1]);
			}
		}
//
//		for (int i = 0; i < time.length; i++) {
//			for (int j = 0; j < time[i].length; j++) {
//				System.out.print(time[i][j] + " ");
//			}
//			System.out.println();
//		}
//
//		System.out.println();

		for (int i = 0; i < m; i++) {
			System.out.print(time[i][n - 1] + " ");
		}
	}
}
