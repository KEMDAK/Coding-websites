import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class AddTwoNumbers_344 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		System.out.println(Integer.parseInt(s.nextToken()) + Integer.parseInt(s.nextToken()));
	}
}
