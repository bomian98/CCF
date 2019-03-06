import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Java_201709_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int line1 = scanner.nextInt();
		int line2 = scanner.nextInt();
		scanner.nextLine();
		List<node> lists = new ArrayList<>();
		for(int i = 0; i < line1; i++) {
			String string = scanner.nextLine().trim();
			//¼Ù¶¨²»º¬À¨ºÅ
			node node = new node(string);
			parse(node);
		}

	}

	private static void parse(node node) {
		String string = "";
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == '{') {
				node.beObject = true;
				i++;
			}else if(string.charAt(i) == '\"') {
				String string2 = "";
				i++;
				while(i<string.length()) {
					if(string.charAt(i) =='\\') {
						i++;
						string2 = string2+string.charAt(i);
					}else if(string.charAt(i)=='\"') {
						break;
					}
				}
			}
		}
	}
}

class node {
	String name;
	boolean beObject;
	List<String> list;

	public node(String name) {
		this.name = name;
		this.beObject = false;
		list = new ArrayList<>();
	}
}