import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//��Ŀ¯ʯ��˵
public class Java_201609_3 {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();// ��������
		scanner.nextLine();
		int playercount = 2;// ������ҵĻغϷֱ����ֺͺ������
		Game game = new Game();
		for (int i = 0; i < n; i++) {
			String command = scanner.nextLine();
			if (command.equals("end")) {// �����غ�
				playercount++;
			} else if (command.contains("summon")) {// �ٻ����
				// summon <position> <attack> <health>
				String[] strs = command.split(" ");
				Follower follower = new Follower(Integer.parseInt(strs[3]), Integer.parseInt(strs[2]));
				game.players[playercount % 2].summonFollower(Integer.parseInt(strs[1]), follower);
			} else {// ����
				// attack <attacker> <defender>��
				String[] strs = command.split(" ");
				int a = playercount % 2;
				int b = a == 0 ? 1 : 0;
				game.players[a].attack(Integer.parseInt(strs[1]), Integer.parseInt(strs[2]), game.players[b]);
			}
		}
		scanner.close();
		game.outputResult();
	}

	// �����
	public static class Player {
		public int heroBlood = 30;
		public int code;
		public Game game;
		public Map<Integer, Follower> followers = new HashMap<>();

		public Player(int code, Game game) {
			this.code = code;
			this.game = game;
		}

		public void summonFollower(int place, Follower follower) {
			Follower fo = followers.get(place);
			// �����ǰλ���Ѿ���ռ�� ��ô��Ҫ���ұߵ�λ�ö���1
			if (fo != null) {
				int a = followers.size();
				for (int i = a; i >= place; i--) {// �Ӻ���ǰ�޸�
					Follower fol = followers.get(i);
					// if(fol!=null) {
					followers.remove(i);
					followers.put(i + 1, fol);
					// }
				}
			}
			followers.put(place, follower);
		}

		// ����
		public void attack(int myFollower, int enemyFoller, Player enemy) {
			Follower my = followers.get(myFollower);
			if (enemyFoller == 0) {// �����������Ӣ��
				enemy.heroBlood -= my.attack;
				// �ж���Ϸ�Ƿ����
				boolean isGameOver = enemy.isGameOver();
				if (isGameOver) {
					game.endCode = this.code;
				}
			} else { // �����������С��
				Follower enem = enemy.followers.get(enemyFoller);
				my.blood = my.blood - enem.attack;
				enem.blood = enem.blood - my.attack;
				updateBattleFiledAfterAttack(myFollower);
				enemy.updateBattleFiledAfterAttack(enemyFoller);
			}

		}

		// ���������������� ��Ҫ����ս��
		public void updateBattleFiledAfterAttack(int place) {
			Follower f = followers.get(place);
			if (f.blood <= 0) {
				followers.remove(place);
				if (followers.get(place + 1) == null) {// �����ǰ�����������һ������Ҫ�������
					return;
				} else if (place == 1 && followers.size() >= 1) {// ��������ǵ�һ��������в�ֹһ��
					for (int i = 2; i <= followers.size() + 1; i++) {
						Follower follower = followers.get(i);
						followers.remove(i);
						followers.put(i - 1, follower);
					}
				} else {
					for (int i = place - 1; i >= 1; i--) {
						Follower ff = followers.get(i);
						if (ff != null) {
							followers.remove(i);
							followers.put(i + 1, ff);
						}
					}
				}

			}
		}

		public boolean isGameOver() {
			return heroBlood <= 0 ? true : false;
		}
	}

	// �����
	public static class Follower {
		public int blood = 0;
		public int attack = 0;

		public Follower(int blood, int attack) {
			this.blood = blood;
			this.attack = attack;
		}

	}

	// ��Ϸ��
	public static class Game {
		public Player[] players = new Player[2];
		public int endCode = 0;// 1��ʾ�������Ӯ�� -1��ʾ���� 0��ʾ��û��Ϸ����

		public Game() {
			players[0] = new Player(1, this);
			players[1] = new Player(-1, this);
		}

		public void outputResult() {
			System.out.println(endCode);
			// ������ֵ����
			System.out.println(players[0].heroBlood);
			System.out.print(players[0].followers.size());
			for (int i = 1; i <= 7; i++) {
				Follower follower = players[0].followers.get(i);
				if (follower == null) {
					break;
				} else {
					System.out.print(" " + follower.blood);
				}
			}
			System.out.println();

			// �������
			System.out.println(players[1].heroBlood);
			System.out.print(players[1].followers.size());
			for (int i = 1; i <= 7; i++) {
				Follower follower = players[1].followers.get(i);
				if (follower == null) {
					break;
				} else {
					System.out.print(" " + follower.blood);
				}
			}
		}
	}
}
