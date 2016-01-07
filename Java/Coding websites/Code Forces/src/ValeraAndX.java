import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ValeraAndX {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());

		char[][] paper = new char[n][n];

		for (int i = 0; i < n; i++) {
			String s = in.readLine();

			for (int j = 0; j < n; j++) {
				paper[i][j] = s.charAt(j);
			}
		}

		char diag = paper[0][0];
		char rest = paper[0][1];

		if(rest == diag){
			System.out.println("NO");
			return;
		}

		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper[i].length; j++) {
				if(i == j || j == (n - i - 1)){
					if(paper[i][j] != diag){
						System.out.println("NO");
						return;
					}
				}
				else if(paper[i][j] != rest){
					System.out.println("NO");
					return;
				}
			}
		}

		System.out.println("YES");
	}
}
