import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class CrackingTheCode {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String s = in.readLine();
		
		String num = "" + s.charAt(0) + s.charAt(2) + s.charAt(4) + s.charAt(3) + s.charAt(1);
		
		String res = (BigInteger.valueOf(Long.parseLong(num)).pow(5)).mod(BigInteger.valueOf(100000L)).toString();
		
		while(res.length() < 5)
			res = "0" + res;
		System.out.println(res);
	}
}
