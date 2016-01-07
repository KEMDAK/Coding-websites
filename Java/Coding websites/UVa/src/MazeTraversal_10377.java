import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class PositionM{
	int x;
	int y;
	char ori;

	public PositionM(int x, int y, char ori) {
		this.x = x;
		this.y = y;
		this.ori = ori;
	}
}

public class MazeTraversal_10377 {

	static char[][] world;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int t = Integer.parseInt(in.readLine());

		while(t-- > 0){

			in.readLine();

			StringTokenizer s = new StringTokenizer(in.readLine());

			int n = Integer.parseInt(s.nextToken());
			int m = Integer.parseInt(s.nextToken());

			world = new char[n][m];

			for (int i = 0; i < n; i++) {
				String row = in.readLine();
				for (int j = 0; j < m; j++) {
					world[i][j] = row.charAt(j);
				}
			}
			
			s = new StringTokenizer(in.readLine());

			int x = Integer.parseInt(s.nextToken()) - 1;
			int y = Integer.parseInt(s.nextToken()) - 1;

			PositionM p = new PositionM(x, y, 'N');


			boolean done = false;

			while(!done){

				s = new StringTokenizer(in.readLine());

				while(s.hasMoreTokens()){
					String instructions = s.nextToken();

					for (int i = 0; i < instructions.length(); i++) {
						if(instructions.charAt(i) == 'Q'){
							done = true;
							break;
						}
						instruction(p, instructions.charAt(i));
					}
				}
			}

			if(t > 0)
				out.println((p.x + 1) + " " + (p.y + 1) + " " + p.ori + "\n");
			else
				out.println((p.x + 1) + " " + (p.y + 1) + " " + p.ori);
		}

		out.flush();
		out.close();
	}

	public static void instruction(PositionM p, char i){
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
		else if(i == 'F'){
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
		}
	}

	public static boolean valid(int x, int y){
		return (x >= 0 && x < world.length && y >=0 && y < world[0].length && world[x][y] == ' ');
	}
}
