import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WhereIsTheMarble_10474 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int t = 1;
		
		while(true){
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			int N = Integer.parseInt(s.nextToken());
			int Q = Integer.parseInt(s.nextToken());
			
			if (N == 0 && Q == 0)
				break;
			
			int[] marbles = new int[N];
			
			for (int i = 0; i < N; i++)
				marbles[i] = Integer.parseInt(in.readLine());
			
			Arrays.sort(marbles);
			
			out.printf("CASE# %d:\n", t++);
			for (int i = 0; i < Q; i++) {
				int key = Integer.parseInt(in.readLine());
				int low = 0;
				int high = N - 1;
				int ans = -1;
				
				while(low <= high){
					int mid = low + (high - low) / 2;
					
					if(marbles[mid] == key){
						ans = mid;
						high = mid - 1;
					}
					else if(marbles[mid] > key)
						high = mid - 1;
					else
						low = mid + 1;
				}
				
				if(ans == -1){
					out.printf("%d not found\n", key);
				}
				else{
					out.printf("%d found at %d\n", key, ans + 1);
				}
			}
		}
		
		out.flush();
		out.close();
	}
}
