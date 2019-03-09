import java.util.Scanner;

public class Java_201604_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] a = new int[num];
		for (int i = 0; i < num; i++) {
			a[i] = scanner.nextInt();
		}
		scanner.close();
		if (num < 3) {
			System.out.println(0);
			return;
		}
		int count = 0;
		int pre = a[1] - a[0];
		int now;
		for (int i = 2; i < num; i++) {
			now = a[i] - a[i - 1];
			if (now * pre < 0)
				count++;
			pre = now;
		}
		System.out.println(count);
	}

}
