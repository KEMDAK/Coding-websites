import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Sub_prime_11679 {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while(true){
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			int b = Integer.parseInt(s.nextToken());
			int n = Integer.parseInt(s.nextToken());
			
			if(b == 0 && n == 0)
				break;
			
			int[] banks = new int[b];
			
			s = new StringTokenizer(in.readLine());
			for (int i = 0; i < banks.length; i++) {
				banks[i] = Integer.parseInt(s.nextToken());
			}
			
			for (int i = 0; i < n; i++) {
				s = new StringTokenizer(in.readLine());
				
				int src = Integer.parseInt(s.nextToken()) - 1;
				int dest = Integer.parseInt(s.nextToken()) - 1;
				int money = Integer.parseInt(s.nextToken());
				
				banks[src] -= money;
				banks[dest] += money;
			}
			
			boolean valid = true;
			
			for (int i = 0; i < banks.length; i++) {
				if(banks[i] < 0){
					valid = false;
					break;
				}
			}
			
			out.println(valid? "S" : "N");
		}
		
		out.flush();
		out.close();
	}
}
