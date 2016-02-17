import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class OneLittleTwoLittleThreeLittleEndians_594 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(in.ready()){
			int n = Integer.parseInt(in.readLine());
			
			out.printf("%d converts to %d\n", n, convert(n));
		}
		
		out.flush();
		out.close();
	}
	
	public static int convert(int x){
		int res = 0;
		for (int i = 0; i < 4; i++) {
			int offset = i * 8;
			int mask = 0;
			for (int j = 0; j < 8; j++) {
				if((x & (1 << (j + offset))) != 0){
					mask |= (1 << j);
				}
			}
			
			res |= (mask << (3 - i) * 8);
		}
		
		return res;
	}
}
