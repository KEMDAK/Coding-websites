import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pillars {

	// static String path="";
	static int d, n;
	static int[] ways;
	static boolean[][] dp;

	public static String path(int[] ways, boolean[][] dp) {
		String path = "";
		System.out.println(print(dp));
		System.out.println(Arrays.toString(ways));
		int steps = 0;
		for (int i = ways.length - 1; i > -1; i--) {
			int max = ways[i];
			int maxI = i;
			do {
				if (maxI != i && dp[i][maxI] == false) {
					path = " " + (maxI + 1) + path;
					steps++;
					maxI--;

					max = ways[maxI];
				}
				while (ways[maxI] == max) {
					if (dp[i][maxI] == true) {
						path = " " + (maxI + 1) + path;
						steps++;
					}
					maxI--;
					if (maxI == -1)
						break;
					max = ways[maxI];
				}
				for (int j = maxI - 1; j > -1; j--) {
					if (ways[j] >= max) {
						max = ways[j];
						maxI = j;
					}
				}
			} while (maxI != i && maxI != -1 && dp[i][maxI] == false);
			path = " " + (maxI + 1) + path;
			steps++;
			i = maxI;
		}
		return steps + "\n" + path.substring(1);

		// if(dp[i]==-1){
		// for(int j=i+1;j<x.length;j++){
		// if(Math.abs(Integer.parseInt(x[i])-Integer.parseInt(x[j]))>=d)
		// path(x, j, steps+1, way+" "+(j+1));
		// }
		// }
		// else
		// steps=dp[i];
		// dp[i]=steps;
		// if(maxS<steps){
		// path="";
		// path+=steps+"\n"+way;
		// maxS=steps;
		// }
	}

	public static String print(boolean[][] x) {
		String f = "";
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				f += x[i][j] + " ";
				if (x[i][j] == true)
					f += " ";
			}
			if (i < x.length - 1)
				f += "\n";
		}
		return f;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		n = Integer.parseInt(s.nextToken());
		d = Integer.parseInt(s.nextToken());
		String[] p = in.readLine().split(" ");
		ways = new int[n];
		dp = new boolean[n][n];
		for (int i = 0; i < dp.length; i++) {
			int c = 0;
			for (int j = 0; j < i; j++) {
				if ((Math.abs(Integer.parseInt(p[i]) - Integer.parseInt(p[j]))) >= d) {
					dp[i][j] = true;
					c++;
				}
				ways[i] = c;
			}
		}
		// Arrays.sort(ways);
		// path(p, 0, 1, "1");
		System.out.println(path(ways, dp));
	}
}