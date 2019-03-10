import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Java_201503_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[][] n = new int[1001][2];
		for (int i = 0; i < num; i++) {
			int a = scanner.nextInt();
			n[a][0]++;
			n[a][1] = a;
		}
		scanner.close();
		Arrays.sort(n, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0])
					return o2[0] - o1[0];
				else
					return o1[1] - o1[1];
			}
		});
		for (int i = 0; i < 1001 && n[i][0] != 0; i++) {
			System.out.println(n[i][1]+" "+n[i][0]);
		}
	}
}
