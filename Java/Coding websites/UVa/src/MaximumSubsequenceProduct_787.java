import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class MaximumSubsequenceProduct_787 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();

		while(in .ready()){// in .ready()
			ArrayList<Integer> input = new ArrayList<Integer>();
			ArrayList<BigInteger> comulativeProduct = new ArrayList<BigInteger>();

			StringTokenizer s = new StringTokenizer(in.readLine());
			BigInteger acc = new BigInteger("1");

			while (s.hasMoreTokens()) {
				int num = Integer.parseInt(s.nextToken());

				if(num == -999999){
					break;
				}else{
					acc = acc.multiply(new BigInteger("" + num));
					input.add(num);
					comulativeProduct.add(acc);
					if(acc.equals(BigInteger.ZERO))
						acc = BigInteger.ONE;
				}

				if(!s.hasMoreTokens())
					s = new StringTokenizer(in.readLine());
			}

			BigInteger max = comulativeProduct.get(0);
			
			for (int i = 0; i < comulativeProduct.size(); i++) {
				if(comulativeProduct.get(i).equals(BigInteger.ZERO)){
					if (BigInteger.ZERO.compareTo(max) > 0)
						max = BigInteger.ZERO;
					continue;
				}
				for (int j = i; j < comulativeProduct.size(); j++) {
					if(comulativeProduct.get(j).equals(BigInteger.ZERO)) break;
					BigInteger val = comulativeProduct.get(j);
					if(i!=0){
						if(!comulativeProduct.get(i - 1).equals(BigInteger.ZERO))
							val = val.divide(comulativeProduct.get(i - 1));
					}
					if (val.compareTo(max) > 0)
						max = val;
				}
			}
			
			out.append(max + "\n");
		}
		
		System.out.print(out);
	}
}
