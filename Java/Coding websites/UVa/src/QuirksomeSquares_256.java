import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class QuirksomeSquares_256 {

	static int d;
	
	public static String isQuirksomeSquare(int x){
		String s = print(x);
		
		int left = Integer.parseInt(s.substring(0, s.length() / 2));
		int right = Integer.parseInt(s.substring(s.length() / 2));
		
		if((left + right) * (left + right) == x){
			return s;
		}
		else
			return null;
	}
	
	public static String print(int x){
		StringBuilder out = new StringBuilder("" + x);
		
		int zeros = d - out.length();
		
		for (int i = 0; i < zeros; i++) {
			out.insert(0, "0");
		}
		
		return out.toString();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(in.ready()){
			d = Integer.parseInt(in.readLine());
			
			if(d >= 2)
				for (int i = 0; i < 100; i++) {
					String s = isQuirksomeSquare(i);
					if(s != null)
						out.println(s);
				}
			if(d >= 4)
				for (int i = 100; i < 10000; i++) {
					String s = isQuirksomeSquare(i);
					if(s != null)
						out.println(s);
				}
			if(d >= 6)
				for (int i = 10000; i < 10000000; i++) {
					String s = isQuirksomeSquare(i);
					if(s != null)
						out.println(s);
				}
			if(d >= 8)
				for (int i = 10000000; i < 1000000000; i++) {
					String s = isQuirksomeSquare(i);
					if(s != null)
						out.println(s);
				}
		}
		
		out.flush();
		out.close();
	}
}
