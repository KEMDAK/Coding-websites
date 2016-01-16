import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ants_10714 {

	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();//Integer.parseInt(in.readLine());
		
		while(t-- > 0){
			int l = sc.nextInt();
			int n = sc.nextInt();
			
			if(n == 0 || l == 0){
				out.printf("%d %d\n", 0, 0);
				continue;
			}
			
			int[] ants = new int[n];
			int E = 0;
			for (int i = 0; i < n; i++) {
				int ant = sc.nextInt();
				
				int cur = Math.min(ant, l - ant);
				
				if(cur > E)
					E = cur;					
				
				ants[i] = ant;
			}
			
			Arrays.sort(ants);
			
			int L = 0;
			if(l - ants[0] > ants[n - 1])
				L = l - ants[0];
			else
				L = ants[n - 1];
			
			out.printf("%d %d\n", E, L);
//			out.println(Arrays.toString(ants));
		}
		
		out.flush();
		out.close();
	}
}
