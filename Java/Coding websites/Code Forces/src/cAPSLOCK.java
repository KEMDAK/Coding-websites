import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cAPSLOCK {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();

		for (int i = 1; i < s.length(); i++) {
			if(Character.isLowerCase(s.charAt(i))){
				System.out.println(s);
				return;
			}
		}

		StringBuilder res = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if(Character.isLowerCase(s.charAt(i)))
				res.append(Character.toUpperCase(s.charAt(i)));
			else
				res.append(Character.toLowerCase(s.charAt(i)));
		}
		
		System.out.println(res);
	}
}
