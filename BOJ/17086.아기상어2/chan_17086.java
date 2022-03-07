import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class chan_17086 {
	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int answer = 0;
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		} // 입력 받기 완료
		
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (map[n][m] == 0) {
					int distance = bfs(n, m);
					//System.out.println("(" + n + ", " + m + ") => " + distance);
					answer = distance > answer ? distance : answer;
				}
			}
		}
		System.out.println(answer);
	}
	
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	private static int bfs(int n, int m) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		queue.offer(new int[] {n, m, 0});
		visited[n][m] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int curX = current[0];
			int curY = current[1];
			int cnt = current[2];
			for (int d = 0; d < 8; d++) {
				int nx = dx[d] + curX;
				int ny = dy[d] + curY;
				//System.out.println("(" + nx + ", " + ny + "), cnt = " + (cnt + 1));
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if (visited[nx][ny]) continue;
				if (map[nx][ny] == 1) {
					return cnt + 1;
				}
				queue.offer(new int[] {nx, ny, cnt+1});
				visited[nx][ny] = true;
			}
		}
		return 0;
	}
}

/*
4 4
0 0 0 0
0 0 0 0
0 0 0 0
1 0 0 0
*/