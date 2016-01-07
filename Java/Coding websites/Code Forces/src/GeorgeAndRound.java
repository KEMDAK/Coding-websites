import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GeorgeAndRound {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(s.nextToken());
		int m = Integer.parseInt(s.nextToken());
		
		int[] a = new int[n];
		int[] b = new int[m];
		
		s = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) 
			a[i] = Integer.parseInt(s.nextToken());
		
		s = new StringTokenizer(in.readLine());
		for (int i = 0; i < m; i++)
			b[i] = Integer.parseInt(s.nextToken());
		
		int res = 0;
		
		for (int i = 0; i < a.length; i++) {
			boolean found = false;
			for (int j = 0; j < b.length; j++) {
				if(b[j] >= a[i] && b[j] != -1){
					b[j] = -1;
					found = true;
					break;
				}
			}
			
			if(!found){
				res += n - i;
				break;
			}
		}
		
		System.out.println(res);
	}
}
