import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	
	public static int M, N, K, cnt;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());		// 가로
			N = Integer.parseInt(st.nextToken());		// 세로
			K = Integer.parseInt(st.nextToken());		// 배추의 수
			cnt = 0;									// 배추흰지렁이 마리수
			arr = new int[M][N];
			visited = new boolean[M][N];
			
			// 배추밭
			for (int i = 0;  i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[x][y] = 1;
			}
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			// 출력
			System.out.println(cnt);
		}
	}
	
	// bfs
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		arr[x][y] = 0;
	
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			x = temp[0];
			y = temp[1];
			// 4방탐색
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
				if (arr[nx][ny] == 1 && !visited[nx][ny]) {
					queue.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					arr[nx][ny] = 0;
				}
			}
		}
	}
}
