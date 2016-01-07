import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class RandomTeams{
	
	public static long pair(long x){
		return ((x-1)*x)/2;
	}

	public static void main (String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		long n = Long.parseLong(s.nextToken());
		long m = Long.parseLong(s.nextToken());
		
		long max = pair(n - m + 1);
		
		long min = (pair(n / m) * (m - (n % m))) + (pair((n / m) + 1) * (n % m));
		
		System.out.println(min + " " + max);
    }
}