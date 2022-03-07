import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chan_1245 {
	static int N, M, answer;
	static int[][] map;
	static boolean flag;
	static boolean[][] totalVisited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		answer = 0;
		totalVisited = new boolean[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		} // 입력 받기 완료
		
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (!totalVisited[n][m]) {	
						flag = true;
						dfs(n, m);
						if (flag) {
							answer++;
						}
				}
			}
		}
		
		System.out.println(answer);
	}
	
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	private static void dfs(int n, int m) {
		totalVisited[n][m] = true;
		for (int d = 0; d < dx.length; d++) {
			int nx = n + dx[d];
			int ny = m + dy[d];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			if (map[n][m] < map[nx][ny]) {
				flag = false;
			}
			if (totalVisited[nx][ny]) continue;
			if (map[n][m] == map[nx][ny]) dfs(nx, ny);
		}
		
	}
}
