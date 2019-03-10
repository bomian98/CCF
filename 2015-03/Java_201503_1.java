import java.util.Scanner;

public class Java_201503_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int row = scanner.nextInt(), col = scanner.nextInt();
		int[][] rotate = new int[col][row];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				rotate[col-j-1][i] = scanner.nextInt();
			}
		}
		scanner.close();
		for(int i = 0; i < col; i++) {
			for(int j = 0; j< row; j++) {
				System.out.print(rotate[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
