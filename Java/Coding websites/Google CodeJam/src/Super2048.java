import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Super2048 {

	public static int[][] move(int[][] current, String m) {
		m = m.toLowerCase();
		switch (m) {
		case "l":
			;
		case "left":
			;
		case "4": {
			for (int i = 0; i < current.length; i++) {
				int pin = 0;
				int valid = 1;
				for (int j = 0; j < current[i].length; j++) {
					if (current[i][j] > 0) {
						if (pin == 0) {
							if (j != pin) {
								current[i][pin] = current[i][j];
								current[i][j] = 0;
							}
							pin++;
							valid = 1;
						} else {
							if (current[i][pin - 1] == current[i][j]
									&& valid == 1) {
								current[i][pin - 1] *= 2;
								current[i][j] = 0;
								valid = 0;
							} else {
								if (j != pin) {
									current[i][pin] = current[i][j];
									current[i][j] = 0;
								}
								pin++;
								valid = 1;
							}
						}
					}
				}
			}
		}
			;
			break;

		case "r":
			;
		case "right":
			;
		case "6": {
			for (int i = current.length - 1; i >= 0; i--) {
				int pin = current.length - 1;
				int valid = 1;
				for (int j = current[i].length - 1; j >= 0; j--) {
					if (current[i][j] > 0) {
						if (pin == current[i].length - 1) {
							if (j != pin) {
								current[i][pin] = current[i][j];
								current[i][j] = 0;
							}
							pin--;
							valid = 1;
						} else {
							if (current[i][pin + 1] == current[i][j]
									&& valid == 1) {
								current[i][pin + 1] *= 2;
								current[i][j] = 0;
								valid = 0;
							} else {
								if (j != pin) {
									current[i][pin] = current[i][j];
									current[i][j] = 0;
								}
								pin--;
								valid = 1;
							}
						}
					}
				}
			}
		}
			;
			break;

		case "u":
			;
		case "up":
			;
		case "8": {
			for (int j = 0; j < current.length; j++) {
				int pin = 0;
				int valid = 1;
				for (int i = 0; i < current[j].length; i++) {
					if (current[i][j] > 0) {
						if (pin == 0) {
							if (i != pin) {
								current[pin][j] = current[i][j];
								current[i][j] = 0;
							}
							pin++;
							valid = 1;
						} else {
							if (current[pin - 1][j] == current[i][j]
									&& valid == 1) {
								current[pin - 1][j] *= 2;
								current[i][j] = 0;
								valid = 0;
							} else {
								if (i != pin) {
									current[pin][j] = current[i][j];
									current[i][j] = 0;
								}
								pin++;
								valid = 1;
							}
						}
					}
				}
			}
		}
			;
			break;

		case "d":
			;
		case "down":
			;
		case "2": {
			for (int j = current.length - 1; j >= 0; j--) {
				int pin = current.length - 1;
				int valid = 1;
				for (int i = current[j].length - 1; i >= 0; i--) {
					if (current[i][j] > 0) {
						if (pin == current[j].length - 1) {
							if (i != pin) {
								current[pin][j] = current[i][j];
								current[i][j] = 0;
							}
							pin--;
							valid = 1;
						} else {
							if (current[pin + 1][j] == current[i][j]
									&& valid == 1) {
								current[pin + 1][j] *= 2;
								;
								current[i][j] = 0;
								valid = 0;
							} else {
								if (i != pin) {
									current[pin][j] = current[i][j];
									current[i][j] = 0;
								}
								pin--;
								valid = 1;
							}
						}
					}
				}
			}
		}
			;
			break;

		}

		return current;
	}

	public static String print(int[][] x) {
		String f = "";
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				f += x[i][j] + " ";
				// int k=4;
				// if(x[i][j]>999)
				// k=1;
				// else if (x[i][j]>99)
				// k=2;
				// else if(x[i][j]>9)
				// k=3;
				// while(k>0){
				// f+=" ";
				// k--;
				// }
			}
			if (i < x.length - 1)
				f += "\n";
		}
		return f;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		int t = Integer.parseInt(s.nextToken());
		String f = "";
		for (int i = 1; i <= t; i++) {
			s = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(s.nextToken());
			String m = s.nextToken();
			int[][] current = new int[n][n];
			for (int j = 0; j < n; j++) {
				s = new StringTokenizer(in.readLine());
				for (int k = 0; k < n; k++) {
					current[j][k] = Integer.parseInt(s.nextToken());
				}
			}
			f += "Case #" + i + ": \n" + print(move(current, m)) + "\n";
		}
		System.out.println(f);
	}
}
