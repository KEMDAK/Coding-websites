import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Mapmaker_394 {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer s = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(s.nextToken());
		int R = Integer.parseInt(s.nextToken());

		int[] bases = new int[N];
		int[] CDs = new int[N];
		int[] dimensions = new int[N];
		Limit[][] limits = new Limit[N][];
		int[][] constants = new int[N][];
		TreeMap<String, Integer> nameCodes = new TreeMap<>();
//		String[] names = new String[N];
		
		for (int i = 0; i < N; i++) {
			s = new StringTokenizer(in.readLine());
			String name = s.nextToken();
			int B = Integer.parseInt(s.nextToken());
			int CD = Integer.parseInt(s.nextToken());
			int D = Integer.parseInt(s.nextToken());

			nameCodes.put(name, i);
//			names[i] = name;
			bases[i] = B;
			CDs[i] = CD;
			dimensions[i] = D;
			limits[i] = new Limit[D + 1];
			constants[i] = new int[D + 1];
			for (int j = 1; j <= D; j++) {
				int lower = Integer.parseInt(s.nextToken());
				int upper = Integer.parseInt(s.nextToken());
				
				limits[i][j] = new Limit(lower, upper);
			}
			
			constants[i][D] = CD;
			for (int j = D - 1; j > 0; j--) {
				constants[i][j] = constants[i][j + 1] * (limits[i][j + 1].upper - limits[i][j + 1].lower + 1);
			}
			
			constants[i][0] = -B;
			for (int j = 1; j < D + 1; j++) {
				constants[i][0] += (constants[i][j] * limits[i][j].lower);
			}
			constants[i][0] *= -1;
		}
		
//		for (int i = 0; i < constants.length; i++) {
//			System.out.println(Arrays.toString(constants[i]));
//		}
		
		for (int i = 0; i < R; i++) {
			s = new StringTokenizer(in.readLine());
			String name = s.nextToken();
			int arr = nameCodes.get(name);
			int[] cell = new int[dimensions[arr] + 1];
			for (int j = 1; j < cell.length; j++) {
				cell[j] = Integer.parseInt(s.nextToken());
			}
			
			long res = constants[arr][0];
			for (int j = 1; j < cell.length; j++) {
				res += (constants[arr][j] * cell[j]);
			}
			
			out.print(name + "[");
			for (int j = 1; j < cell.length - 1; j++) {
				out.print(cell[j] + ", ");
			}
			out.print(cell[cell.length - 1] + "] = " + res + "\n");
		}
		
		out.flush();
		out.close();
	}

	private static class Limit{
		int lower, upper;

		public Limit(int lower, int upper){
			this.lower = lower;
			this.upper = upper;
		}
	}
}
