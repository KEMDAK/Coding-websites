import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Tprimes {

	static boolean[] notPrimes;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		notPrimes = new boolean[1000001];
		notPrimes[1] = true;
		
		sieve();
			
		in.readLine();
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		while(s.hasMoreTokens()){
			long d = Long.parseLong(s.nextToken());
			
			double sqrt =  Math.sqrt(d);
			
			if(sqrt - (int) sqrt != 0){
				out.println("NO");
				continue;
			}
			
			if(notPrimes[(int) sqrt])
				out.println("NO");
			else
				out.println("YES");
		}
		
		out.flush();
		out.close();		
	}

	public static void sieve() {
		for (int i = 2; i * i <= 1000000; i++) {
			if(!notPrimes[i]){
				for (int j = i; i * j <= 1000000; j++) {
					notPrimes[i * j] = true;
				}
			}
		}
	}
}
