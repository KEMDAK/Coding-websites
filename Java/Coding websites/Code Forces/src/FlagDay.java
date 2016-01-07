import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FlagDay {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer s = new StringTokenizer(in.readLine());

		int n = Integer.parseInt(s.nextToken());
		int m = Integer.parseInt(s.nextToken());

		int[] colors = new int[n];

		for (int i = 0; i < m; i++) {
			boolean white, red, blue;
			white = red = blue = true;

			s = new StringTokenizer(in.readLine());

			int d1 = Integer.parseInt(s.nextToken()) - 1;
			int d2 = Integer.parseInt(s.nextToken()) - 1;
			int d3 = Integer.parseInt(s.nextToken()) - 1;

			if(colors[d1] != 0){
				if(colors[d1] == 1)
					white = false;
				else if(colors[d1] == 2)
					red = false;
				else if(colors[d1] == 3)
					blue = false;
			}
			
			if(colors[d2] != 0){
				if(colors[d2] == 1)
					white = false;
				else if(colors[d2] == 2)
					red = false;
				else if(colors[d2] == 3)
					blue = false;
			}
			
			if(colors[d3] != 0){
				if(colors[d3] == 1)
					white = false;
				else if(colors[d3] == 2)
					red = false;
				else if(colors[d3] == 3)
					blue = false;
			}
			
			if(colors[d1] == 0){
				if(white){
					white = false;
					colors[d1] = 1;
				}
				else if(red){
					red = false;
					colors[d1] = 2;
				}
				else if(blue){
					blue = false;
					colors[d1] = 3;
				}
			}
			
			if(colors[d2] == 0){
				if(white){
					white = false;
					colors[d2] = 1;
				}
				else if(red){
					red = false;
					colors[d2] = 2;
				}
				else if(blue){
					blue = false;
					colors[d2] = 3;
				}
			}
			
			if(colors[d3] == 0){
				if(white){
					white = false;
					colors[d3] = 1;
				}
				else if(red){
					red = false;
					colors[d3] = 2;
				}
				else if(blue){
					blue = false;
					colors[d3] = 3;
				}
			}
		}
		
		for (int i = 0; i < colors.length; i++) {
			out.print(colors[i] + " ");
		}
		
		out.flush();
		out.close();
	}
}
