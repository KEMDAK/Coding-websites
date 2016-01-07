import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class YoungPhysicist {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		int x = 0;
		int y = 0;
		int z = 0;
		
		while(n-- > 0){
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			x += Integer.parseInt(s.nextToken());
			y += Integer.parseInt(s.nextToken());
			z += Integer.parseInt(s.nextToken());
		}
		
		if(x == 0 && y == 0 && z == 0)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
