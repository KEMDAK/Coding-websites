import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Antonandcurrencyyouallknow {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String s = in.readLine();
		StringBuilder number = new StringBuilder(s);
		
		int length = number.length();
		
		for (int i = 0; i < length; i++) {
			if(((number.charAt(i) - '0') % 2 == 0) && ((number.charAt(i) - '0') < (number.charAt(length - 1) - '0'))){
				char temp = number.charAt(i);
				number.setCharAt(i, number.charAt(length - 1));
				number.setCharAt((length - 1), temp);
				System.out.println(number);
				return;
			}
		}
		
		for (int i = length-2; i >= 0; i--) {
			if(((number.charAt(i) - '0') % 2 == 0) && ((number.charAt(i) - '0') > (number.charAt(length - 1) - '0'))){
				char temp = number.charAt(i);
				number.setCharAt(i, number.charAt(length - 1));
				number.setCharAt((length - 1), temp);
				System.out.println(number);
				return;
			}
		}
		
		System.out.println(-1);
	}
	
//	public static BigInteger transform(int i, BigInteger tmp) {
//		BigInteger lastDigit = tmp.mod(new BigInteger("10"));
//		
//		BigInteger beforeDigit = tmp.divide(new BigInteger((int) (Math.pow(10, length-i))+""));
//		beforeDigit = beforeDigit.multiply(new BigInteger((int) (Math.pow(10, length-i))+""));
//		
//		BigInteger afterDigit = tmp.mod(new BigInteger((int) (Math.pow(10, length-i - 1))+""));
//		afterDigit = afterDigit.divide(new BigInteger("10")).multiply(new BigInteger("10"));
//		
//		BigInteger middle = new BigInteger(number.charAt(i)+"");
//		
//		lastDigit = lastDigit.multiply(new BigInteger((int) (Math.pow(10, length -i - 1))+""));
//		
//		return lastDigit.add(beforeDigit).add(afterDigit).add(middle);
//	}
}
