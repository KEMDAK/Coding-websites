import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class MaximumSum_108 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		int[][] input = new int[N][N];
		int[][] comulativeSum = new int[N][N];

		int i;
		int j;
		StringTokenizer s = new StringTokenizer(in.readLine());

		for (i = 0; i < input.length; i++) {
			for (j = 0; j < input[i].length; j++) {
				if(!s.hasMoreTokens())
					s = new StringTokenizer(in.readLine());
				input[i][j] = Integer.parseInt(s.nextToken());

				if(j == 0)
					comulativeSum[i][j] = input[i][j];
				else
					comulativeSum[i][j] = input[i][j] + comulativeSum[i][j - 1];
			}
		}

		int max = input[0][0];

		for (int js = 0; js < input.length; js++) {
			for (int je = js; je < input[js].length; je++) {
				int[] kadArr = new int[N];

				for (int k = 0; k < kadArr.length; k++) {
					if(js != 0){
						kadArr[k] = comulativeSum[k][je] - comulativeSum[k][js - 1];
					}
					else{
						kadArr[k] = comulativeSum[k][je];
					}
				}

				int maxK = 0;
				int sumK = 0;
				for (int k = 0; k < kadArr.length; k++) {
					sumK += kadArr[k];

					if(sumK < 0)
						sumK = 0;

					if(sumK > maxK)
						maxK = sumK;
				}

				if(maxK > max)
					max = maxK;
			}
		}

		System.out.println(max);
	}


}
