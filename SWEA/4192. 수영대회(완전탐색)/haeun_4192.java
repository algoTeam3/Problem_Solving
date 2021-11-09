import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_D3_4192_수영대회 {
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int N, C, D;
	public static boolean flag;
	public static int[][] pool;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테스트케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());	// 수영장의 크기
			pool = new int[N][N];
			flag = true;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					pool[i][j] = Integer.parseInt(st.nextToken());
					// 장애물은 -1로 지정
					if (pool[i][j] == 1) pool[i][j] = -1;
				}
			}
			
			// 시작위치
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			// 도착위치
			st = new StringTokenizer(br.readLine(), " ");
			C = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			bfs(A, B);
			// 출력
			if (flag) System.out.printf("#%d %d\n", tc, pool[C][D]);
			else System.out.printf("#%d %d\n", tc, -1);
		}
	}

	// bfs
	public static void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][N];
		visited[a][b] = true;
		q.offer(new int[] {a, b});
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			
			// 4방 탐색
			for (int d = 0; d < 4; d++) {
				int nx = temp[0] + dx[d];
				int ny = temp[1] + dy[d];
				// 장애물이나 범위를 벗어났을 때
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || pool[nx][ny] == -1) continue;
				if (!visited[nx][ny]) {
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					// 시간 추가
					pool[nx][ny] = pool[temp[0]][temp[1]] + 1;
					// 도착
					if (nx == C && ny == D) return;
				}
			}
		}
		// 도착 불가
		flag = false;
		return;
	}
}
