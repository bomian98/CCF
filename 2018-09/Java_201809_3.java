import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

//60分，不清楚什么地方错的
public class Java_201809_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int layers = scanner.nextInt();
		int choice = scanner.nextInt();
		scanner.nextLine();
		// 存储所有节点
		List<Node> all_nodes = new ArrayList<>();
		// 存储当前节点所有父节点,可以理解为从根节点到当前节点的路径
		List<Node> nodes = new ArrayList<>();
		// 根节点
		String root_name = scanner.nextLine();
		Node root = new Node(root_name, null, 1);
		nodes.add(root);
		all_nodes.add(root);
		// 生成树
		for (int i = 1; i < layers; i++) {
			String string = scanner.nextLine().trim();
			int layer = getLayer(string);
			// 更新路径
			while (layer < nodes.size()) {
				nodes.remove(nodes.size() - 1);
			}
			// 分割当前行，将标签与#id分离开
			String[] names = string.substring(layer * 2).split(" ");
			// 生成当前标签node
			Node node = new Node(names[0], nodes.get(nodes.size() - 1), i + 1);
			// 将当前节点加入父节点的字节点列表中、总节点中
			nodes.get(layer - 1).childs.add(node);
			nodes.add(node);
			all_nodes.add(node);
			// System.out.println(nodes.size());
			// 如果存在#id时，添加#id节点
			if (names.length == 2) {
				Node node2 = new Node(names[1], nodes.get(nodes.size() - 1), i + 1);
				all_nodes.add(node2);
				nodes.get(layer).childs.add(node2);
			}
		}
		for (int i = 0; i < choice; i++) {
			String[] string = scanner.nextLine().trim().split(" ");
			String reString = "";
			int count = 0;
			for (int j = 0; j < all_nodes.size(); j++) {
				Node node = all_nodes.get(j);
				if (node.name.equals(string[0])) {
					if (string.length == 1) {
						reString = reString + node.layer + " ";
						count++;
					} else {
						int layer = 0;
						if ((layer = find(node, string, 1)) != -1) {
							reString = reString + layer + " ";
							count++;
						}

					}
				}
			}
			reString = count + " " + reString;
			System.out.println(reString);
		}
		scanner.close();
	}

	private static int find(Node node, String[] string, int i) {
		int layer = -1;
		for (int m = 0; m < node.childs.size(); m++) {
			Node child = node.childs.get(m);
			if (child.name.equals(string[i])) {
				if (i == string.length - 1)
					return child.layer;
				else if ((layer = find(child, string, i + 1)) != -1)
					return layer;
			}
		}
		return layer;
	}

	private static int getLayer(String string) {
		int length = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '.')
				length++;
			else
				break;
		}
		return length / 2;
	}
}

class Node {
	String name;
	Node father;
	int layer;
	List<Node> childs;

	public Node(String name, Node father, int layer) {
		this.father = father;
		this.name = name;
		this.layer = layer;
		childs = new ArrayList<>();
	}

	public List<Node> find(String name) {
		return null;
	}

	@Override
	public String toString() {
		return name + " " + father.name;
	}
}