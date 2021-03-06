import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CodingContestCreation {


	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader in = new BufferedReader(new FileReader("coding_contest_creation.txt"));
//		PrintWriter out = new PrintWriter(new File("Coding_Contest_Creation_out.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(in.readLine());

			StringTokenizer s = new StringTokenizer(in.readLine());

			int[] D = new int[N];

			for (int i = 0; i < N; i++)
				D[i] = Integer.parseInt(s.nextToken());

			long res = 0;
			for (int i = 0; i < N;) {
				int start = i;
				int end = i;
				int cur = 1;

				for (end = i + 1; end < N; end++, i++) {
					int diff = D[end] - D[i];
					if(diff > 30 || diff <= 0)
						break;

					if(cur == 4) break;				

					if(diff <= 10){
						cur++;
						continue;
					}
					
					if(diff > 20 && diff <= 30){
						if(4 - cur == 3)
							cur += 3;
						else{
							cur = 4;
							end--;
						}
					}

					if(diff > 10 && diff <= 20){
						if(4 - cur >= 2)
							cur += 2;
						else{
							cur = 4;
							end--;
						}
					}
				}
				
				res += 4 - (end - start);
				i = end;
//				System.out.println(end + " " + (4 - (end - start)));
			}
			
			out.printf("Case #%d: %d\n", t, res);
		}

		out.flush();
		out.close();
	}
}
