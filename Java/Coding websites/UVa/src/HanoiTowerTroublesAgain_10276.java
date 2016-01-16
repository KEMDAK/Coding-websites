import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class HanoiTowerTroublesAgain_10276 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int t = Integer.parseInt(in.readLine());

		while(t-- > 0){
			int n = Integer.parseInt(in.readLine());

			int[] base = new int[n];

			long res = 0;
			int num = 1;
			
			while(true){
				boolean valid = false;
				for (int i = 0; i < n; i++) {
					int prev = base[i];
					
					if(prev == 0){
						valid = true;
						base[i] = num;
						break;
					}
					
					if(isSquare(prev + num)){
						valid = true;
						base[i] = num;
						break;
					}
				}
				
				if(valid){
					res++;
					num++;
				}
				else
					break;
			}
			
			out.println(res);
		}
		
		out.flush();
		out.close();
	}

	public static boolean isSquare(int x) {
		double sqrt = Math.sqrt(x);
		
		if(sqrt - (int) sqrt == 0)
			return true;
		
		return false;
	}
}
