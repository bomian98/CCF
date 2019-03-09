import java.util.Scanner;

public class Java_201512_2 {
	static int row, col;
	static int[][] colors;
	static int[][] output;
	// static int[][] direct = new int[][] {{1,0},{0,1},{-1,0},{}};

	public static void main(String[] args) {
		read();
		delete();
		print();
	}

	private static void print() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(output[i][j]+" ");
			}
			System.out.println("");
		}

	}

	private static void delete() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int color = colors[i][j];
				int count0 = 1, count1 = 1;
				while (i + count0 < row && colors[i + count0][j] == color)
					count0++;
				while (j + count1 < col && colors[i][j + count1] == color)
					count1++;
				if (count0 >= 3) {
					for (int k = i; k < i + count0; k++) {
						output[k][j] = 0;
					}
				}
				if (count1 >= 3) {
					for (int k = j; k < j + count1; k++) {
						output[i][k] = 0;
					}
				}
			}
		}
	}

	private static void read() {
		Scanner scanner = new Scanner(System.in);
		row = scanner.nextInt();
		col = scanner.nextInt();
		colors = new int[row][col];
		output = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				colors[i][j] = scanner.nextInt();
				output[i][j] = colors[i][j];
			}
		}
		scanner.close();
	}
}
