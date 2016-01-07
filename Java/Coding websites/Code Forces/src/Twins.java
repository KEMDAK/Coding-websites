import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Twins {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		in.readLine();
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		ArrayList<Integer> coins = new ArrayList<Integer>();
		
		int sum = 0;
		
		while(s.hasMoreTokens()){
			int val = Integer.parseInt(s.nextToken());
			sum += val;
			coins.add(val);
		}
		
		Collections.sort(coins);
		
		int sumSoFar = 0;
		int numberOfCoins = 0;
		
		for (int i = coins.size() - 1; i >= 0; i--) {
			sumSoFar += coins.get(i);
			numberOfCoins++;
			
			if(sumSoFar > (sum/2))
				break;
		}
		
		System.out.println(numberOfCoins);
	}
}
