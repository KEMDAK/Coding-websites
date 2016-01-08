import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FractionsAgain_10976 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(in.ready()){
			int k = Integer.parseInt(in.readLine());
			
			int c = 0;
			
			for (int y = k + 1; true; y++) {
				if((k * y) % (y - k) == 0){
					int x = (k * y) / (y - k);
					out.printf("1/%d = 1/%d + 1/%d\n", k, x, y);
					c++;
				}

				if(y / 2 == k)
					break;
			}
			
			System.out.println(c);
			out.flush();
		}
		
		out.close();
	}
}
