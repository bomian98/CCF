import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Java_201509_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numOfLine = scanner.nextInt();
		int numOfName = scanner.nextInt();
		scanner.nextLine();
		String[] lines = new String[numOfLine];
		Map<String, String> names = new HashMap<>();
		for (int i = 0; i < numOfLine; i++) {
			lines[i] = scanner.nextLine();
		}
		for (int i = 0; i < numOfName; i++) {
			String name1 = scanner.next();
			String name2 = scanner.nextLine();
			name2 = name2.substring(2, name2.length() - 1);
			names.put(name1, name2);
		}
		scanner.close();

		for (int i = 0; i < numOfLine; i++) {
			String line = lines[i];
			String name;
			int start = -1;
			int index1 = line.indexOf("{{", start);
			int index2 = line.indexOf("}}", index1);
			while (index1 != -1 && index2 != -1) {
				name = line.substring(index1 + 3, index2 - 1);
				if (names.containsKey(name)) {
					String replace = names.get(name);
					line = line.substring(0, index1) + replace + line.substring(index2 + 2);
					start = index1 + replace.length();// 更改下一个括号判断的起始位置，避免出现嵌套情况
				} else {
					line = line.substring(0, index1) + line.substring(index2 + 2);
				}
				index1 = line.indexOf("{{", start);
				index2 = line.indexOf("}}", index1);
			}
			lines[i] = line;
			System.out.println(line);
		}

	}
}
