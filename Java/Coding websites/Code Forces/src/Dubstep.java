import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Dubstep {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String s = in.readLine();

		String[] res = s.split("WUB");


		for (int i = 0; i < res.length - 1; i++) {
			if(!res[i].isEmpty())
				System.out.print(res[i] + " ");
		}
		if(!res[res.length - 1].isEmpty())
			System.out.print(res[res.length - 1]);

	}
}
