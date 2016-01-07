import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoubleCola {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] queue = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
		
		int given = Integer.parseInt(in.readLine());
		
		if(given <= 5){
			System.out.println(queue[given - 1]);
			return;
		}
		
		int i = 0;
		long sum = 5;
		
		while(sum < given){
			sum *= 2;
			sum += 5;
			i++;
		}
	
		sum = (sum - 5) / 2;
		
		System.out.println(queue[(int) ((given - sum) / Math.pow(2, i))]);
	}
}
