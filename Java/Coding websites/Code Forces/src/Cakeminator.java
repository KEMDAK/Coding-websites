import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Cakeminator {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[][] cake = new int[r][c];

		for (int i = 0; i < r; i++) {
			String s = in.readLine();
			for (int j = 0; j < c; j++) {
				if(s.charAt(j) == 'S'){
					cake[i][j] = -1;

					for (int k = 0; k < c; k++) {
						if(cake[i][k] != -1)
							if(cake[i][k] == -3)
								cake[i][k] = -1;
							else
								cake[i][k] = -2;
					}
					
					for (int k = 0; k < r; k++) {
						if(cake[k][j] != -1)
							if(cake[k][j] == -2)
								cake[k][j] = -1;
							else
								cake[k][j] = -3;
					}
				}
			}
		}
		
		int counter = 0;
		
		for (int i = 0; i < cake.length; i++) {
			for (int j = 0; j < cake[i].length; j++) {
				if(cake[i][j] != -1)
					counter++;
			}
		}
		
		System.out.println(counter);
	}
}
