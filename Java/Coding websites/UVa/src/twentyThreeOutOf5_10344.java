import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class twentyThreeOutOf5_10344 {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line;

		while (!(line = in.readLine()).equals("0 0 0 0 0")) {
			String[] operandsT = line.split(" ");
			char[] operatorsT = { '+', '-', '*' };
			int[] operands = new int[5];
			char[] operators = new char[5];

			for (int i = 0; i < 82; i++) {
				boolean possible = false;
				for (int k = 0; k < 31248; k++) {
					String combO = Integer.toString(i, 3);
					while (combO.length() < 4)
						combO = '0' + combO;
					for (int j = 0; j < combO.length(); j++) {
						operators[j] = operatorsT[combO.charAt(j) - '0'];
					}
					String combN = Integer.toString(k, 5);
					while (combN.length() < 5)
						combN = '0' + combN;
					for (int j = 0; j < combN.length(); j++) {
						operands[j] = Integer.parseInt(operandsT[combN
								.charAt(j) - '0']);
						operands[j] = Integer.parseInt(operandsT[j]);
					}

					int result = 0;
					String exp = "(((" + operands[0] + operators[0]
							+ operands[1] + ")" + operators[1] + operands[2]
							+ ")" + operators[2] + operands[3] + ")"
							+ operators[3] + operands[4];

					result = evaluate(operands[0], operators[0], operands[1]);
					result = evaluate(result, operators[1], operands[2]);
					result = evaluate(result, operators[2], operands[3]);
					result = evaluate(result, operators[3], operands[4]);

					System.out.println(exp);

					if (result == 23) {
						possible = true;
						break;
					}
				}
				if (possible) {
					System.out.println("Possible");
					break;
				} else if (i == 81)
					System.out.println("Impossible");

			}
		}
	}

	public static int evaluate(int a, char o, int b) {
		switch (o) {
		case '+':
			return a + b;

		case '*':
			return a * b;

		case '-':
			return a - b;
		}

		return 0;
	}
}
