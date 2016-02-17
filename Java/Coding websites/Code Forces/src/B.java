import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;

public class B {

	static TreeSet<Character> set;
	static char[] cards;
	static int nextFree;

	public static void rec(int rem, int index){
		if(set.size() == 3)
			return;
		if(rem == 1){
			set.add(cards[nextFree - 1]);
			return;
		}
		if(index >= nextFree)
			return;
		if(cards[index] == '*')
			rec(rem, index + 1);
		
		for (int i = index + 1; i < nextFree; i++) {
			if(cards[i] == '*')
				continue;
			
			char newCard = generate(index, i);
			char indexTemp = cards[index];
			char iTemp = cards[i];
			cards[index] = '*';
			cards[i] = '*';
			cards[nextFree] = newCard;
			nextFree++;
			
			rec(rem - 1, index + 1);
			
			cards[index] = indexTemp;
			cards[i] = iTemp;
			nextFree--;
			cards[nextFree] = '*';
		}
	}

	public static char generate(int index, int i) {
		if(cards[index] == cards[i])
			return cards[i];
		else if(cards[index] == 'G' && cards[i] == 'B' || cards[i] == 'G' && cards[index] == 'B')
			return 'R';
		else if(cards[index] == 'G' && cards[i] == 'R' || cards[i] == 'G' && cards[index] == 'R')
			return 'B';
		else if(cards[index] == 'B' && cards[i] == 'R' || cards[i] == 'B' && cards[index] == 'R')
			return 'G';
		return '*';
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n = Integer.parseInt(in.readLine());

		cards = new char[10000000];
		java.util.Arrays.fill(cards, '*');
		nextFree = 0;
		set = new TreeSet<>();

		String s = in.readLine();
		
		for (int i = 0; i < n; i++) {
			cards[i] = s.charAt(i);
			nextFree++;
		}
		
		rec(n, 0);
		
		for (Character c : set) {
			if(c != '*')
				out.print(c);
		}
		
		out.flush();
		out.close();
	}
}
