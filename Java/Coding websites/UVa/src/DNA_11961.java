import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DNA_11961 {
	
	static char[] alpha = {'A', 'C', 'G', 'T'};
	
	public static void next_perm(char[] c){
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int t = Integer.parseInt(in.readLine());
		
		while(t-- > 0){
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			int N = Integer.parseInt(s.nextToken());
			int K = Integer.parseInt(s.nextToken());
			
			char[] input = new char[N];
			
			String st = in.readLine();
			for (int i = 0; i < N; i++) {
				input[i] = st.charAt(i);
			}
			
			
		}
	}
}
