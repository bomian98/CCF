import java.util.Scanner;

public class Java_201312_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		scanner.close();
		int total = 0, count = 1;
		for (int i = 0; i <= 10; i++) {
			if (string.charAt(i) == '-')
				i++;
			total = total + count * (string.charAt(i) - '0');
			count++;
		}
		total = total % 11;
		int last = string.charAt(string.length() - 1) - '0';
		if (total < 10) {
			if (last == total) {
				System.out.println("Right");
			} else {
				String string2 = string.substring(0, string.length() - 1) + total;
				System.out.println(string2);
			}
		} else {
			if (last == 'X' - '0') {
				System.out.println("Right");
			} else {
				String string2 = string.substring(0, string.length() - 1) + "X";
				System.out.println(string2);
			}
		}
	}
}
