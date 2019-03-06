import java.util.Arrays;
import java.util.Scanner;

public class Java_201612_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int[] num = new int[a];
		for (int i = 0; i < a; i++)
			num[i] = scanner.nextInt();
		scanner.close();
		Arrays.sort(num);
		int mid = 0;
		if (a % 2 != 0) {
			mid = num[a / 2];
		} else {
			if (num[a / 2 - 1] == num[a / 2])
				mid = num[a / 2];
			else {
				System.out.println(-1);
				return;
			}
		}
		int min = 0, max = 0;
		for (int i = 0; i < a; i++) {
			if (num[i] > mid)
				min++;
			else if (num[i] < mid)
				max++;
		}
		if (max == min)
			System.out.println(mid);
		else
			System.out.println(-1);
	}
}
