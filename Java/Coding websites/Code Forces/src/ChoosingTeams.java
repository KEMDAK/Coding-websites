import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ChoosingTeams {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		s.nextToken();
		
		int k = Integer.parseInt(s.nextToken());
		
		s = new StringTokenizer(in.readLine());
		
		int teams = 0;
		int counter = 0;
		
		while(s.hasMoreTokens()){
			if(5 - Integer.parseInt(s.nextToken()) >= k)
				counter++;
			
			if(counter == 3){
				teams++;
				counter = 0;
			}
		}
		
		System.out.println(teams);
	}
}
