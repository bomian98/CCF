import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Java_201412_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] output = new int[num];
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < num; i++) {
			int a = scanner.nextInt();
			int times = map.getOrDefault(a, 0);
			times++;
			map.put(a, times);
			output[i] = times;
		}
		scanner.close();
		for(int i = 0; i < num; i++) {
			System.out.print(output[i]+" ");
		}
	}
}
