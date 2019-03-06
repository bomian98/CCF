import java.util.Scanner;

public class Java_201803_1 {
	public static void main(String[] args) {
		int num = 0;
		int last = 0;
		int last_num = 1;
		int score = 0;
		Scanner scanner = new Scanner(System.in);
		while ((num = scanner.nextInt()) != 0) {
			if (num == 2) {
				last = last_num == 1 ? 2 : last + 2;
			} else {
				last = 1;
			}
			last_num = num;
			score = score + last;
		}
		scanner.close();
		System.out.println(score);
	}
}
