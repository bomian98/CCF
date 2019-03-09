import java.util.Scanner;

public class Java_201509_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int count = 1;
		int pre = scanner.nextInt();
		int now;
		for (int i = 1; i < n; i++) {
			now = scanner.nextInt();
			if (now != pre)
				count++;
			pre = now;
		}
		scanner.close();
		System.out.println(count);
	}
}
