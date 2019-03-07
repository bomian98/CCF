import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Java_201609_4_wrong {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int routes = scanner.nextInt();
		int[][] edges = new int[num + 1][num + 1];
		for (int i = 0; i < routes; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			edges[a][b] = c;
			edges[b][a] = c;
		}
		scanner.close();

		// dijkstra算法
		boolean visited[] = new boolean[num + 1];// 是否处理过
		int[] dis = new int[num + 1];// 从起始点到当前点的距离
		int[] pre = new int[num + 1];// 记录加入当前节点需要高速公路长度
		Queue<int[]> queue = new PriorityQueue<>(com);
		// 初始化
		for (int i = 1; i <= num; i++) {
			dis[i] = Integer.MAX_VALUE;
		}
		dis[1] = 0;
		// dijkstra
		queue.offer(new int[] { 0, 1 });
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int weight = node[0], index = node[1];
			if (!visited[index]) {
				visited[index] = true;
				for (int i = 1; i <= num; i++) {
					if (!visited[i]) {
						int edge = edges[index][i];
						if (edge == 0)
							continue;
						int newweight = edge + weight;
						if (newweight < dis[i]) {
							pre[i] = newweight;
							dis[i] = newweight;
							queue.offer(new int[] { dis[i], i });
						}
						if (newweight == dis[i]) {
							pre[i] = Math.min(edge, pre[i]);
						}
					}
				}
			}
		}

		int total = 0;
		for (int i = 2; i <= num; i++) {
			total += pre[i];
		}
		System.out.println(total);
	}

	static Comparator<int[]> com = new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[0] - o2[0];
		}
	};
}
