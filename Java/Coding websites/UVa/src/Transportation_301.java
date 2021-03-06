import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Transportation_301 {

	static int[] src, dest, p;
	static int n, b, o;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(true){
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			n = Integer.parseInt(s.nextToken());
			b = Integer.parseInt(s.nextToken());
			o = Integer.parseInt(s.nextToken());
			
			if(n == 0 && b == 0 && o == 0)
				break;
			
			src = new int[o];
			dest = new int[o];
			p = new int[o];
			
			for (int i = 0; i < o; i++) {
				s = new StringTokenizer(in.readLine());
				
				src[i] = Integer.parseInt(s.nextToken());
				dest[i] = Integer.parseInt(s.nextToken());
				p[i] = Integer.parseInt(s.nextToken());
			}
			
			int[] comb = new int[b];
			int[] max = rec(0, comb);
			
			int res = 0;
			for (int i = 0; i < max.length; i++) {
				res += max[i];
			}
			
			out.println(res);
		}
		
		out.flush();
		out.close();
	}

	public static int[] rec(int i, int[] comb) {
		if(i == o){
			return comb;
		}
		
		boolean valid = true;
		int[] comb1 = comb.clone();
//		System.out.println(i);
		for (int j = src[i]; j < dest[i]; j++) {
			if(comb[j] + p[i] > n){
				valid = false;
				break;
			}
			else{
				comb1[j] += p[i];
			}
		}
		
		int[] take = null;
		if(valid)
			take = rec(i + 1, comb1);
		
		int[] leave = rec(i + 1, comb.clone());
		
		if(!valid)
			return leave;
		
		int sumt = 0;
		for (int j = 0; j < take.length; j++) {
			sumt += take[j];
		}
		
		int suml = 0;
		for (int j = 0; j < leave.length; j++) {
			suml += leave[j];
		}
		
		if(suml > sumt)
			return leave;
		
		return take;
	}
}
