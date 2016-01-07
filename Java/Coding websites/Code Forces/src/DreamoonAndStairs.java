import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class DreamoonAndStairs {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(s.nextToken());
		int m = Integer.parseInt(s.nextToken());
		
		int min = 100000;
		
		for (int i = 0; i <= n; i++) {
			if((n - i) % 2 == 0){
				int moves = i + ((n - i) / 2);
				
				if(moves % m == 0 && moves < min)
					min = moves;
			}
		}
		
		if(min == 100000)
			System.out.println(-1);
		else
			System.out.println(min);
	}
}
