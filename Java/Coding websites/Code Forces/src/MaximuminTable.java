import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximuminTable {

	static int[][] mat;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		mat = new int[n][n];
		Arrays.fill(mat[0], 1);
		for (int i = 0; i < mat.length; i++) {
			mat[i][0] = 1;
		}
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[i].length; j++) {
				mat[i][j] = mat[i - 1][j] + mat[i][j - 1];
			}
		}
		System.out.println(mat[n - 1][n - 1]);
	}
}
