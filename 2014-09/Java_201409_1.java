import java.util.Arrays;
import java.util.Scanner;

public class Java_201409_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] n = new int[num];
		for (int i = 0; i < num; i++) {
			n[i] = scanner.nextInt();
		}
		scanner.close();
		Arrays.sort(n);
		int count = 0;
		for(int i = 0; i < num-1; i++) {
			if(n[i]+1==n[i+1])
				count++;
		}
		System.out.println(count);
	}
}
