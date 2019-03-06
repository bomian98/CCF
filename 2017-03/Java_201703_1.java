import java.util.Scanner;

public class Java_201703_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] weights = new int[n];
		for (int i = 0; i < n; i++) {
			weights[i] = scanner.nextInt();
		}
		scanner.close();

		int num = 0;// 小孩个数
		int last = 0;// 上一个的个数
		int index = 0;// 蛋糕索引
		while (index < n) {
			last = last + weights[index];
			if (last >= k) {
				num++;
				last = 0;
			}
			index++;
		}
		if(last >0)
			num++;
		System.out.println(num);
	}
}
