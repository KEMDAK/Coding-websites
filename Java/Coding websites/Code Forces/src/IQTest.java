import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class IQTest {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		in.readLine();
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		int evenIndex = 1;
		int oddIndex = 1;
		int odds = 0;
		
		for (int i = 1; s.hasMoreTokens(); i++) {
			if(Integer.parseInt(s.nextToken()) % 2 == 0){
				evenIndex = i;
			}
			else{
				oddIndex = i;
				odds++;
			}
		}
		
		if(odds == 1)
			System.out.println(oddIndex);
		else
			System.out.println(evenIndex);
	}
}
