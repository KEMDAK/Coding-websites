import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class LinkOrCutTree {

	public static long pow(long base, long pow){
		if(pow == 0) return 1;
		
		return base * pow(base, pow - 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		BigInteger l = new BigInteger(s.nextToken());
		BigInteger r = new BigInteger(s.nextToken());
		BigInteger k = new BigInteger(s.nextToken());
		
		int p = 0;
		BigInteger res = k.pow(p++);
		
		int count = 0;
		while(res.compareTo(r) <= 0){
			if(res.compareTo(l) >= 0){
				out.print(res + " ");
				count++;
			}
			res = res.multiply(k);
		}
		
		if(count == 0)
			out.print(-1);
		
		out.flush();
		out.close();
	}
}
