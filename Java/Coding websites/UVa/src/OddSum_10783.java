import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class OddSum_10783 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++){
			int a = Integer.parseInt(in.readLine());
			int b = Integer.parseInt(in.readLine());
			
			int sum = 0;
			
			for (int i = a; i <= b; i++) {
				if(i % 2 == 1)
					sum += i;
			}
			
			out.printf("Case %d: %d\n", t, sum);
		}
		
		out.flush();
		out.close();
	}
}
