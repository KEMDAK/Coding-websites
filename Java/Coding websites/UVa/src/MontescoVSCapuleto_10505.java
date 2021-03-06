import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MontescoVSCapuleto_10505 {

	static ArrayList<Integer>[] adj;
	static int T1, T2;
	static int[] colors;
	static boolean valid;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int M = Integer.parseInt(in.readLine());
		
		while(M-- > 0){
			in.readLine();
			
			int n = Integer.parseInt(in.readLine());
			
			adj = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < n; i++) {
				StringTokenizer s = new StringTokenizer(in.readLine());
				
				int src = i;
				int p = Integer.parseInt(s.nextToken());
				
				for (int j = 0; j < p; j++) {
					int dest = Integer.parseInt(s.nextToken()) - 1;
					
					if(dest == -1 || dest >= n) continue;
					
					adj[src].add(dest);
					adj[dest].add(src);
				}
			}
			
			int res = 0;
			
			colors = new int[n];
			Arrays.fill(colors, -1);
			
			for (int i = 0; i < n; i++) {
				if(colors[i] == -1){
					T1 = T2 = 0;
					valid = true;
				
					colors[i] = 0;
					T1++;
					check(i);
					
					if(valid)
						res += Math.max(T1, T2);
				}
			}
			
			out.println(res);
		}
		
		out.flush();
		out.close();
	}
	public static void check(int i) {
		
		for (int v : adj[i]) {
			if(colors[v] == -1){
				colors[v] = colors[i] ^ 1;
				
				if(colors[v] == 0) T1++; else T2++;
				
				check(v);
			}
			else if(colors[v] == colors[i]){
				valid = false;
			}
		}
	}
}
