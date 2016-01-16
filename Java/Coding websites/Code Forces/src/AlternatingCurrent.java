import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class AlternatingCurrent {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String s = in.readLine();
		
		if(s.length() % 2 == 1){
			System.out.println("No");
			return;
		}
		
		System.out.println(can(s) ? "Yes" : "No");
	}

	public static boolean can(String s) {
		Stack<Character> st = new Stack<>();
		int length = s.length();
		for (int i = 0; i < length; i++) {
			if(st.isEmpty() || s.charAt(i) != st.peek())
				st.push(s.charAt(i));
			else
				st.pop();
		}
		
		return st.isEmpty();
	}
}
