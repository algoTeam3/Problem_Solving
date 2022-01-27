import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요구사항 : 도미노를 넘어뜨리는 공격수와 도미노를 세우려고 하는 수비수가 도미노 게임을 하고 있을 때,
 * 			공격수의 점수와 게임판의 최종 상태를 출력해라
 * 게임 방법
 * 	- 1. 2차원 게임판의 각 격자에 도미노를 세운다. 
 * 	- 2. 매 라운드는 공격수가 공격한 후 공격이 끝나면 수비수가 수비한다.
 * 	- 3. 공격수는 도미노를 동서남북 중 한 방향으로 넘어뜨린다.
 * 		- 길이가 K인 도미노가 특정 방향으로 넘어지면 그 도미노를 포함해 그 방향으로 있는 도미노들 K개가 넘어진다.
 * 		- 넘어지는 도미노의 높이만큼 또 그 방향의 도미노들이 연쇄적으로 넘어진다.
 * 	- 4. 수비수는 넘어져있는 도미노들 중 원하는 것 하나를 다시 세울 수 있다.
 * 	- 이미 넘어진 도미노가 있는 칸을 공격하거나 넘어지지 않은 도미노를 세우려고 하면 아무 일도 일어나지 않는다.
 * 	- 총 R번의 라운드동안 3,4번 과정이 반복된다.
 * 	- 매 라운드마다 공격수가 해당 라운드에 넘어뜨린 도미노 개수를 세고, R라운드에 걸친 총합이 공격수의 점수이다. 
 *  
 * 입력
 * 		첫째줄 : 게임판 행 개수 N, 열 개수 M, 라운드 횟수 R
 * 		N개줄 : 게임판의 상태이고, 한 개의 줄은 각 격자의 도미노 길이인 M개의 숫자가 입력됨
 * 		R*2개줄 : 각 라운드가 두 줄 - 첫줄은 공격수의 행동 (X행 Y열의 도미노를 D방향으로 밀기) (D는 E,W,S,N 중 하나)
 * 							 - 둘째줄은 수비수의 행동 (X행 Y열의 도미노를 다시 세우기)
 * 출력 
 * 		공격수의 점수
 * 		게임판 상태 - 넘어진 것은 F, 넘어지지 않은 것은 S
 * 제약
 * 		1 <= N, M <= 100
 * 		1 <= R <= 10000
 * 		1 <= 도미노 높이 <= 5
 * 		
 * @author chaeu
 *
 */
public class chan_20165 {
	static int N, M, R, ans;
	static int[][] board;
	static char[][] status;
	static int fX, fY, sX, sY;
	static char fD;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		ans = 0;
		board = new int[N][M];
		status = new char[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				board[n][m] = Integer.parseInt(st.nextToken());
				status[n][m] = 'S';
			}
		}
		
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			fX = Integer.parseInt(st.nextToken()) - 1;
			fY = Integer.parseInt(st.nextToken()) - 1;
			fD = st.nextToken().charAt(0);
			// 3. 공격수는 (fX, fY)의 도미노를 fD방향으로 넘어뜨린다.
			fDirection();
			st = new StringTokenizer(br.readLine(), " ");
			sX = Integer.parseInt(st.nextToken()) - 1;
			sY = Integer.parseInt(st.nextToken()) - 1;
			// 4. 수비수는 넘어져있는 도미노들 중 원하는 것 하나를 다시 세울 수 있다.
			sDefense();
		}
		System.out.println(ans);
		printStatus();
	}
	
	private static void sDefense() {
		if (status[sX][sY] == 'S') return;
		status[sX][sY] = 'S';
	}

	private static void printStatus() {
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				System.out.print(status[n][m] + " ");
			}
			System.out.println();
		}
	}

	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	private static void fDirection() {
		// 이미 넘어진 도미노가 있는 칸을 공격하면 아무일도 일어나지않음
		if (status[fX][fY] == 'F') return;
		// 도미노를 넘어뜨리는 방향 찾기
		int d = 0;
		switch(fD) {
		case 'E': 
			d = 0;
			break;
		case 'W':
			d = 1;
			break;
		case 'S':
			d = 2;
			break;
		case 'N':
			d = 3;
			break;
		}
		
		status[fX][fY] = 'F';
		ans++;
		fAttack(fX, fY, d, 1, board[fX][fY]);
	}
  
	private static void fAttack(int x, int y, int d, int cnt, int height) {
		if (cnt == height) return; 
		int nx = x + dx[d];
		int ny = y + dy[d];
		if (0 <= nx && 0 <= ny && nx < N && ny < M) {
			// 각 도미노마다 쓰러뜨릴 수 있는 개수 세기
			fAttack(nx, ny, d, cnt + 1, height);
			if (status[nx][ny] == 'S') {
				// 그 방향의 도미노들이 연쇄적으로 넘어짐
				fAttack(nx, ny, d, 1, board[nx][ny]);
				
				// 쓰러뜨리고, 공격자 점수 추가
				status[nx][ny] = 'F';
				ans++;
			}
		}
	} 
}
