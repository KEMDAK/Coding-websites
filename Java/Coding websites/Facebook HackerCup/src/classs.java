
public class classs {
	public static void main(String[] args) {
		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j < i - 1; j++) {
				System.out.println(" ");
			}
			for (int j = i; j > 0; j--) {
				System.out.println("#");
			}
			for (int j = 20 - i - 1 - i; j > 0; j++) {
				System.out.println(" ");
			}
			for (int j = i; j > 0; j--) {
				System.out.println("#");
			}
			for (int j = 0; j < i - 1; j++) {
				System.out.println("#");
			}
		}
	}
}
