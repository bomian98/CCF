import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Java_201809_4 {
	static int n, index = 0;
	static int head[], dist[];
	static boolean[] visited;
	static Edge edges[];

	public static void main(String[] args) {
		head = new int[306];
		dist = new int[306];
		visited = new boolean[306];
		edges = new Edge[2006];
		Arrays.fill(head, -1);
		// edges不能用Arrays.fill(edges,new Edge())赋值!!!!!
		for(int i = 0; i < 2006; i++) {
			edges[i] = new Edge();
		}

		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		int[] a = new int[306];
		for (int i = 1; i <= n; i++) {
			a[i] = scanner.nextInt();
		}
		scanner.close();
		
		
		for (int i = 0; i < n - 2; i++) {
			addEdge(i + 3, i, -(a[i + 2] * 3 + 2));
			addEdge(i, i + 3, a[i + 2] * 3);
		}		
		addEdge(2, 0, -(a[1] * 2 + 1)); // 对开始两个单独处理
		addEdge(0, 2, a[1] * 2);
		addEdge(n, n - 2, -(a[n] * 2 + 1));// 对结尾两个单独处理
		addEdge(n - 2, n, a[n] * 2); 
		for (int i = 1; i <= n; i++) // 每个数都要大于等于1
			addEdge(i - 1, i, 1); 
		
		
		spfa();
		

		a[1] = dist[1];
		for (int i = 2; i < n + 1; i++)
			a[i] = dist[i] - dist[i - 1];
		for (int i = 1; i <= n; i++) {
			System.out.print(a[i] + " ");
		}
	}

	
	static void spfa() {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i <= n; i++) {
			queue.offer(i);
			visited[i] = false;
			dist[i] = 0;
		}
		while (!queue.isEmpty()) {
			int x = queue.poll();
			visited[x] = false;
			for (int i = head[x]; i != -1; i = edges[i].next) {
				int nx = edges[i].to;
				if (dist[nx] < dist[x] + edges[i].weight) {
					dist[nx] = dist[x] + edges[i].weight;
					if (!visited[nx]) {
						visited[nx] = true;
						queue.offer(nx);
					}
				}
			}
		}
	}

	static void addEdge(int x, int y, int w) {
		edges[index].to = y;
		edges[index].next = head[x];
		edges[index].weight = w;
		head[x] = index;
		index++;
	}

	static class Edge {
		int to; // 边的另一个节点
		int next; // 节点的下一条边
		int weight; // 权值
	}
}
