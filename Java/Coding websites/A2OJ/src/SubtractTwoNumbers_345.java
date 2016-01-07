import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SubtractTwoNumbers_345 {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = in.readLine().split(",");

		System.out.println(Integer.parseInt(arr[0]) - Integer.parseInt(arr[1]));
	}
}
