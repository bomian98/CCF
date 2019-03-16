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
			if (num == 1) {// ������ʵ��ڶ�������(�±�Ϊ1�Ķ���),�������������ת·�����ĸ�����
				System.out.println(ti - 1);
				return;
			}
			for (int i = 1; i < node.length; i++) {
				if (node[i].distance(no) <= r && num != i) {// ȥ��������������
					if (vis[i][num] == true) {// ���num ���Ѿ�ͨ��i����뵽�����У���ôӦ��continue
						continue;
					}
					if (i < n && add <= k) {
						q.add(new Node(node[i].x, node[i].y, ti + 1, add, i));
					} else if (i >= n && add + 1 <= k) {// ���i>=n��˵��������ĵ㣬����Ӧ��add+
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
		int num;// ���
		long x;// x����
		long y;// y����
		int time;// �Ѿ��߹��Ĳ���
		int newAdd;// ���������������������·����

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
