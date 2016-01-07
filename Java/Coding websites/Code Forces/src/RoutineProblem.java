import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RoutineProblem {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		long a = Long.parseLong(s.nextToken());
		long b = Long.parseLong(s.nextToken());
		long c = Long.parseLong(s.nextToken());
		long d = Long.parseLong(s.nextToken());
		
		long lcmU = lcm(a, c);
		long lcmL = lcm(b, d);
		
//		System.out.println(lcmU);
//		System.out.println(lcmL);
		
		if((lcmU / a) * b >= d * (lcmU / c)){
			long cons1 = (lcmU / a);
			a *= cons1;
			b *= cons1;
			long cons2 = (lcmU / c);
			c *= cons2;
			d *= cons2;
		}
		else{
			long cons1 = (lcmL / b);
			a *= cons1;
			b *= cons1;
			long cons2 = (lcmL / d);
			c *= cons2;
			d *= cons2;
		}
		
//		System.out.printf("%d %d %d %d\n", a, b, c, d);
		
		long totalArea = a*b;
	    long filmArea = c*d;

	    long emptyArea = totalArea-filmArea;

	    long g = gcd(emptyArea,totalArea);
	    System.out.printf("%d/%d",emptyArea/g,totalArea/g);
		
	}
	
	public static long gcd(long a, long b)
	{
	    return b == 0 ? a : gcd(b, a % b);
	}
	
	public static long lcm(long a, long b){
		return (a * b) / gcd(a, b);
	}
}
