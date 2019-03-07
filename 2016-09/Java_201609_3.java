import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//题目炉石传说
public class Java_201609_3 {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();// 操作数量
		scanner.nextLine();
		int playercount = 2;// 控制玩家的回合分辨先手和后手玩家
		Game game = new Game();
		for (int i = 0; i < n; i++) {
			String command = scanner.nextLine();
			if (command.equals("end")) {// 结束回合
				playercount++;
			} else if (command.contains("summon")) {// 召唤随从
				// summon <position> <attack> <health>
				String[] strs = command.split(" ");
				Follower follower = new Follower(Integer.parseInt(strs[3]), Integer.parseInt(strs[2]));
				game.players[playercount % 2].summonFollower(Integer.parseInt(strs[1]), follower);
			} else {// 攻击
				// attack <attacker> <defender>：
				String[] strs = command.split(" ");
				int a = playercount % 2;
				int b = a == 0 ? 1 : 0;
				game.players[a].attack(Integer.parseInt(strs[1]), Integer.parseInt(strs[2]), game.players[b]);
			}
		}
		scanner.close();
		game.outputResult();
	}

	// 玩家类
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
			// 如果当前位置已经被占用 那么需要把右边的位置都加1
			if (fo != null) {
				int a = followers.size();
				for (int i = a; i >= place; i--) {// 从后往前修改
					Follower fol = followers.get(i);
					// if(fol!=null) {
					followers.remove(i);
					followers.put(i + 1, fol);
					// }
				}
			}
			followers.put(place, follower);
		}

		// 攻击
		public void attack(int myFollower, int enemyFoller, Player enemy) {
			Follower my = followers.get(myFollower);
			if (enemyFoller == 0) {// 如果攻击的是英雄
				enemy.heroBlood -= my.attack;
				// 判断游戏是否结束
				boolean isGameOver = enemy.isGameOver();
				if (isGameOver) {
					game.endCode = this.code;
				}
			} else { // 如果攻击的是小兵
				Follower enem = enemy.followers.get(enemyFoller);
				my.blood = my.blood - enem.attack;
				enem.blood = enem.blood - my.attack;
				updateBattleFiledAfterAttack(myFollower);
				enemy.updateBattleFiledAfterAttack(enemyFoller);
			}

		}

		// 如果攻击后随从死亡 需要更新战场
		public void updateBattleFiledAfterAttack(int place) {
			Follower f = followers.get(place);
			if (f.blood <= 0) {
				followers.remove(place);
				if (followers.get(place + 1) == null) {// 如果当前死亡的是最后一个不需要更新序号
					return;
				} else if (place == 1 && followers.size() >= 1) {// 如果死的是第一个且随从中不止一个
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

	// 随从类
	public static class Follower {
		public int blood = 0;
		public int attack = 0;

		public Follower(int blood, int attack) {
			this.blood = blood;
			this.attack = attack;
		}

	}

	// 游戏类
	public static class Game {
		public Player[] players = new Player[2];
		public int endCode = 0;// 1表示先手玩家赢了 -1表示后手 0表示还没游戏结束

		public Game() {
			players[0] = new Player(1, this);
			players[1] = new Player(-1, this);
		}

		public void outputResult() {
			System.out.println(endCode);
			// 输出先手的情况
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

			// 输出后手
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
