import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class AndysFirstDictionary_10815 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		TreeSet<String> dic = new TreeSet<>();
		
		while(in.ready()){
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			while(s.hasMoreTokens()){
				String word = s.nextToken();
				String pureWord = "";
				
				for (int i = 0; i < word.length(); i++) {
					if(Character.isLetter(word.charAt(i)))
						pureWord += Character.toLowerCase(word.charAt(i));
					else{
						if(!pureWord.isEmpty())
							dic.add(pureWord);
						pureWord = "";
					}
				}
				
				if(!pureWord.isEmpty())
					dic.add(pureWord);
			}
		}
		
		for (String string : dic) {
			out.println(string);
		}
		
		out.flush();
		out.close();
	}
}
