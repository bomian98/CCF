import java.util.Scanner;

public class Java_201812_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int red = scanner.nextInt();
		scanner.nextInt();
		scanner.nextInt();
		int num = scanner.nextInt();
		int count = 0;
		for (int i = 0; i < num; i++) {
			int light = scanner.nextInt(), time = scanner.nextInt();
			if (light <= 1)
				count = count + time;
			else if (light == 2) {
				count = count + time + red;
			}
		}
		scanner.close();
		System.out.println(count);
	}
}
