import java.util.Scanner;

public class Java_201604_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String currentDir = sc.next();
		String arr[] = new String[n];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String temp = sc.nextLine();
			if (temp.length() != 0 && temp.charAt(0) != '/') {
				temp = currentDir + "/" + temp;

			} else if (temp.length() == 0) {
				temp = currentDir + "/" + temp;
			}
			arr[i] = temp.replaceAll("/{2,3}", "/");
		}
		sc.close();
		for (int i = 0; i < n; i++) {
			String sp[] = arr[i].trim().split("/");
			String result = "";
			for (int j = 0; j < sp.length; j++) {
				if (sp[j].length() == 0) {
					continue;
				}
				if (!sp[j].equals("..") && !sp[j].equals(".")) {
					result = result + "/" + sp[j];
				} else if (sp[j].equals(".")) {

				} else if (sp[j].equals("..")) {
					int index = result.lastIndexOf("/");
					if (index != -1) {
						result = result.substring(0, index);
					}
				}
			}
			if (result.length() == 0) {
				result = "/";
			}
			arr[i] = result;
		}
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}
}