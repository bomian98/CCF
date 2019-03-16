import java.util.Scanner;

public class Java_201403_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] num = new int[1001];
		for (int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			a = Math.abs(a);
			num[a]++;
		}
		scanner.close();
		int count = 0;
		for (int i = 0; i < 1001; i++) {
			if (num[i] == 2)
				count++;
		}
		System.out.println(count);
	}
}
