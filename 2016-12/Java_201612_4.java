import java.util.Scanner;

public class Java_201612_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] is = new int[num + 1];
		int[] sum = new int[num + 1];
		int[][] dp = new int[num + 1][num + 1];
		for (int i = 1; i <= num; i++) {
			is[i] = scanner.nextInt();
		}
		scanner.close();

		for (int i = 1; i <= num; i++) {
			sum[i] = sum[i - 1] + is[i];
		}

		// // 第一种方法
		// // 未优化dp解决
		// for (int len = 1; len <= num; len++) {
		// for (int start = 1; start + len <= num; start++) {
		// int min = Integer.MAX_VALUE;
		// for (int k = start; k <= start + len - 1; k++) {
		// min = Math.min(min, dp[start][k] + dp[k + 1][start + len]);
		// }
		// dp[start][start + len] = min + sum[start + len] - sum[start - 1];
		// }
		// }

		// 第二种方法
		// 优化dp解决
		int[][] p = new int[num + 1][num + 1];
		for (int i = 1; i <= num; i++) {
			p[i][i] = i;
		}
		for (int len = 1; len <= num; len++) {
			for (int start = 1; start + len <= num; start++) {
				int end = start + len;
				int min = Integer.MAX_VALUE;
				for (int k = p[start][end - 1]; k <= p[start + 1][end] && k <= num - 1; k++) {
					int val = dp[start][k] + dp[k + 1][end];
					if (val < min) {
						min = val;
						p[start][end] = k;
					}
				}
				dp[start][end] = min + sum[end] - sum[start - 1];
			}
		}
		System.out.println(dp[1][num]);
	}
}
