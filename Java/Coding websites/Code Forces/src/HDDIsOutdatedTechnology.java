import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HDDIsOutdatedTechnology {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		int[] p = new int[n + 1];
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(s.nextToken());
			p[num] = i;
		}
		
		long total = 0;
		
		for (int i = 1; i < n; i++) {
			total += Math.abs(p[i] - p[i + 1]);
		}
		
		System.out.println(total);
	}
}
