import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CodingContestCreation {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
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
			
			for (int i = 0; i < N; i++) {
				int start = i;
				int end = i;
				int cur = 1;
				
				for (int j = i + 1; j < N; j++) {
					int diff = D[j] - D[i];
					if(diff > 30 || diff < 0)
						break;
					
					end = j;
					
					
				}
			}
		}
		
		out.flush();
		out.close();
	}
}
