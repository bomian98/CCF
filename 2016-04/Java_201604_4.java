import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Java_201604_4 {
	static int[][] direct = new int[][] { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
	static int[][][] danger;
	static int n, m, t;

	public static void main(String[] args) {
		read();
		bfs();
	}

	static void bfs() {
		int count = 0;
		Set<Node> pre = new HashSet<>();
		Set<Node> now = new HashSet<>();
		pre.add(new Node(1, 1));
		while (true) {
			count++;
			for (Node posi : pre) {
				for (int i = 0; i < 4; i++) {
					int x = posi.x + direct[i][0];
					int y = posi.y + direct[i][1];
					if (x == n && y == m) {
						System.out.println(count);
						return;
					}
					if (canGo(x, y, count)) {
						now.add(new Node(x, y));
					}
				}
			}
			pre = now;
			now = new HashSet<>();
		}
	}

	static boolean canGo(int x, int y, int count) {
		if (x <= n && x >= 1 && y <= m && y >= 1) {
			if (danger[x][y][0] > count || danger[x][y][1] < count || danger[x][y][1] == 0)
				return true;
		}
		return false;
	}

	static void read() {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		t = scanner.nextInt();
		danger = new int[n+1][m+1][2];
		for (int i = 0; i < t; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			int d = scanner.nextInt();
			danger[a][b][0] = c;
			danger[a][b][1] = d;
		}
		scanner.close();
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		// Set对象去重时，先判断hashcode()是否相等，再判断equal()是否相等，因此两个函数均需要重写
		@Override
		public boolean equals(Object obj) {
			Node objs = (Node) obj;
			return objs.x == x && objs.y == y;
		}

		@Override
		public int hashCode() {
			return 500 * x + y;
		}

	}

}
