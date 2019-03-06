import java.util.Scanner;

public class Java_201709_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		scanner.close();
		a = a / 10;
		int b = a / 5;
		int out = 7 * b;
		a = a - 5 * b;
		b = a / 3;
		out = out + 4 * b;
		a = a - 3 * b;
		out = out + a;
		System.out.println(out);
	}
}
