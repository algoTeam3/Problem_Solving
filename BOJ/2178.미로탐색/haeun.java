import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int N, M;
	public static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// N * M
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);
		System.out.println(map[N-1][M-1]);
	}

	// bfs
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		visited[x][y] = true;
		queue.offer(new int[] {x, y});
		
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			x = temp[0];
			y = temp[1];
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if (!visited[nx][ny] && map[nx][ny] == 1) {
					queue.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					map[nx][ny] = map[x][y] + 1;
				}
			}
		}
	}
}
