import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


public class MorganAndAString {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());

		while(T-- > 0){
			String s1 = in.readLine();
			String s2 = in.readLine();

			int s1Size = s1.length();
			int s2Size = s2.length();
			
			int minSize = Math.min(s1Size, s2Size);
			
			int[] s1Tie = new int[minSize];
			int[] s2Tie = new int[minSize];
			
			for (int i = 0; i < minSize - 1;) {
				int end = i + 1;
				while(end < minSize && (s1.charAt(end) == s2.charAt(end)))
					end++;
				
				if(end == minSize)
					end--;
				
				for (int j = i; j <= end; j++) 
					s1Tie[j] = s1.charAt(end) - 'A';
				
				i = end;
			}
			
			for (int i = 0; i < minSize - 1;) {
				int end = i + 1;
				while(end < minSize && (s1.charAt(end) == s2.charAt(end)))
					end++;
				
				if(end == minSize)
					end--;
				
				for (int j = i; j <= end; j++) 
					s2Tie[j] = s2.charAt(end) - 'A';
				
				i = end;
			}
			
			s1Tie[minSize - 1] = s1Tie[minSize - 2];
			s2Tie[minSize - 1] = s2Tie[minSize - 2];
			
//			System.out.println(Arrays.toString(s1Tie));
//			System.out.println(Arrays.toString(s2Tie));

			int c1 = 0;
			int c2 = 0;

			StringBuilder res = new StringBuilder("");

			while(c1 != s1Size || c2 != s2Size){
				if(c1 < s1Size && c2 < s2Size){
					if(s1.charAt(c1) < s2.charAt(c2)){
						res.append(s1.charAt(c1));
						c1++;
					}
					else if(s1.charAt(c1) > s2.charAt(c2)){
						res.append(s2.charAt(c2));
						c2++;
					}
					else{
						if(s1Tie[c1] < s2Tie[c2]){
							res.append(s1.charAt(c1));
							c1++;
						}
						else{
							res.append(s2.charAt(c2));
							c2++;
						}
					}
				}
				else{
					if(c1 < s1Size){
						res.append(s1.charAt(c1));
						c1++;
					}
					else{
						res.append(s2.charAt(c2));
						c2++;
					}
				}
			}

			out.println(res);
		}

		out.flush();
		out.close();
	}
}
