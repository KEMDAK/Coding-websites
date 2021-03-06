import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CheapTravel {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer s = new StringTokenizer(in.readLine());

		int n = Integer.parseInt(s.nextToken());
		int m = Integer.parseInt(s.nextToken());
		int a = Integer.parseInt(s.nextToken());
		int b = Integer.parseInt(s.nextToken());

		int min = 10000000;

		for (int i = 0; i <= n; i++) {

			int cost;
			if(((n - i) % m) != n){
				cost = (a * i) + (((n - i) / m) * b);
				if (n-(i + ((n-i)/m)*m) > 0)
					cost += b;
			}
			else
				cost = (a * i) + b;

			if(cost < min)
				min = cost;

		}

		System.out.println(min);
	}
}
