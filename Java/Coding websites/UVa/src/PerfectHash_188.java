import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PerfectHash_188 {

	static ArrayList<Integer> words;
	static int c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(in.ready()){
			String line = in.readLine();
			
			StringTokenizer s = new StringTokenizer(line);
			
			words = new ArrayList<>();
			
			while(s.hasMoreTokens()){
				String word = s.nextToken();
				int w = 0;
				
				int count = 0;
				for (int i = word.length() - 1; i >= 0; i--)
					w += (word.charAt(i) - 'a' + 1) * Math.pow(32, count++);
				
				words.add(w);
			}
			
//			out.println(words);
			
			int n = words.size();
			c = 1;
			
			while(true){
				boolean hasConflict = false;
				
				int maxC = 1;
				for (int i = 0; i < words.size(); i++) {
					for (int j = 0; j < words.size(); j++) {
						if(i == j) continue;
						
						int ci = (((c / words.get(i))) % n);
						int cj = (((c / words.get(j))) % n);
						
						int minC = -1;
						if(ci == cj){
							ci = (((c / words.get(i)) + 1) * words.get(i));
							cj = (((c / words.get(j)) + 1) * words.get(j));
							
							minC = Math.min(ci, cj);
							maxC = Math.max(maxC, minC);
							hasConflict = true;
						}
						
						
					}
				}
				
				if(!hasConflict)
					break;
				else
					c = maxC;
			}
			
			out.println(line);
			out.println(c);
			out.println();
		}
		
		out.flush();
		out.close();
	}
}
