import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class RobotSequence {

	static char[] instructions;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int n = Integer.parseInt(in.readLine());
		
		instructions = new char[n];
		
		String s = in.readLine();
		
		for (int i = 0; i < n; i++) {
			instructions[i] = s.charAt(i);
		}
		
		long res = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if(isStable(i, j))
					res++;
			}
		}
		
		out.println(res);
		out.flush();
		out.close();
	}
	
	public static boolean isStable(int i, int j){
		int dx = 0;
		int dy = 0;
		
		for (int k = i; k <= j; k++) {
			if(instructions[k] == 'U')
				dy--;
			else if(instructions[k] == 'D')
				dy++;
			else if(instructions[k] == 'R')
				dx++;
			else if(instructions[k] == 'L')
				dx--;
		}
		
		return (dx == 0 && dy == 0);
	}
}
