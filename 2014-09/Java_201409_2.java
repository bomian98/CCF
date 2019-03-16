import java.util.Scanner;

public class Java_201409_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		boolean[][] paint = new boolean[101][101];
		for (int i = 0; i < num; i++) {
			int row1 = scanner.nextInt(), col1 = scanner.nextInt();
			int row2 = scanner.nextInt(), col2 = scanner.nextInt();
			for (int row = row1; row < row2; row++) {
				for (int col = col1; col < col2; col++) {
					paint[row][col] = true;
				}
			}
		}
		scanner.close();
		int count = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (paint[i][j])
					count++;
			}
		}
		System.out.println(count);
	}
}
