import java.util.Arrays;
import java.util.Scanner;

public class Java_201609_2 {
	static int[] ticket;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ticket = new int[20];
		Arrays.fill(ticket, 5);
		int num = scanner.nextInt();
		int[][] res = new int[num][5];
		for (int i = 0; i < num; i++) {
			int ticketnum = scanner.nextInt();
			int seat = findSeat(ticketnum);
			if (seat == -1) {
				int index = 0;
				int left = ticketnum;
				while (left > 0) {
					int m = ticket[index];
					int start = index * 5 + 6 - ticket[index];
					for (int j = 0; j < Math.min(m, left); j++) {
						res[i][j + ticketnum - left] = start + j;
					}
					ticket[index] = Math.max(ticket[index] - left, 0);
					left = Math.max(left - m, 0);
					index++;
				}
			} else {
				int start = seat * 5 + 6 - ticket[seat];
				for (int j = 0; j < ticketnum; j++) {
					res[i][j] = start + j;
				}
				ticket[seat] = ticket[seat] - ticketnum;
			}
		}
		scanner.close();
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < 5 && res[i][j] != 0; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

	private static int findSeat(int ticketnum) {
		for (int i = 0; i < 20; i++) {
			if (ticket[i] >= ticketnum)
				return i;
		}
		return -1;
	}

}
