import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


class Position{
	int x;
	int y;
	char ori;
	
	public Position(int x, int y, char ori) {
		this.x = x;
		this.y = y;
		this.ori = ori;
	}
}

public class MutantFlatWorldExplorers_118 {

	static char[][] world;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer s = new StringTokenizer(in.readLine());

		int m = Integer.parseInt(s.nextToken());
		int n = Integer.parseInt(s.nextToken());

		world = new char[n + 1][m + 1];

		while(in.ready()){
			s = new StringTokenizer(in.readLine());
			
			int y = Integer.parseInt(s.nextToken());
			int x = n- Integer.parseInt(s.nextToken());
			
			Position p = new Position(x, y, s.nextToken().charAt(0));
			
			String instructions = in.readLine();
			
			int i;
			
			for (i = 0; i < instructions.length(); i++) {
				if(!instruction(p, instructions.charAt(i))){
					out.println(p.y + " " + (n - p.x) + " " + p.ori + " " + "LOST");
					break;
				}
			}
			
			if(i == instructions.length())
				out.println(p.y + " " + (n - p.x) + " " + p.ori);
		}
		
		out.flush();
		out.close();
	}
	
	public static boolean instruction(Position p, char i){
		if(i == 'R'){
			switch (p.ori) {
			case 'E': p.ori = 'S'; break;
			case 'W': p.ori = 'N'; break;
			case 'N': p.ori = 'E'; break;
			case 'S': p.ori = 'W'; break;
			}
		}
		else if (i == 'L'){
			switch (p.ori) {
			case 'E': p.ori = 'N'; break;
			case 'W': p.ori = 'S'; break;
			case 'N': p.ori = 'W'; break;
			case 'S': p.ori = 'E'; break;
			}
		}
		else{
			int x = p.x;
			int y = p.y;
			
			switch (p.ori) {
			case 'E': y++; break;
			case 'W': y--; break;
			case 'N': x--; break;
			case 'S': x++; break;
			}
			
			if(valid(x, y)){
				p.x = x;
				p.y = y;
			}
			
			else if(world[p.x][p.y] != 'L'){
				world[p.x][p.y] = 'L';
				return false;
			}
		}
		
		return true;
	
		
	}
	
	public static boolean valid(int x, int y){
		return (x >= 0 && x < world.length && y >=0 && y < world[0].length);
	}
}
