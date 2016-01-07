import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class AandBandCompilationErrors {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in.readLine();

		StringTokenizer s = new StringTokenizer(in.readLine());

		BigInteger first = new BigInteger("0");
		while (s.hasMoreTokens()) {
			first = first.add(new BigInteger(s.nextToken()));
		}

		s = new StringTokenizer(in.readLine());

		BigInteger second = new BigInteger("0");
		while (s.hasMoreTokens()) {
			second = second.add(new BigInteger(s.nextToken()));
		}

		s = new StringTokenizer(in.readLine());

		BigInteger third = new BigInteger("0");
		while (s.hasMoreTokens()) {
			third = third.add(new BigInteger(s.nextToken()));
		}

		System.out.println(first.subtract(second) + "\n"
				+ second.subtract(third));
	}
}
