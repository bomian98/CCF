import java.util.Scanner;

public class Java_201509_2 {
	static int[][] day = new int[][] { { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
			{ 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int year = scanner.nextInt();
		int days = scanner.nextInt();
		scanner.close();
		int special = beSpecial(year);
		int month = 1;
		while(days>day[special][month]) {
			days = days-day[special][month];
			month++;
		}
		System.out.println(month);
		System.err.println(days);
	}

	static int beSpecial(int year) {
		if (year % 4 == 0 && year % 100 != 0) {
			return 1;
		} else if (year % 400 == 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
