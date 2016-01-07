import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Games {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		int[] home = new int[n];
		int[] guest = new int[n];
		
		for (int i = 0; i < home.length; i++) {
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			home[i] = Integer.parseInt(s.nextToken());
			guest[i] = Integer.parseInt(s.nextToken());
		}
		
		int res = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j)
					if(home[i] == guest[j])
						res++;
			}
		}
		
		System.out.println(res);
	}
}
