import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SocialConstraints_11742 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(true){
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			int n = Integer.parseInt(s.nextToken());
			int m = Integer.parseInt(s.nextToken());
			
			if(n == 0 && m == 0)
				break;
			
			int total = fac(n);
			
			for (int i = 0; i < m; i++) {
				s = new StringTokenizer(in.readLine());
				
				int a = Integer.parseInt(s.nextToken());
				int b = Integer.parseInt(s.nextToken());
				int c = Integer.parseInt(s.nextToken());
				
				int cur = 0;
				
				if(c < 0){
					c *= -1;
					cur += (n - c) * c;
					cur += ((c * (c - 1)) / 2) - 1;
				}
				else{
					int seats = (n - c - 1);
					
					int side = seats / 2;
					if(seats % 2 == 0){
						cur += side * side;
					}
					else{
						cur += side * (side + 1);
						cur += side - 1;
					}
				}
				
				cur *= 2;
				total -= cur;
			}
			
			out.println(total >= 0 ? total : 0);
		}
		
		out.flush();
		out.close();
	}
	
	public static int fac(int x){
		if(x == 0 || x == 1)
			return 1;
		
		return x * fac(x - 1);
	}
}
