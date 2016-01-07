import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class IWannaBeTheGuy {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());

		boolean[] levels = new boolean[n];

		StringTokenizer s = new StringTokenizer(in.readLine());
		
		s.nextToken();

		while(s.hasMoreTokens()){
			levels[Integer.parseInt(s.nextToken()) - 1] = true;
		}

		s = new StringTokenizer(in.readLine());

		s.nextToken();
		
		while(s.hasMoreTokens()){
			levels[Integer.parseInt(s.nextToken()) - 1] = true;
		}
		
		for (int i = 0; i < levels.length; i++) {
			if(!levels[i]){
				System.out.println("Oh, my keyboard!");
				return;
			}
		}
		
		System.out.println("I become the guy.");
	}
}
