import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MattysBlocks_434 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int T = Integer.parseInt(in.readLine());
		
		while(T-- > 0){
			int K = Integer.parseInt(in.readLine());
			
			int[] front = new int[K];
			int[] side = new int[K];
			
			StringTokenizer s = new StringTokenizer(in.readLine());
			for (int i = 0; i < K; i++) {
				front[i] = Integer.parseInt(s.nextToken());
			}
			
			s = new StringTokenizer(in.readLine());
			for (int i = 0; i < K; i++) {
				side[i] = Integer.parseInt(s.nextToken());
			}
			
			int min = 0;
			int max = 0;
			
			for (int i = 1; i <= 8; i++) {
				int frontL = 0;
				int sideL = 0;
				for (int j = 0; j < K; j++) {
					if(front[j] >= i)
						frontL++;
					if(side[j] >= i)
						sideL++;
				}
				
				max += frontL * sideL;
			}
			
			for (int i = 0; i < K; i++) {
				int j;
				for (j = 0; j < K; j++) {
					if(front[i] == side[j]){
						min += side[j];
						side[j] = -1;
						break;
					}
				}
				
				if(j == K)
					min += front[i];
			}
			
			for (int i = 0; i < K; i++) {
				if(side[i] != -1)
					min += side[i];
			}
			
			int extra = max - min;
			
			out.printf("Matty needs at least %d blocks, and can add at most %d extra blocks.\n", min, extra);
		}
		
		out.flush();
		out.close();
	}
}
