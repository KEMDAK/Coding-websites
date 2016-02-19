import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MooresLaw {

	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int T = in.nextInt();
		double x = 1.000000011;
		
		double pow = Math.pow(x, T);
		
		double res = pow * n;
		
		System.out.println(res);
		
	}
	
	private static class Scanner {
	    BufferedReader br;
	    StringTokenizer st;

	    public Scanner(FileReader f) {
	        br = new BufferedReader(f);
	    }

	    public Scanner(InputStream in) {
	        br = new BufferedReader(new InputStreamReader(in));
	    }

	    public String next() throws IOException {
	        while (st == null || !st.hasMoreTokens())
	            st = new StringTokenizer(br.readLine());
	        return st.nextToken();
	    }

	    public String nextLine() throws IOException {
	        return br.readLine();
	    }

	    public int nextInt() throws IOException {
	        return Integer.parseInt(next());
	    }

	    public long nextLong() throws IOException {
	        return Long.parseLong(next());
	    }

	    public double nextDouble() throws IOException {
	        return Double.parseDouble(next());
	    }

	    public boolean Ready() throws IOException {
	        return br.ready();
	    }

	    public void waitForInput(long time) {
	        long ct = System.currentTimeMillis();
	        while(System.currentTimeMillis() - ct < time) {};
	    }

	}
}