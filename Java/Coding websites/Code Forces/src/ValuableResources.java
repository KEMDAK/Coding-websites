import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ValuableResources {

	public static void shuffle(long[] x){
		for (int i = 0; i < x.length; i++) {
			int newIndex = (int) (Math.random() * x.length);
			
			long temp = x[i];
			x[i] = x[newIndex];
			x[newIndex] = temp;
		}
	}
	
	public static void main (String [] args) throws NumberFormatException, IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(buffer.readLine());
		long[] x = new long[n];
		long[] y = new long[n];
		for (int i = 0; i < n; i++){
			StringTokenizer s = new StringTokenizer(buffer.readLine());
			long a = (Long.parseLong(s.nextToken()));
			long b = (Long.parseLong(s.nextToken()));
			
			x[i] = a;
			y[i] = b;
		}
		
		shuffle(x);
		shuffle(y);
		Arrays.sort(x);
		Arrays.sort(y);
		
		long max = 0;
		
		if(x[n - 1] - x[0] > max)
			max = x[n - 1] - x[0];
		if(y[n - 1] - y[0] > max)
			max = y[n - 1] - y[0];
		
		System.out.println(max * max);


	}
}