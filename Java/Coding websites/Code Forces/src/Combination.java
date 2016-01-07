import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Combination {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		Card[] cards = new Card[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			cards[i] = new Card(Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken()));
		}
		
		Arrays.sort(cards);
		
		int plays = 1;
		long score = 0;
		
		
		for (int i = n - 1; i > -1 && plays > 0; i--) {
			score += cards[i].a;
			plays += cards[i].b - 1;
		}
		
		System.out.println(score);
	}
}

class Card implements Comparable<Card>{
	int a, b;
	
	public Card(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Card o) {
		if(this.b - o.b != 0)
			return this.b - o.b;
		else
			return this.a - o.a;
	}
	
	
}
