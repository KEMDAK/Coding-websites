import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TheMostPotentCorner_10264 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(in.ready()){
			int n = Integer.parseInt(in.readLine());
			
			int[] cost = new int[(1 << n)];
			
			for (int i = 0; i < (1 << n); i++) {
				int c = Integer.parseInt(in.readLine());
				cost[i] = c;
			}
			
			int[] potency = new int[(1 << n)];
			
			for (int i = 0; i < (1 << n); i++) {
				for (int j = 0; j < n; j++) {
					potency[i] += cost[(i ^ (1 << j))];
				}
			}
			
			int max = 0;

			for (int i = 0; i < (1 << n); i++) {
				for (int j = 0; j < n; j++) {
					max = Math.max(max, potency[(i ^ (1 << j))] + potency[i]);
				}
			}
			
			out.println(max);
		}
		
		out.flush();
		out.close();
	}
}
