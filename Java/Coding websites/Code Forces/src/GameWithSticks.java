import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class GameWithSticks {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(s.nextToken());
		int m = Integer.parseInt(s.nextToken());
		
		int nodes = n * m;
		
		int i = 0;
		
		for (i = 0; nodes != 0; i = (i + 1) % 2) {
			nodes -= n + m - 1;
			n--;
			m--;
		}
		
		System.out.println((i == 1) ? "Akshat" : "Malvika");	
	}
}
