import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GenasCode {

	public static int z(String s){
		int res = 0;
		
		if(s.charAt(0) != '1' && s.charAt(0) != '0')
			return -1;
		
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i) != '0')
				return -1;
			
			res++;
		}
		
		return res;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		
		int n = Integer.parseInt(in.readLine());
		
		int zeros = 0;
		String not = "1";
		StringTokenizer s = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			String num = s.nextToken();
			
			if(num.length() == 1 && num.charAt(0) == '0'){
				System.out.print(0);
				return;
			}
			int z = z(num);
			
			if(z != -1){
				zeros += z;
			}
			else{
				not = num;
			}
		}
		
		out.print(not);
		for (int i = 0; i < zeros; i++) {
			out.print(0);
		}
		
		out.flush();
		out.close();
	}
}
