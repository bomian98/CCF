import java.util.ArrayList;
import java.util.Scanner;

public class Java_201604_3_70 {
	static ArrayList<String>[] lists;
	static String posi;
	static String[] input;
	static int num;

	public static void main(String[] args) {
		read();
		parse();
		print();
	}

	private static void print() {
		for (int i = 0; i < num; i++) {
			ArrayList<String> list = lists[i];
			if (list.isEmpty())
				System.out.print("/");
			for (String string : list) {
				System.out.print("/" + string);
			}
			System.out.println("");
		}

	}

	private static void parse() {
		String[] posistrings = posi.split("/");// 当前目录
		lists = new ArrayList[num];
		for (int i = 0; i < num; i++) {
			ArrayList<String> list = new ArrayList<>();
			String[] strings = input[i].split("/");
			if (input[i].length() == 0) { // 空字符串
				for (int j = 1; j < posistrings.length; j++)
					list.add(posistrings[j]);
			} else if (strings.length != 0) {
				if (strings[0].equals("..")) // 如果是绝对路径，获取当前目录
					for (int j = 1; j < posistrings.length; j++)
						list.add(posistrings[j]);
				for (int index = 0; index < strings.length; index++) {
					if (strings[index].equals("") || strings[index].equals("."))
						continue;
					if (strings[index].equals("..")) {
						if (!list.isEmpty())
							list.remove(list.size() - 1);
					} else {
						list.add(strings[index]);
					}
				}

			}
			lists[i] = list;
		}
	}

	private static void read() {
		Scanner scanner = new Scanner(System.in);
		num = scanner.nextInt();
		posi = scanner.next();
		scanner.nextLine();
		input = new String[num];
		for (int i = 0; i < num; i++) {
			input[i] = scanner.nextLine().trim();
		}
		scanner.close();
	}
}
