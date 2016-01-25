import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class DNA_11961 {
	
	static char[] alpha = {'A', 'C', 'G', 'T'};
	static int N, K;
	static PrintWriter out;
	static int count;
	static ArrayList<String> results;
	
	public static void perm(int i, int remC, char[] c){
//		System.out.println(i + " " + remC + " " + Arrays.toString(c));
		if(i == N || remC == 0){
			String s = "";
			for (int j = 0; j < N; j++) {
				s += c[j];
			}
			results.add(s);
			
			count++;
			return;
		}
		
		perm(i + 1, remC, c.clone());
		int j = Arrays.binarySearch(alpha, c[i]);
		int temp = j;
		for (; j >= 0; j--) {
			if(c[i] == alpha[j]) continue;			
			char[] cc = c.clone();
			cc[i] = alpha[j];
			
			perm(i + 1, remC - 1, cc);
		}
		
		for (j = temp; j < 4; j++) {
			if(c[i] == alpha[j]) continue;			
			char[] cc = c.clone();
			cc[i] = alpha[j];
			
			perm(i + 1, remC - 1, cc);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		
		int t = Integer.parseInt(in.readLine());
		
		while(t-- > 0){
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			N = Integer.parseInt(s.nextToken());
			K = Integer.parseInt(s.nextToken());
			
			char[] input = new char[N];
			
			String st = in.readLine();
			int i = 0;
			for (; i < N; i++) {
				input[i] = st.charAt(i);
			}
			
			results = new ArrayList<>();
			
			count = 0;
			
			perm(0, K, input);
			
			out.println(count);
			Collections.shuffle(results);
			Collections.sort(results);
			
			for (int j = 0; j < results.size(); j++) {
				out.println(results.get(j));
			}
		}
		
		out.flush();
		out.close();
	}
}
