import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Java_201412_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Node> list = new ArrayList<>();
		while (scanner.hasNext()) {
			String operate = scanner.next();
			double price = 0;
			int num = 0;
			if (operate.equals("cancel")) {
				num = scanner.nextInt();
				list.set(num - 1, null);
			} else {
				price = scanner.nextDouble();
				num = scanner.nextInt();
			}
			Node node = new Node(operate, price, num);
			list.add(node);
		}
		scanner.close();

		PriorityQueue<double[]> buys = new PriorityQueue<>(com);
		PriorityQueue<double[]> sells = new PriorityQueue<>(com);
		long count_buy = 0, count_sell = 0;
		for (Node node : list) {
			if (node != null) {
				if (node.op.equals("buy")) {
					buys.offer(new double[] { node.price, node.num });
					count_buy = count_buy + node.num;
				} else if (node.op.equals("sell")) {
					sells.offer(new double[] { node.price, node.num });
				}
			}
		}

		long output2 = 0;
		double output1 = 0;

		while (buys.isEmpty() && !sells.isEmpty()) {
			output1 = Math.max(output1, sells.poll()[0]);
		}

		while (!buys.isEmpty() && sells.isEmpty()) {
			output1 = Math.max(output1, buys.poll()[0]);
		}

		while (!buys.isEmpty() && !sells.isEmpty()) {
			double min_buy = buys.peek()[0];
			double min_sell = sells.peek()[0];
			double min_price = Math.min(min_buy, min_sell);
			// 更新卖出的总股数
			while (!sells.isEmpty() && min_price == sells.peek()[0]) {
				count_sell = count_sell + (long) sells.peek()[1];
				sells.poll();
			}
			// 更新成交量与开盘价
			long n = Math.min(count_sell, count_buy);
			if (n >= output2) {
				output2 = n;
				output1 = min_price;
			}
			// 更新买入的总股数
			while (!buys.isEmpty() && min_price == buys.peek()[0]) {
				count_buy = count_buy - (long) buys.peek()[1];
				buys.poll();
			}
		}

		System.out.println(String.format("%.2f", output1) + " " + output2);

	}

	static Comparator<double[]> com = new Comparator<double[]>() {
		@Override
		public int compare(double[] o1, double[] o2) {
			return o1[0] - o2[0] > 0 ? 1 : -1;
		}
	};

	static class Node {
		String op;
		double price;
		int num;

		public Node(String op, double price, int num) {
			this.num = num;
			this.op = op;
			this.price = price;
		}

		@Override
		public String toString() {
			return op + " " + price;
		}
	}
}
