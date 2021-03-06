import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;

public class BrokenKeyboard_11988 {

	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(in.ready()){
			String text = in.readLine();
			
			boolean home = true;
			LinkedList<String> s = new LinkedList<>();
			
			StringBuilder cur = new StringBuilder("");
			for (int i = 0; i < text.length(); i++) {
				if(text.charAt(i) == '['){
					if(home)
						s.addFirst(cur.toString());
					else
						s.addLast(cur.toString());
					
					cur = new StringBuilder("");
					home = true;
				}
				else if(text.charAt(i) == ']'){
					if(home)
						s.addFirst(cur.toString());
					else
						s.addLast(cur.toString());
					
					cur = new StringBuilder("");
					home = false;
				}
				else{
					cur.append(text.charAt(i));
				}
			}
			
			if(home)
				s.addFirst(cur.toString());
			else
				s.addLast(cur.toString());
			
			for (String string : s) {
				out.print(string);
			}
			out.println();
		}
		
		out.flush();
		out.close();
	}
}
