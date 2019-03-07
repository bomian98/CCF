import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Java_201609_4 {
	static ArrayList<Edge>[] map;
	static Queue<Node> q;
	static boolean[] vis;
	static int[] dis;
	static int[] cost;
	static int n;

	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		n = sin.nextInt();
		int m = sin.nextInt();
		map = new ArrayList[n + 1];
		q = new PriorityQueue();
		vis = new boolean[n + 1];
		dis = new int[n + 1];
		cost = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			map[i] = new ArrayList();
			dis[i] = 0x3f3f3f;
		}
		for (int j = 0; j < m; j++) {
			int start = sin.nextInt();
			int end = sin.nextInt();
			int weight = sin.nextInt();
			map[start].add(new Edge(end, weight));
			map[end].add(new Edge(start, weight));
		}
		Dijkstra(1);
		int sum = 0;
		for (int k = 2; k <= n; k++) {
			sum += cost[k];
		}
		System.out.println(sum);
	}

	static void Dijkstra(int start) {

		vis[0] = true;
		q.offer(new Node(start, 0));
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			if (!vis[tmp.end]) {
				vis[tmp.end] = true;
				for (int j = 0; j < map[tmp.end].size(); j++) {
					int weight = tmp.weight + map[tmp.end].get(j).weight;
					int end = map[tmp.end].get(j).end;
					int co = map[tmp.end].get(j).weight;
					Edge e = new Edge(tmp.end, co);
					map[end].remove(e);
					if (weight < dis[end]) {
						dis[end] = weight;
						cost[end] = weight;
						q.offer(new Node(end, dis[end]));
					}
					if (weight == dis[end]) {
						cost[end] = Math.min(cost[end], co);
					}
				}
			}

		}

	}

	static class Node implements Comparable {
		int end;
		int weight;

		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Object arg0) {
			return this.weight - ((Node) arg0).weight;
		}
	}

	static class Edge {
		int end;
		int weight;

		Edge(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public boolean equals(Object obj) {
			Edge other = (Edge) obj;
			if (this.end == other.end && this.weight == other.weight) {
				return true;
			}
			return false;
		}

	}
}