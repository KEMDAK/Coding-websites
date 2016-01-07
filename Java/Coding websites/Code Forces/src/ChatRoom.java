import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ChatRoom {

	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[] hello = {'h', 'e', 'l', 'l', 'o'};
		
		String input = in.readLine();
		
		int cursor = 0;
		
		for (int i = 0; i < input.length(); i++){
			if(input.charAt(i) == hello[cursor])
				cursor++;
			if(cursor == 5)
				break;
		}
		
		if(cursor == 5)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
