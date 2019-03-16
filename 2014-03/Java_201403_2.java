import java.util.Scanner;

public class Java_201403_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(), M = scanner.nextInt();
		int[][] squares = new int[2560][1440];
		int[][] windows = new int[N][4];
		for(int i = 0; i < N; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			int d = scanner.nextInt();
			for(int row = a ; row <= c; row++) {
				for(int col = b; col <= d; col++) {
					squares[row][col] = i+1;
				}
			}
			windows[i][0] = a;
			windows[i][1] = b;
			windows[i][2] = c;
			windows[i][3] = d;
		}
		for(int i = 0; i < M; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int window = squares[a][b];
			if(window == 0) {
				System.out.println("IGNORED");
			}else {
				int start_x = windows[window-1][0], start_y = windows[window-1][1];
				int end_x = windows[window-1][2], end_y = windows[window-1][3];
				for(int row = start_x; row <= end_x; row++) {
					for(int col = start_y; col <= end_y; col++) {
						squares[row][col] = window;
					}
				}
				System.out.println(window);
			}
		}
		scanner.close();
		
	}
}
