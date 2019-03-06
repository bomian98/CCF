import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Java_201709_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt(), operas = scanner.nextInt();
		int[][] keys = new int[operas * 2][3];
		int[] posi = new int[num + 1];
		// 生成操作序列
		for (int i = 0; i < operas; i++) {
			int key = scanner.nextInt();
			int time1 = scanner.nextInt();
			int time2 = scanner.nextInt() + time1;
			keys[i * 2] = new int[] { time1, 1, key };
			keys[i * 2 + 1] = new int[] { time2, 0, key };
		}
		scanner.close();
		// 按照{时间、取放、钥匙编号}排序
		Arrays.sort(keys, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				for (int i = 0; i < 3; i++) {
					if (o1[i] != o2[i])
						return o1[i] - o2[i];
				}
				return 0;
			}
		});
		for (int i = 1; i <= num; i++) {
			posi[i] = i;
		}
		for (int i = 0; i < operas * 2; i++) {
			int key = keys[i][2];
			if (keys[i][1] == 1) {
				for (int j = 1; j <= num; j++) {
					if (posi[j] == key) {
						posi[j] = 0;
						break;
					}
				}
			} else {
				for (int j = 1; j <= num; j++) {
					if (posi[j] == 0) {
						posi[j] = key;
						break;
					}
				}
			}
		}
		for (int i = 1; i <= num; i++) {
			System.out.print(posi[i] + " ");
		}
	}
}
