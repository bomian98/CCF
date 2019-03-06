import java.util.Scanner;

public class Java_201703_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int k = scanner.nextInt();
		int[] pos = new int[num + 1]; // pos[i]代表队列第i位置人的学号
		int[] at = new int[num + 1]; // at[i]代表学号为i人的位置
		for (int i = 1; i <= num; i++) {
			pos[i] = i;
			at[i] = i;
		}
		for (int i = 0; i < k; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int index = at[a];
			if (b > 0) {
				for (int m = 1; m <= b; m++) {
					int next_num = pos[index + 1];
					pos[index] = next_num;
					at[next_num] = index;
					index++;
				}
				pos[index] = a;
				at[a] = index;
			} else {
				b = -b;
				for (int m = 1; m <= b; m++) {
					int next_num = pos[index - 1];
					pos[index] = next_num;
					at[next_num] = index;
					index--;
				}
				pos[index] = a;
				at[a] = index;
			}
		}
		scanner.close();
		for (int i = 1; i < num; i++) {
			System.out.print(pos[i] + " ");
		}
		System.out.print(pos[num]);
	}
}
