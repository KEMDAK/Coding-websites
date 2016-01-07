import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AmusingJoke {

	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder s1 = new StringBuilder(in.readLine());
		StringBuilder s2 = new StringBuilder(in.readLine());
		StringBuilder s3 = new StringBuilder(in.readLine());
		
		if(s3.length() != s1.length() + s2.length()){
			System.out.println("NO");
			return;
		}
		
		for (int i = 0; i < s3.length(); i++) {
			int sI1 = s1.indexOf(s3.charAt(i) + "");
			int sI2 = s2.indexOf(s3.charAt(i) + "");
			if(sI1 != -1)
				s1.deleteCharAt(sI1);
			else if(sI2 != -1)
				s2.deleteCharAt(sI2);
			else{
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");
	}
}
