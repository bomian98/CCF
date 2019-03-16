import java.util.Scanner;

public class Java_201312_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] m = new int[num];
		int[][] low = new int[num][num];
		for (int i = 0; i < num; i++) {
			m[i] = scanner.nextInt();
		}
		scanner.close();

		for (int i = 0; i < num; i++) {
			low[i][i] = m[i];
		}
		for (int i = 1; i < num; i++) {
			for (int j = 0; i + j < num; j++) {
				low[j][i + j] = Math.min(low[j][i + j - 1], low[i + j][i + j]);
			}
		}
		int max = 0;
		for (int i = 0; i < num; i++) {
			for (int j = i; j < num; j++) {
				max = Math.max((j - i + 1) * low[i][j], max);
			}
		}
		System.out.println(max);
	}
}
