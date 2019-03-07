import java.util.Scanner;

public class Java_201609_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int max = 0;
		int pre = scanner.nextInt();
		int now;
		for (int i = 1; i < num; i++) {
			now = scanner.nextInt();
			max = Math.max(Math.abs(now - pre), max);
			pre = now;
		}
		scanner.close();
		System.out.println(max);
	}
}
