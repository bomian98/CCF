import java.util.Scanner;

public class Java_201809_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] prices = new int[num];
		int[] out = new int[num];
		for (int i = 0; i < num; i++) {
			prices[i] = scanner.nextInt();
		}
		scanner.close();
		if (num == 2) {
			out[0] = (prices[0] + prices[1]) / 2;
			out[1] = (prices[0] + prices[1]) / 2;
		} else {
			out[0] = (prices[0] + prices[1]) / 2;
			out[num - 1] = (prices[num - 2] + prices[num - 1]) / 2;
			for (int i = 1; i < num - 1; i++) {
				out[i] = (prices[i - 1] + prices[i] + prices[i + 1]) / 3;
			}
		}
		for (int i = 0; i < num - 1; i++) {
			System.out.print(out[i] + " ");
		}
		System.out.print(out[num - 1]);
	}
}
