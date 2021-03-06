import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SelectionOfPersonnel {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		BigInteger[] fac = new BigInteger[n + 1];
		fac[0] = BigInteger.ONE;
		for (int i = 1; i < n + 1; i++) {
			fac[i] = fac[i - 1].multiply(new BigInteger(i + ""));
		}

		BigInteger c1 = fac[n].divide(fac[5].multiply(fac[n - 5]));
		BigInteger c2 = fac[n].divide(fac[6].multiply(fac[n - 6]));
		BigInteger c3 = fac[n].divide(fac[7].multiply(fac[n - 7]));
		
		System.out.println(c1.add(c2.add(c3)));
	}
}
