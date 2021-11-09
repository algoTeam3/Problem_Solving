import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int M, N;
	public static int[][] map, arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());	// 가로 크기
		N = Integer.parseInt(st.nextToken());	// 세로 크기
		
		map = new int[N][M];					// 미로
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);
		// 출력
		System.out.println(map[N-1][M-1]);
	}

	// bfs
	public static void bfs(int x, int y) {
		Deque<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			
			// 4방 탐색
			for (int d = 0; d < 4; d++) {
				int nx = temp[0] + dx[d];
				int ny = temp[1] + dy[d];
				// 범위를 벗어났을 때
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if (!visited[nx][ny]) {
					// 벽 뚫기
					if (map[nx][ny] == 1) {
						map[nx][ny] = map[temp[0]][temp[1]] + 1;
						q.addLast(new int[] {nx, ny});
					}
					else {
						map[nx][ny] = map[temp[0]][temp[1]];
						q.addFirst(new int[] {nx, ny});
					}
					visited[nx][ny] = true;
					// 도착
					if (nx == N-1 && ny == M-1) return;
				}
			}
		}
	}
}
