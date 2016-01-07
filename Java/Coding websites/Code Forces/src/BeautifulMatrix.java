import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BeautifulMatrix {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer s = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				if (s.nextToken().charAt(0) == '1'){
					int res = Math.abs((2 - i)) + Math.abs((2 - j));
					System.out.print(res);
					return;
				}
			}
		}
	}
}
