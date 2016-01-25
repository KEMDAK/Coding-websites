import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SplittingNumbers_11933 {

	
	public static void main(String[] args) throws NumberFormatException, Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(true){
			int n = Integer.parseInt(in.readLine());
			
			if(n == 0)
				break;
			
			int counter = 0;
			int a = 0;
			int b = 0;
			
			for (int i = 0; i < 32; i++) {
				if((n & (1 << i)) != 0){
					if(counter % 2 == 0){
						a |= (1 << i);
					}
					else{
						b |= (1 << i);
					}
					
					counter++;
				}
			}
			
			out.println(a + " " + b);
		}
		
		out.flush();
		out.close();
	}
}
