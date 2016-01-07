import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReplaceToMakeRegularBracketSequence {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String st = in.readLine();

		int t = 0;
		long res = 0;
		Stack<Character> s = new Stack<>();

		for (int i = 0; i < st.length(); i++) {
			if(opening(st.charAt(i)))
				t++;
			else
				t--;
			
			if(t < 0){
				System.out.println("Impossible");
				return;
			}
			
			if(opening(st.charAt(i)))
				s.push(st.charAt(i));
			else if(!isSameType(s.pop(), st.charAt(i)))
				res++;
		}

		if(t == 0){
			System.out.println(res);
		}
		else
			System.out.println("Impossible");
	}
	
	public static boolean isSameType(char a, char b){
		return ((a == '[' && b == ']') || (a == '{' && b == '}') || (a == '(' && b == ')') || (a == '<' && b == '>'));
	}
	
	public static boolean closing(char c){
		return (c == ')' || c == '}' || c == '>' || c == ']');
	}
	
	public static boolean opening(char c){
		return (c == '(' || c == '{' || c == '<' || c == '[');
	}
}