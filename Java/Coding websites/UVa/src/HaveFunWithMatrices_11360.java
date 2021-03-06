import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HaveFunWithMatrices_11360 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(in.readLine());

			int[][] mat = new int[n][n];

			for (int i = 0; i < n; i++) {
				String s = in.readLine();
				for (int j = 0; j < n; j++) {
					mat[i][j] = s.charAt(j) - '0';
				}
			}

			int m = Integer.parseInt(in.readLine());

			for (int i = 0; i < m; i++) {
				String comm = in.readLine();

				if(comm.charAt(0) == 'r'){
					StringTokenizer s = new StringTokenizer(comm);
					s.nextToken();
					int a = Integer.parseInt(s.nextToken()) - 1;
					int b = Integer.parseInt(s.nextToken()) - 1;

					int[] temp = mat[a];
					mat[a] = mat[b];
					mat[b] = temp;
				}
				else if(comm.charAt(0) == 'c'){
					StringTokenizer s = new StringTokenizer(comm);
					s.nextToken();
					int a = Integer.parseInt(s.nextToken()) - 1;
					int b = Integer.parseInt(s.nextToken()) - 1;

					for (int j = 0; j < n; j++) {
						int temp = mat[j][a];
						mat[j][a] = mat[j][b];
						mat[j][b] = temp;
					}
				}
				else if(comm.charAt(0) == 'i'){
					for (int j = 0; j < n; j++) {
						for (int k = 0; k < n; k++) {
							if(mat[j][k] != 9)
								mat[j][k]++;
							else
								mat[j][k] = 0;
						}
					}
				}
				else if(comm.charAt(0) == 'd'){
					for (int j = 0; j < n; j++) {
						for (int k = 0; k < n; k++) {
							if(mat[j][k] != 0)
								mat[j][k]--;
							else
								mat[j][k] = 9;
						}
					}
				}
				else if(comm.charAt(0) == 't'){
					int[][] tran = new int[n][n];
					for (int j = 0; j < n; j++) {
						for (int k = 0; k < n; k++) {
							tran[k][j] = mat[j][k];
						}
					}
					mat = tran;
				}
			}
			
			out.printf("Case #%d\n", t);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					out.print(mat[i][j]);
				}
				out.println();
			}
			
			out.println();
		}
		
		out.flush();
		out.close();
	}
}
