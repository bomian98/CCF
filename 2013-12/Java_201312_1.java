import java.util.Scanner;

public class Java_201312_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] n = new int[10001];
		for (int i = 0; i < num; i++) {
			n[scanner.nextInt()]++;
		}
		scanner.close();
		int count = 0;
		int index = 0;
		for (int i = 1; i < 10001; i++) {
			if (n[i] > count) {
				count = n[i];
				index = i;
			}
		}
		System.out.println(index);
	}
}
