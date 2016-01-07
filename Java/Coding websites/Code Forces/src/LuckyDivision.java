import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LuckyDivision {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int number = Integer.parseInt(in.readLine());

		for (int i = 4; i <= number; i++) {

			if(valid(i)){
				if(number % i == 0){
					System.out.println("YES");
					return;
				}
			}
		}

		System.out.println("NO");
	}

	private static boolean valid(int i) {

		while (i != 0){
			if(!(i % 10 == 4 || i % 10 == 7))
				return false;
			i /= 10;
		}
		
		return true;
	}
}
