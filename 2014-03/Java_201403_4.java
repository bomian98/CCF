import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Java_201403_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		long r = sc.nextLong();
		Node node[] = new Node[n + m];
		for (int i = 0; i < node.length; i++) {
			node[i] = new Node(sc.nextLong(), sc.nextLong(), i);
		}
		sc.close();
		boolean vis[][] = new boolean[n + m][n + m];
		Queue<Node> q = new LinkedList<Node>();
		q.add(node[0]);
		while (!q.isEmpty()) {
			Node no = q.poll();
			int ti = no.time;
			int add = no.newAdd;
			int num = no.num;
			if (num == 1) {// 如果访问到第二个顶点(下标为1的顶点),则输出经过的中转路由器的个数。
				System.out.println(ti - 1);
				return;
			}
			for (int i = 1; i < node.length; i++) {
				if (node[i].distance(no) <= r && num != i) {// 去除与自身计算距离
					if (vis[i][num] == true) {// 如果num 点已经通过i点加入到队列中，那么应该continue
						continue;
					}
					if (i < n && add <= k) {
						q.add(new Node(node[i].x, node[i].y, ti + 1, add, i));
					} else if (i >= n && add + 1 <= k) {// 如果i>=n，说明是新设的点，所以应该add+
						q.add(new Node(node[i].x, node[i].y, ti + 1, add + 1, i));
					} else {
						continue;
					}
					vis[i][num] = true;
					vis[num][i] = true;
				}
			}
		}
	}

	static class Node {
		int num;// 编号
		long x;// x坐标
		long y;// y坐标
		int time;// 已经走过的步数
		int newAdd;// 到达这个点所经过的新设路由器

		public Node(long x, long y, int num) {
			this.num = num;
			this.x = x;
			this.y = y;
			time = 0;
			newAdd = 0;
		}

		public Node(long x, long y, int time, int newAdd, int num) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.newAdd = newAdd;
			this.num = num;
		}

		public double distance(Node n) {
			long t1 = n.x - x;
			long t2 = n.y - y;
			return Math.sqrt(t1 * t1 + t2 * t2);
		}
	}
}
