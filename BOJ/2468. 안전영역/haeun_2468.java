import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int N, max;
	public static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// 행렬의 크기
		map = new int[N][N];
		max = 0;								// 안전한 영역의 최대 갯수
		int high = 0;							// 최고 높이
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (high < map[i][j]) high = map[i][j];
			}
		}
		
		// 높이 하나씩 안전영역 계산
		for (int i = 0; i <= high; i++) {
			bfs(i);
		}
		
		// 출력
		System.out.println(max);
	}
	
	// bfs
	public static void bfs(int n) {
		// 안전영역 갯수
		int cnt = 0;
		// 방문체크
		boolean[][] visited = new boolean[N][N];
		// 행렬의 요소 하나씩 계산
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 이미 방문했거나 잠기는 영역일 때는 생략
				if (visited[i][j] || map[i][j] <= n) continue;
				
				Queue<int[]> q = new LinkedList<>();
				q.offer(new int[] {i, j});
				visited[i][j] = true;
				
				while (!q.isEmpty()) {
					int[] temp = q.poll();
					
					// 4방 탐색
					for (int d = 0; d < 4; d++) {
						int nx = temp[0] + dx[d];
						int ny = temp[1] + dy[d];
						
						if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
						// 방문한 적이 없고, 안전영역일 때
						if (!visited[nx][ny] && map[nx][ny] > n) {
							visited[nx][ny] = true;
							q.offer(new int[] {nx, ny});
						}
 					}
				}
				// 안전영역 + 1
				cnt++;
			}
		}
		// 안전영역 최대 갯수 갱신
		if (cnt > max) max = cnt;
	}
}
