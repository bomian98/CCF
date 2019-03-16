import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Java_201409_4 {
	static int[][] steps = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int col = scanner.nextInt();
		int numOfStore = scanner.nextInt();
		int numOfClient = scanner.nextInt();
		int numOfWrong = scanner.nextInt();
		int[][] stores = new int[numOfStore][2];
		int[][] squares = new int[col + 1][col + 1];
		boolean[][] visited = new boolean[col + 1][col + 1];
		int count = 0;// 记录客户的非重复地址数目
		Set<int[]> pres = new HashSet<>();
		Set<int[]> nows = new HashSet<>();
		
		for (int i = 0; i < numOfStore; i++) {
			stores[i][0] = scanner.nextInt();
			stores[i][1] = scanner.nextInt();
			pres.add(new int[] {stores[i][0], stores[i][1]});
			visited[stores[i][0]][stores[i][1]] = true;
		}
		for (int i = 0; i < numOfClient; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			if (squares[a][b] == 0)
				count++;
			squares[a][b] = squares[a][b] + c;
		}
		for (int i = 0; i < numOfWrong; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			visited[a][b] = true;
		}
		scanner.close();

		long total = 0;
		int step = 0;
		while(count>0) {
			step++;
			for(int[] pre : pres) {
				for(int i = 0; i < 4; i++) {
					int x = pre[0]+steps[i][0];
					int y = pre[1]+steps[i][1];
					if(x >= 1 && y >=1 && x <= col && y <= col && !visited[x][y]) {
						if(squares[x][y] > 0) {
							total = total+step*squares[x][y];
							count--;
						}
						nows.add(new int[] {x,y});
						visited[x][y] = true;
					}
				}
			}
			pres = new HashSet<>();
			for(int[] now:nows) {
				pres.add(new int[] {now[0],now[1]});
			}
			nows = new HashSet<>();
		}
		System.out.println(total);
	}

}
