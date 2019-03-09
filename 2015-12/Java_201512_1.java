import java.util.Scanner;

public class Java_201512_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long num = scanner.nextLong();
		int count = 0;
		while (num > 0) {
			count = count+(int) (num % 10);
			num = num / 10;
		}
		scanner.close();
		System.out.println(count);
	}
}
