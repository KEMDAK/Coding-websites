import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exhibition_11348 {

	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(in.readLine());
			
			boolean[] unique = new boolean[10005];
			for (int i = 0; i < 10005; i++) 
				unique[i] = true;
			
			int[] owner = new int[10005];
			
			for (int i = 1; i <= K; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int M = Integer.parseInt(st.nextToken());
				
				for (int j = 0; j < M; j++) {
					int type = Integer.parseInt(st.nextToken());
					
					if(owner[type] != 0 && owner[type] != i){
						unique[type] = false;
					}
					
					owner[type] = i;
				}
			}
			
			int total = 0;
			
			for (int i = 0; i < 10005; i++) {
				if(unique[i] && owner[i] != 0)
					total++;
			}
			
			int[] count = new int[K];
			for (int i = 0; i < 10005; i++) {
				if(unique[i] && owner[i] != 0)
					count[owner[i] - 1]++;
			}
			
			out.printf("Case %d:", t);
			if(K == 0 || total == 0){
				out.println(" ");
				continue;
			}
//			System.out.println(total);
//			System.out.println(Arrays.toString(count));
			for (int i = 0; i < K; i++) {
				double share = 0;
				if(count[i] != 0)
					share = (count[i] / (total * 1.0)) * 100;
				out.printf(" %.6f", share);
				out.print("%");
			}
			
			out.println();
		}
		
		out.flush();
		out.close();
	}
}
