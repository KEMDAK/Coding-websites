import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class TEXQuotes_272 {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int c = 0;
		
		while(in.ready()){
			String s = in.readLine();

			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) != '"')
					out.print(s.charAt(i));
				else if(c == 0){
					out.print("``");
					c++;
					c %= 2;
				}
				else{
					out.print("''");
					c++;
					c %= 2;
				}
			}
			
			out.println();
		}
		
		out.flush();
		out.close();
	}
}
