import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Java_201409_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		int n = scanner.nextInt();
		int num = scanner.nextInt();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			String str = scanner.next();
			if(n == 1) {
				if(str.indexOf(string)!=-1) 
					list.add(str);
			}else {
				if(str.toLowerCase().indexOf(string.toLowerCase())!=-1)
					list.add(str);
			}
		}
		scanner.close();
		for(String string2: list)
			System.out.println(string2);
	}
}
