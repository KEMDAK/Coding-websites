import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class CountingRabbits {

	public static BigInteger fib(long n) {
		long phi = (long) Math.pow(1.618033988749895, n);
		BigInteger r = new BigInteger(""
				+ (long) ((phi - (Math.pow(-1, n) / phi)) / (Math.sqrt(5)) + 1));
		return r;
	}

	public static BigInteger countRabbits(long n, int m) {
		return (((fib(n - 1).multiply(BigInteger.ONE.add(BigInteger.ONE))))
				.add(fib(n - 2)))
				.mod(BigInteger.ONE.add(BigInteger.ONE).pow(m));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(in.readLine());
		for (int i = 0; i < c; i++) {
			StringTokenizer s = new StringTokenizer(in.readLine());
			long n = Long.parseLong(s.nextToken());
			int m = Integer.parseInt(s.nextToken());
			System.out.println(countRabbits(n, m));
		}
	}
}
