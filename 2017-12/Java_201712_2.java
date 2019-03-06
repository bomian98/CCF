import java.util.Scanner;

public class Java_201712_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		boolean[] arrays = new boolean[n];// 是否已经淘汰
		int left = n;// 剩余人数
		int count = 0;// 计数
		int index = 0;// 当前人位置
		while (left > 1) {
			if (!arrays[index]) {
				count++;
				if (count % 10 == k || count % k == 0) {
					arrays[index] = true;
					left--;
				}
			}
			index++;
			if (index == n)
				index = 0;
		}
		scanner.close();
		for (int i = 0; i < n; i++)
			if (!arrays[i])
				System.out.println(i + 1);
	}
}
