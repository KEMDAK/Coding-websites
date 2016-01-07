import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class IsYourHorseshoeOnTheOtherHoof {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		HashSet<Integer> set = new HashSet<>();
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		int diff = 0;
		
		while(s.hasMoreTokens()){
			int num = Integer.parseInt(s.nextToken());
			if(!set.contains(num))
				set.add(num);
			else
				diff++;
		}
		
		System.out.println(diff);
	}
}
