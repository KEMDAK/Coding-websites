import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GivenLengthandSumofDigits {

	public static void main (String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());


		if(!can(m, s)){
			System.out.println("-1 -1");
			return;
		}

		String minimum = "";
		String maximum = "";

		int sum = s;
		for(int i = 1; i <= m; i++){
			for(int j = 0; j < 10; j++){
				if((i > 1 || j > 0 || (m == 1 && j == 0)) && can(m - i, sum - j)){
					minimum += j;
					sum -= j;
					break;
				}
			}
		}

		sum = s;
		for(int i = 1; i <= m; i++){
			for(int j = 9; j > -1; j--){
				if((i > 1 || j > 0 || (m == 1 && j == 0)) && can(m - i, sum - j)){
					maximum += j;
					sum -= j;
					break;
				}
			}
		}

		if(maximum.length() != m || minimum.length() != m){
			System.out.println("-1 -1");
			return;
		}

		System.out.println(minimum +  " " + maximum);
	}

	public static boolean can (int m, int s){
		return s >= 0 && s <= m * 9;
	}
}

// altirnative solution :D (top down)

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.StringTokenizer;
//
//public class GivenLengthAndSumOfDigits {
//    static int m;
//    static Boolean dp[][][];
//    static Boolean dp2[][][];
//    static StringBuilder sb;
//    static StringBuilder sb2;
//
//    public static void main(String[] args) throws IOException {
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	PrintWriter out = new PrintWriter(System.out);
//
//	StringTokenizer st = new StringTokenizer(br.readLine());
//	m = Integer.parseInt(st.nextToken());
//	int s = Integer.parseInt(st.nextToken());
//	
//	if (m == 1 && s == 0) {
//	    System.out.println("0 0");
//	    return;
//	}
//	
//	dp = new Boolean[m+1][s+5][m+5];
//	sb = new StringBuilder();
//	boolean ans = rec(0, s, 0);
//	
//	dp = new Boolean[m+1][s+5][m+5];
//	sb2 = new StringBuilder();
//	boolean ans2 = rec2(0, s, 0);
//	
//	if (ans && ans2) {
//	    sb2.reverse();
//	    sb.reverse();
//	    out.println(sb2 + " " + sb);
//	}
//	else 
//	    out.println("-1 -1");
//
//	out.flush();
//	out.close();
//    }
//
//    public static boolean rec2(int index, int remSum, int noOfDigits) {
//	if (!can(m-noOfDigits, remSum))
//	    return false;
//	if (remSum == 0 && noOfDigits == m) 
//	    return true;
//	if (remSum < 0 || index == m || noOfDigits == m)
//	    return false;
//
//	if (dp[index][remSum][noOfDigits] != null)
//	    return dp[index][remSum][noOfDigits];
//
//	int downLimit = 0;
//	if (noOfDigits == 0)
//	    downLimit++;
//
//	boolean done = false;
//	for (int i = downLimit; i <= 9; i++) {
//	    boolean take = rec2(index, remSum-i, noOfDigits+1);
//	    if (take) {
//		done = true;
//		sb2.append(i);
//		break;
//	    }
//	    boolean leave = rec2(index+1,remSum, noOfDigits);
//	    if (leave) {
//		done = true;
//		break;
//	    }
//	}
//
//	return dp[index][remSum][noOfDigits] = done;
//    }
//
//    public static boolean rec(int index, int remSum, int noOfDigits) {
//	if (!can(m-noOfDigits, remSum))
//	    return false;
//	if (remSum == 0 && noOfDigits == m) 
//	    return true;
//	if (remSum < 0 || index == m || noOfDigits == m)
//	    return false;
//	
//	if (dp[index][remSum][noOfDigits] != null)
//	    return dp[index][remSum][noOfDigits];
//
//	int downLimit = 0;
//	if (noOfDigits == 0)
//	    downLimit++;
//
//	boolean done = false;
//	for (int i = 9; i >= downLimit; i--) {
//	    boolean take = rec(index, remSum-i, noOfDigits+1);
//	    if (take) {
//		done = true;
//		sb.append(i);
//		break;
//	    }
//	    boolean leave = rec(index+1,remSum, noOfDigits);
//	    if (leave) {
//		done = true;
//		break;
//	    }
//	}
//
//	return dp[index][remSum][noOfDigits] = done;
//    }
//    
//    public static boolean can(int m, int s)
//    {
//        return s >= 0 && s <= 9 * m;
//    }
//}
