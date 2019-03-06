import java.util.Scanner;

//注意，7-10测试样例会超过int表示范围
public class Java_201812_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int red = scanner.nextInt(), yellow = scanner.nextInt(), green = scanner.nextInt();
		int num = scanner.nextInt();
		long count = 0;
		for (int i = 0; i < num; i++) {
			int light = scanner.nextInt();
			long time = scanner.nextInt();
			long left = 0;
			if (light != 0) {
				if (light == 1) {
					left = (red - time + count) % (yellow + green + red);
				} else if (light == 2) {
					left = (red + green + yellow - time + count) % (yellow + green + red);
				} else {
					left = (red + green - time + count) % (yellow + green + red);
				}
				if (left >= (red + green)) {
					time = yellow + green + red - left + red;
				} else if (left <= red) {
					time = red - left;
				} else {
					time = 0;
				}
			}
			count = count + time;
		}
		scanner.close();
		System.out.println(count);
	}
}
