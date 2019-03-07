import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Java_201703_4 {
	static int[] fathers;
	static Comparator<int[]> com = new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[2] - o2[2];
		}
	};

	// ���ȶ��з���
	// 85�֣���ʱ
	static void MST() {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int route = scanner.nextInt();
		PriorityQueue<int[]> queue = new PriorityQueue<>(com);
		// ��ʼ�����鼯
		fathers = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			fathers[i] = i;
		}
		// ��ȡ��
		for (int i = 0; i < route; i++) {
			int[] arr = new int[3];
			for (int j = 0; j < 3; j++) {
				arr[j] = scanner.nextInt();
			}
			queue.add(arr);
		}
		scanner.close();

		// Kruskal�㷨
		for (int i = 0; i < route; i++) {
			int[] edges = queue.poll();
			int a = edges[0], b = edges[1];
			int father_a = findfathers(a);
			int father_b = findfathers(b);
			if (father_a != father_b) {
				fathers[father_a] = father_b;
			}
			if (findfathers(1) == findfathers(num)) {
				System.out.println(edges[2]);
				break;
			}
		}
	}

	
	static int findfathers(int child) {
		int father = child;
		while (fathers[father] != father) {
			father = fathers[father];
		}
		// ·��ѹ��
		int i = child, j;
		while (i != father) {
			j = fathers[i];
			fathers[i] = father;
			i = j;
		}
		return father;
	}

	public static void main(String[] args) {
		MST();
	}
}
