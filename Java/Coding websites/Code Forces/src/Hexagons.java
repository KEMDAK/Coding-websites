import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hexagons {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(in.readLine());
		
		System.out.println((6 * ((n * (n + 1)) / 2)) + 1);
	}
}
