import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class chan_2638 {
	static int[][] board;
	static int N, M, answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		answer = 0;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				board[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			if (!anyCheese()) break;
			bfs();	// 외부 공기 구분
			melt();	// 외부 공기와 닿는 치즈 녹이기
			answer++;	// 한 시간 증가
		}
		
		System.out.println(answer);
	}

	// 치즈가 녹아있는지 검사
	private static boolean anyCheese() {
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (board[n][m] == 1) return true;
			}
		}
		return false;
	}

	private static void melt() {
		ArrayList<int[]> cheese = new ArrayList<>();
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (!visited[n][m] && board[n][m] == 1) {
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int nx = n + dx[d];
						int ny = m + dy[d];
						
						if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
						if (board[nx][ny] == 0 && visited[nx][ny]) cnt++;
					}
					
					if (cnt >= 2) cheese.add(new int[] {n, m});
				}
			}
		}
		
		// 치즈 한번에 녹이기
		for (int i = 0; i < cheese.size(); i++) {
			int[] cur = cheese.get(i);
			board[cur[0]][cur[1]] = 0;
		}
	}

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1}; 
	static boolean[][] visited;
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		visited = new boolean[N][M];
		
		queue.offer(new int[] {0, 0});
		visited[0][0] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if (visited[nx][ny]) continue;
				if (board[nx][ny] == 1) continue;
				
				queue.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}
	}
}
/*
8 9
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 1 1 0
0 1 0 1 1 1 0 1 0
0 1 0 0 1 0 0 1 0
0 1 0 1 1 1 0 1 0
0 1 1 0 0 0 1 1 0
0 0 0 0 0 0 0 0 0
 */

