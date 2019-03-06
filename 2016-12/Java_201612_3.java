import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Java_201612_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Map<String, Integer>> roles = new HashMap<>();
		Map<String, Map<String, Integer>> users = new HashMap<>();
		// 获取所有权限
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			scanner.next();// 没有用
		}

		// 获取所有角色
		int roles_num = scanner.nextInt();
		for (int i = 0; i < roles_num; i++) {
			String rolename = scanner.next();
			int num = Integer.parseInt(scanner.next());
			Map<String, Integer> rolemap = new HashMap<>();
			for (int j = 0; j < num; j++) {
				String string = scanner.next();
				int index = string.indexOf(":");
				String privel = string;
				int max = -1;//-1表示无等级
				if (index > 0) {
					privel = string.substring(0, index);
					max = Integer.parseInt(string.substring(index + 1));
					max = Math.max(max, rolemap.getOrDefault(privel, 0));
				}
				rolemap.put(privel, max);
			}
			roles.put(rolename, rolemap);
		}

		// 获取所有用户
		int user_num = scanner.nextInt();
		for (int i = 0; i < user_num; i++) {
			String username = scanner.next();
			int num = Integer.parseInt(scanner.next());
			Map<String, Integer> usermap = new HashMap<>();
			for (int j = 0; j < num; j++) {
				String role = scanner.next();
				Map<String, Integer> rolemap = roles.get(role);
				for (String str : rolemap.keySet()) {
					usermap.put(str, Math.max(rolemap.get(str), usermap.getOrDefault(str, 0)));
				}
			}
			users.put(username, usermap);
		}

		// 判断
		int test_num = scanner.nextInt();
		for (int i = 0; i < test_num; i++) {
			String user = scanner.next();
			String ques = scanner.next();
			Map<String, Integer> user_privileges = users.get(user);
			if (user_privileges == null) {
				System.out.println("false");
				continue;
			}
			int index = ques.indexOf(":");
			if (index > 0) {
				String privilege = ques.substring(0, index);
				int max = Integer.parseInt(ques.substring(index + 1));
				if (user_privileges.containsKey(privilege)) {
					int real_max = user_privileges.get(privilege);
					if (real_max >= max)
						System.out.println("true");
					else
						System.out.println("false");
				} else {
					System.out.println("false");
				}
			} else {
				if (user_privileges.containsKey(ques)) {
					int real_max = user_privileges.get(ques);
					if (real_max != -1)
						System.out.println(real_max);
					else
						System.out.println("true");
				} else {
					System.out.println("false");
				}
			}
		}
		scanner.close();
	}
}
