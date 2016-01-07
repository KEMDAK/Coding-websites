import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Bars_12455 {

	static int[] bars;
	static int p;
	static Boolean[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int t= Integer.parseInt(in.readLine());
		
		while(t-- > 0){
			int n = Integer.parseInt(in.readLine());
			p = Integer.parseInt(in.readLine());
			
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			bars = new int[p];
			
			for (int i = 0; i < p; i++) {
				bars[i] = Integer.parseInt(s.nextToken());
			}
			
			dp = new Boolean[p + 1][1500];
			
			out.println(valid(0, n) ? "YES" : "NO");
		}
		
		out.flush();
		out.close();
	}

	public static boolean valid(int i, int n) {
		if(n == 0)
			return true;
		if(n < 0)
			return false;
		if(i == p)
			return false;
		
		if(dp[i][n] != null)
			return dp[i][n];
		
		boolean take = valid(i + 1, n - bars[i]);
		boolean leave = valid(i + 1, n);
		
		return dp[i][n] = take || leave;
	}
}
