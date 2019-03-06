import java.util.Scanner;

public class Java_201809_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] array1 = new int[1000001];
		for (int i = 0; i < num; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			for (int j = a; j < b; j++) {
				array1[j] = 1;
			}
		}
		int out = 0;
		for (int i = 0; i < num; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			for (int j = a; j < b; j++) {
				if(array1[j]==1) {
					out++;
				}
			}
		}
		scanner.close();
		System.out.println(out);
	}
}
