import java.util.Scanner;

public class Java_201612_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.close();

		int n = t - 3500;
		int a1 = (int) (1500 * 0.97);
		int a2 = (int) (a1 + 3000 * 0.9);
		int a3 = (int) (a2 + 4500 * 0.8);
		int a4 = (int) (a3 + 26000 * 0.75);
		int a5 = (int) (a4 + 20000 * 0.7);
		int a6 = (int) (a5 + 25000 * 0.65);
		int s = 0;
		if (n < 0) {
			s = t;
		} else if (n <= a1 && n > 0) {
			s = (int) (3500 + n / 0.97);
		} else if (n > a1 && n <= a2) {
			s = (int) (5000 + (n - a1) / 0.9);
		} else if (n > a2 && n <= a3) {
			s = (int) (8000 + (n - a2) / 0.8);
		} else if (n > a3 && n <= a4) {
			s = (int) (12500 + (n - a3) / 0.75);
		} else if (n > a4 && n <= a5) {
			s = (int) (38500 + (n - a4) / 0.7);
		} else if (n > a5 && n <= a6) {
			s = (int) (58500 + (n - a5) / 0.65);
		} else if (n > a6) {
			s = (int) (83500 + (n - a6) / 0.55);
		}
		System.out.println(s);

	}
}
