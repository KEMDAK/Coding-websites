import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Presents {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		int[] res = new int[n];
		
		for (int i = 1; s.hasMoreTokens(); i++) {
			res[Integer.parseInt(s.nextToken()) - 1] = i;
		}
		
		for (int i = 0; i < res.length - 1; i++) {
			System.out.print(res[i] + " ");
		}
		
		System.out.print(res[n - 1]);
	}
}
