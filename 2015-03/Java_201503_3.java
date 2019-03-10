import java.util.Scanner;

public class Java_201503_3 {
	static int[][] dayOfMonth = new int[][] { { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
			{ 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } };
	static int[] dayOfYear = new int[] { 365, 366 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt(), th = scanner.nextInt(), week = scanner.nextInt();
		int start = scanner.nextInt(), end = scanner.nextInt();
		scanner.close();

		String[] output = new String[end - start + 1];
		int days = 2;// 1850.01.01是周二
		if (week == 7)
			week = 0;
		// 计算 start.01.01 的星期
		for (int i = 1850; i < start; i++)
			days = days + dayOfYear[beRuiNian(i)];

		int yearOfDay, count, beRui;
		for (int i = start; i <= end; i++) {
			beRui = beRuiNian(i);
			yearOfDay = days;
			count = 0;

			for (int j = 1; j < month; j++)
				yearOfDay = yearOfDay + dayOfMonth[beRui][j];

			for (int j = 1; j <= dayOfMonth[beRui][month]; j++) {
				if (week == yearOfDay % 7) {
					count++;
					if (count == th) {
						String string = "" + i + "/";
						string = month >= 10 ? string + month + "/" : string + "0" + month + "/";
						string = j >= 10 ? string + j : string + "0" + j;
						output[i - start] = string;
						break;
					}
				}
				yearOfDay++;
			}
			days = days + dayOfYear[beRui];
		}

		for (int i = 0; i < end - start + 1; i++) {
			String string = output[i];
			if (string == null) {
				System.out.println("none");
			} else {
				System.out.println(string);
			}
		}
	}

	private static int beRuiNian(int year) {
		if (year % 4 == 0 && year % 100 != 0)
			return 1;
		else if (year % 400 == 0)
			return 1;
		return 0;
	}
}
