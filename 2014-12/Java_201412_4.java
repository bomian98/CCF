import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Java_201412_4 {
	static int[] father;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numOfNode = scanner.nextInt(), numOfRoute = scanner.nextInt();
		int[][] routes = new int[numOfRoute][3];
		father = new int[numOfNode + 1];
		for (int i = 0; i < numOfRoute; i++) {
			routes[i][0] = scanner.nextInt();
			routes[i][1] = scanner.nextInt();
			routes[i][2] = scanner.nextInt();
		}
		scanner.close();
		Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				for (int i = 2; i >= 0; i--) {
					if (o1[i] != o2[i])
						return o1[2] - o2[2];
				}
				return 0;
			}
		});

		int count = 0, output = 0;
		for (int i = 0; i < numOfRoute; i++) {
			int[] route = routes[i];
			int father1 = Find(route[0]), father2 = Find(route[1]);
			if (father1 != father2) {
				father[father1] = father2;
				count++;
				output = output + route[2];
			}
			if (count == numOfNode - 1) {
				System.out.println(output);
				return;
			}
		}
	}

	static int Find(int child) {
		if (father[child] != 0) {
			return father[child] = Find(father[child]);
		} else {
			return child;
		}
	}
}
