import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BackToThe8Queens_11085 {

	static int[][] comb;
	static int c = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		comb = new int[92][];
		generate(0, new int[8]);

		int t = 1;
		
		while(in.ready()){
			StringTokenizer s = new StringTokenizer(in.readLine());

			int[] cur = new int[8];
			for (int i = 0; i < 8; i++) {
				cur[i] = Integer.parseInt(s.nextToken());
			}

			int moves = 20;
			for (int i = 0; i < comb.length; i++) {
				int counter = 0;
				for (int j = 0; j < cur.length; j++) {
					if(comb[i][j] != cur[j])
						counter++;
				}
				
				moves = Math.min(counter, moves);
			}
			
			out.printf("Case %d: %d\n", t++, moves);
		}
		
		out.flush();
		out.close();
	}

	public static void generate(int i, int[] x){
		if(i == 8){
			comb[c++] = x;
			return;
		}

		for (int m2 = 1; m2 <= 8; m2++) {
			boolean valid  = true;
			int xc = m2;
			int yc = i;

			for (int n = 0; n < i && valid; n++) {
				int xi = x[n];
				int yi = n;

				if(xi == xc || Math.abs(xi - xc) == Math.abs(yi - yc)){
					valid = false;
				}
			}

			if(valid){
				int[] clone = x.clone();
				clone[i] = xc;
				
				generate(i + 1, clone);
			}
		}
	}
}
