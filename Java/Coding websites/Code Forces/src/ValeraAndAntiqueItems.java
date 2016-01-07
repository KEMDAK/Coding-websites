import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ValeraAndAntiqueItems {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(s.nextToken());
		int v = Integer.parseInt(s.nextToken());
		
		int p = 0;
		String sellers = "";
		
		for (int i = 1; i <= n; i++) {
			s = new StringTokenizer(in.readLine());
			s.nextToken();
			
			while(s.hasMoreTokens())
				if(v > Integer.parseInt(s.nextToken())){
					if(i != n)
						sellers += i + " ";
					else
						sellers += i;
					p++;
					break;
				}
		}
		
		System.out.println(p);
		System.out.print(sellers);
	}
}
