import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PashaAndStick {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(in.readLine());
		
		if(n % 2 == 1){
			System.out.println(0);
			return;
		}		
		n -= 2;
		
		n /= 2;
		
		n /= 2;
		
		System.out.println(n);
	}
}
