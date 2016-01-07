import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class EvenOdds {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer s = new StringTokenizer(in.readLine());

		long n = Long.parseLong(s.nextToken());
		long k = Long.parseLong(s.nextToken());

		long middle; 

		if (n % 2 == 0)
			middle = n/2;
		else
			middle = (n/2) + 1;

		if(k > middle)
			System.out.println((k - middle) * 2);
		else
			System.out.println((k * 2) - 1);
	}
}
