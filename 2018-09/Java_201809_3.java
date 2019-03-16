import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

//60�֣������ʲô�ط����
public class Java_201809_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int layers = scanner.nextInt();
		int choice = scanner.nextInt();
		scanner.nextLine();
		// �洢���нڵ�
		List<Node> all_nodes = new ArrayList<>();
		// �洢��ǰ�ڵ����и��ڵ�,�������Ϊ�Ӹ��ڵ㵽��ǰ�ڵ��·��
		List<Node> nodes = new ArrayList<>();
		// ���ڵ�
		String root_name = scanner.nextLine();
		Node root = new Node(root_name, null, 1);
		nodes.add(root);
		all_nodes.add(root);
		// ������
		for (int i = 1; i < layers; i++) {
			String string = scanner.nextLine().trim();
			int layer = getLayer(string);
			// ����·��
			while (layer < nodes.size()) {
				nodes.remove(nodes.size() - 1);
			}
			// �ָǰ�У�����ǩ��#id���뿪
			String[] names = string.substring(layer * 2).split(" ");
			// ���ɵ�ǰ��ǩnode
			Node node = new Node(names[0], nodes.get(nodes.size() - 1), i + 1);
			// ����ǰ�ڵ���븸�ڵ���ֽڵ��б��С��ܽڵ���
			nodes.get(layer - 1).childs.add(node);
			nodes.add(node);
			all_nodes.add(node);
			// System.out.println(nodes.size());
			// �������#idʱ�����#id�ڵ�
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