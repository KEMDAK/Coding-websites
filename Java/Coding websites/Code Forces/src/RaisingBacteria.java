import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RaisingBacteria {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(in.readLine());

		int num = 1;
		
		int res = 1;
		
		do{	
			
			if(num == x)
				break;
			
			if(num > x){
				x = x - (num / 2);
				num = 1;
				res++;
			}
			
			num *= 2;
		}
		while(x != 1);
		
		System.out.println(res);
	}
}
