import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NewYearAndDomino {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer s = new StringTokenizer(in.readLine());

		int h = Integer.parseInt(s.nextToken());
		int w = Integer.parseInt(s.nextToken());

		char[][] input = new char[h][w];

		for (int i = 0; i < h; i++) {
			String st = in.readLine();

			for (int j = 0; j < w; j++) {
				input[i][j] = st.charAt(j);
			}
		}

		long[][] map = new long[h][w];

		if(input[0][0] == '#'){
			if(1 < h && input[1][0] != '#')
				map[1][0]--;
			if(1 < w && input[0][1] != '#')
				map[0][1]--;
		}

		for (int j = 1; j < w; j++) {
			if(input[0][j] == '#'){
				if(j + 1 < w && input[0][j + 1] != '#')
					map[0][j + 1]--;
				if(1 < h && input[1][j] != '#')
					map[1][j]--;

				map[0][j]--;
			}

			map[0][j] += map[0][j - 1] + 1;
		}

		for (int i = 1; i < h; i++){

			if(input[i][0] == '#'){
				if(1 < w && input[i][1] != '#')
					map[i][1]--;
				if(i + 1 < h && input[i + 1][0] != '#')
					map[i + 1][0]--;

				map[i][0]--;
			}

			map[i][0] += map[i - 1][0] + 1;

			for (int j = 1; j < w; j++) {
				if(input[i][j] == '#'){
					if(j + 1 < w && input[i][j + 1] != '#')
						map[i][j + 1]--;
					if(i + 1 < h && input[i + 1][j] != '#')
						map[i + 1][j]--;

					map[i][j] -= 2;
				}

				map[i][j] += map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1] + 2;
			}
		}

//		System.out.println();
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		int q = Integer.parseInt(in.readLine());

		for (int i = 0; i < q; i++) { // the problem is in the final calculation :(
			s = new StringTokenizer(in.readLine());

			int x1 = Integer.parseInt(s.nextToken()) - 1;
			int y1 = Integer.parseInt(s.nextToken()) - 1;
			int x2 = Integer.parseInt(s.nextToken()) - 1;
			int y2 = Integer.parseInt(s.nextToken()) - 1;

			long ans = map[x2][y2];

			if(x1 != 0){
				ans -= map[x1 - 1][y2];

				for (int j = y1; j <= y2; j++) {
					if(input[x1 - 1][j] == '.' && input[x1][j] == '.')
						ans--;
				}
			}

			if(y1 != 0){
				ans -= map[x2][y1 - 1];

				for (int j = x1; j <= x2; j++) {
					if(input[j][y1 - 1] == '.' && input[j][y1] == '.')
						ans--;
				}
			}

			if(x1 != 0 && y1 != 0)
				ans += map[x1 - 1][y1 - 1];

			out.println(ans);
		}

		out.flush();
		out.close();
	}
}