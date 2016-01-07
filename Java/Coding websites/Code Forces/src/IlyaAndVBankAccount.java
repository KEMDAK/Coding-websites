import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class IlyaAndVBankAccount {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sNum = new StringBuilder(in.readLine());
		int num = Integer.parseInt(sNum.toString());
		
		if(num >= 0){
			System.out.println(num);
			return;
		}
		
		int max = num / 10;
		
		int max2 = Integer.parseInt(sNum.deleteCharAt(sNum.length() - 2).toString());
		
		if(max2 > max)
			max = max2;
		
		System.out.println(max);
	}
}
