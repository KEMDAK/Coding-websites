import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitPlusPlus {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int x = 0;
		for (int i = 0; i < n; i++) {
			String o = in.readLine();
			if (o.equalsIgnoreCase("x++") || o.equalsIgnoreCase("++x"))
				x++;
			if (o.equalsIgnoreCase("x--") || o.equalsIgnoreCase("--x"))
				x--;
		}
		System.out.println(x);
	}
}
