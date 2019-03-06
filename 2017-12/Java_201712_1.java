import java.util.Arrays;
import java.util.Scanner;

public class Java_201712_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = scanner.nextInt();
		}
		Arrays.sort(num);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) {
			min = min < (num[i + 1] - num[i]) ? min : num[i + 1] - num[i];
		}
		scanner.close();
		System.out.println(min);
	}
}
