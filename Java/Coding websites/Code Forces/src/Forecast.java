import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Forecast {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		double a = Double.parseDouble(s.nextToken());
		double b = Double.parseDouble(s.nextToken());
		double c = Double.parseDouble(s.nextToken());
		
		
		double res1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
		double res2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
		
		System.out.printf("%.7f\n", Math.max(res1, res2));
		System.out.printf("%.7f\n", Math.min(res1, res2));
	}
}
