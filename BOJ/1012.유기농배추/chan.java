import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class chan {

	static int M, N, K, ans;	// 배추밭 가로길이, 세로길이, 배추 심어진 위치 개수, 필요한 최소 지렁이 마리 수
	static int[][] map;	// 배추밭
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[M][N];
			visited = new boolean[M][N];
			ans = 0;
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}	// 입력받기 완료
			
			// 배추밭 전체를 훑는다.
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					// 배추가 심어진 땅이고, 방문하지 않은곳이면 bfs 탐색
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);	// (i, j)를 시작점으로 하는 bfs
						ans++;	// bfs 탐색을 끝내면 인접한 배추들이 모여있는 구역 하나의 탐색이 끝난 것이므로 필요한 지렁이 수 하나 증가시킨다.
					}
				}
			}
			System.out.println(ans);
		}
	}
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		while (!q.isEmpty()) {
			int[] current = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = current[0] + dx[d];
				int ny = current[1] + dy[d];
				// 배추밭 범위 체크
				if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
				// 땅 방문 체크
				if (visited[nx][ny]) continue;
				// 배추가 심어진 땅인지 체크
				if (map[nx][ny] == 0) continue;
				// 미방문이고, 배추가 심어진 땅이면 큐에 추가
				q.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}
		
	}

}
