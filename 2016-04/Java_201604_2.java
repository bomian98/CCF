import java.util.Arrays;
import java.util.Scanner;

public class Java_201604_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] square = new int[15][10];
		int[][] down = new int[4][4];
		int posi;
		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 10; j++)
				square[i][j] = scanner.nextInt();
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				down[i][j] = scanner.nextInt();
		posi = scanner.nextInt();
		scanner.close();

		// 获得方格图在[posi, posi+3]区间内方格的最高点
		// 获得板块在[0, 3]区间内方格的最低点
		int[] high = new int[4];
		int[] low = new int[4];
		Arrays.fill(high, 15);
		Arrays.fill(low, -15);
		for (int i = 0; i < 4; i++) {
			for (int j = 4; j < 15 && posi + i - 1 < 15; j++) {
				if (square[j][posi + i - 1] == 1) {
					high[i] = j;
					break;
				}
			}
			for (int j = 3; j >= 0; j--) {
				if (down[j][i] == 1) {
					low[i] = j;
					break;
				}
			}
		}

		
		// 判断最低点
		int[] a = new int[4];
		a[0] = high[0] - low[0];
		a[1] = high[1] - low[1];
		a[2] = high[2] - low[2];
		a[3] = high[3] - low[3];
		Arrays.sort(a);
		int max = a[0]-1;// 获取模块的上
		for (int i = 0; i < 4 && i + max < 15; i++) {
			for (int j = 0; j < 4 && j + posi-1 < 10; j++) {
				square[i + max][posi+j-1] = square[i+max][posi+j-1] + down[i][j];
			}
		}

		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(square[i][j] +" ");
			}
			System.out.println(" ");
		}
	}
}
