import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LevkoAndPermutation {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(s.nextToken());
		int k = Integer.parseInt(s.nextToken());
		
		int t = n - 1;
		
		int[] p = new int[n];
		
		if(k > n - 1){
			System.out.println(-1);
			return;
		}
		
		for (int i = 0; i < p.length; i++)
			p[i] = i + 1;
		
		for (int i = 1; i < p.length && t != k; i++) {
			if(t == k + 1){			
				p[0] = p[i];
				p[i] = 1;
				t--;
				break;
			}
			
			if(i == p.length - 1)
				break;
			
			int temp = p[i + 1];
			p[i + 1] = p[i];
			p[i] = temp;
			
			i++;
			t -=2;
		}
		
		if(t != k){
			System.out.println(-1);
			return;
		}
		
		for (int i = 0; i < p.length; i++) {
			out.print(p[i] + " ");
		}
		
		out.flush();
		out.close();
	}
}
