import java.util.Scanner;

public class Java_201412_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[][] square = new int[num][num];
		int[] output = new int[num*num];
		for (int i = 0; i < num; i++)
			for (int j = 0; j < num; j++)
				square[i][j] = scanner.nextInt();
		
		int index = 0;
		for (int i = 0; i < num * 2 - 1; i++) {
			int start = Math.max(0, i - num + 1);
			int end = Math.min(i, num - 1);
			for(int col = start; col <= end; col++) {
				int row = i - col;
				output[index] = square[row][col];
				index++;
			}
			i++;
			start = Math.max(0, i - num + 1);
			end = Math.min(i, num - 1);
			for(int col = end; col >= start; col--) {
				int row = i - col;
				output[index] = square[row][col];
				index++;
			}
		}
		scanner.close();
		for(int i = 0; i < num*num; i++) {
			System.out.print(output[i]+" ");
		}
	}
}
