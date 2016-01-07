import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InsomniaCure {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(in.readLine());
		int l = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		int n = Integer.parseInt(in.readLine());
		int d = Integer.parseInt(in.readLine());
		
		int res = 0;
		
		for (int i = 1; i <= d; i++) {
			if((i % k == 0) || (i % l == 0) || (i % m == 0) || (i % n == 0))
				res++;
		}
		
		System.out.println(res);
	}
}
