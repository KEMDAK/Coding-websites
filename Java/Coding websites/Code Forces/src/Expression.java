import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Expression {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(in.readLine());
		int b = Integer.parseInt(in.readLine());
		int c = Integer.parseInt(in.readLine());
		
		int max = 0;
		
		for (int i = 0; i < 4; i++) {
			String operations = signs(i);
			
			int result = 0;
			
//			System.out.println("(" + a + operations.charAt(0) + b + ")" + operations.charAt(1) + c);
			result = calculate(a, b, operations.charAt(0));
			result = calculate(result, c, operations.charAt(1));

			if(result > max)
				max = result;
		}
		
		for (int i = 0; i < 4; i++) {
			String operations = signs(i);
			
			int result = 0;
			
//			System.out.println(a + "" + operations.charAt(0) + "(" +  b + operations.charAt(1) + c + ")");
			result = calculate(b, c, operations.charAt(1));
			result = calculate(a, result, operations.charAt(0));
			
			
			if(result > max)
				max = result;
		}
		
		System.out.println(max);
	}
	
	public static int calculate(int a, int b, char o){
		switch (o) {
		case '+':
			return a + b;
		default:
			return a * b;
		}
	}
	
	public static String signs(int i){
		if(i == 0)
			return "++";
		else if(i == 1)
			return "+*";
		else if(i == 2)
			return "*+";
		else
			return"**";
	}
}
