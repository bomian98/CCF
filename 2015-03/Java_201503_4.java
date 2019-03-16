import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Java_201503_4 {
	static Map<Integer, treenode> nodes;
	static int maxroute;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int changes = scanner.nextInt();
		int computers = scanner.nextInt();
		nodes = new HashMap<>();
		treenode root = new treenode(1);
		nodes.put(1, root);
		for (int i = 2; i < changes + computers + 1; i++) {
			int father = scanner.nextInt();
			treenode nodeFather = nodes.get(father);
			treenode node = new treenode(i);
			nodeFather.treenodes.add(node);
			nodes.put(i, node);
		}
		scanner.close();

		maxroute = 0;
		int route = DFS(root);
		maxroute = Math.max(route, maxroute);
		System.out.println(maxroute);
	}

	private static int DFS(treenode node) {
		if (node.treenodes.size() > 1) {
			int max1 = 0, max2 = 0;
			int route;
			for(treenode child: node.treenodes) {
				route = DFS(child);
				if(route>=max1) {
					max2 = max1;
					max1 = route;
				}else {
					max2 = Math.max(max2, route);
				}
			}
			route = max1+max2+2;
			maxroute = Math.max(route, maxroute);
			return max1+1;
		} else if (node.treenodes.size() == 1) {
			return DFS(node.treenodes.get(0)) + 1;
		} else {
			return 0;
		}
	}

	static class treenode {
		int num;
		List<treenode> treenodes;

		public treenode(int num) {
			this.num = num;
			treenodes = new ArrayList<>();
		}
	}
}
