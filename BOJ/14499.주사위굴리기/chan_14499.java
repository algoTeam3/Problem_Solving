import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요구사항 : 주사위를 놓은 곳의 좌표와 이동시키는 명령이 주어졌을 때, 주사위가 이동할 때마다 상단에 쓰여있는 값을 구해라
 * - 주사위를 굴렸을 때, 이동한 칸에 쓰여있는 수가 0이면 주사위의 바닥면의 수가 칸에 복사
 * - 0이 아니면 칸에 쓰여있는 수가 주사위의 바닥면으로 복사되고 칸의 수는 0이 된다.
 * 
 * 입력 : 지도의 세로 크기 N, 가로 크기 M, 주사위를 놓은 곳의 좌표 x, y, 명령의 개수 K
 * 		N개 줄 ~ 지도에 쓰여있는 수 (N*M개)
 * 		마지막줄 ~ 이동하는 명령 (동쪽 1, 서쪽 2, 북쪽 3, 남쪽 4)
 * 제약 : 1 <= N, M <= 20
 * 		0 <= x <= N - 1
 * 		0 <= y <= M - 1
 * 		1 <= K <= 1000
 * 출력 : 이동할 때마다 주사위의 윗면에 쓰여있는 수 
 * 		(만약, 바깥으로 이동시키려고 하는 경우는 해당 명령 무시하고 출력도 하면 안 됨)
 *  
 * 주사위의 상단은 항상 1이고, 하단은 항상 6이다.
 * (주사위 위치에 따라 계속 값을 변경하기 때문)
 * @author chaeu
 *
 */
public class chan_14499 {
	static int N, M, x, y, K, currentBottom;
	static int[] dice, order;
	static int[][] map;
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 지도의 세로 크기
		M = Integer.parseInt(st.nextToken());	// 지도의 가로 크기
		x = Integer.parseInt(st.nextToken());	// 주사위 놓은 곳의 x 좌표
		y = Integer.parseInt(st.nextToken());	// 주사위 놓은 곳의 y 좌표
		K = Integer.parseInt(st.nextToken());	// 명령의 개수 
		
		dice = new int[7];
		order = new int[K];
		map = new int[N][M];
		currentBottom = 6;
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int k = 0; k < K; k++) {
			order[k] = Integer.parseInt(st.nextToken());
			moveDice(order[k]);// order[k] 방향으로 주사위 이동
		}
	}
	
	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, 1, -1, 0, 0};
	private static void moveDice(int order) {
		int nx = dx[order] + x;
		int ny = dy[order] + y;
		if (nx < 0 || ny < 0 || nx >= N || ny >= M) return;
		x = nx;
		y = ny;
		
		int temp = 0;
		switch(order) {
		case 1:
			temp = dice[3];
			dice[3] = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = temp;
			break;
		case 2:
			temp = dice[4];
			dice[4] = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = temp;
			break;
		case 3:
			temp = dice[6];
			dice[6] = dice[5];
			dice[5] = dice[1];
			dice[1] = dice[2];
			dice[2] = temp;
			break;
		case 4:
			temp = dice[2];
			dice[2] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = temp;
			break;
		}
		/*
		 * 조건 맞추기
		 * 주사위를 굴렸을 때, 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다. 
		 * 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.
		 */
		if (map[x][y] == 0) map[x][y] = dice[6];
		else {
			dice[6] = map[x][y];
			map[x][y] = 0;
		}
		
		System.out.println(dice[1]);
	}
}

