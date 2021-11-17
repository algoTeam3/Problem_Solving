import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬 {
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static char[][] map;
	public static int L, W, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());	// 세로
		W = Integer.parseInt(st.nextToken());	// 가로
		map = new char[L][W];					// 보물 지도
		max = Integer.MIN_VALUE;
		
		for (int i = 0; i < L; i++) {
			String str = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}
		
		// 출력
		System.out.println(max);

	}
	
	// bfs
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] checked = new boolean[L][W];
		q.offer(new int[] {x, y, 0});
		checked[x][y] = true;
		
		// 거리 구하기
		int result = 0;
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			
			// 4방 탐색
			for (int d = 0; d < 4; d++) {
				int nx = temp[0] + dx[d];
				int ny = temp[1] + dy[d];
				if (nx < 0 || ny < 0 || nx >= L || ny >= W || map[nx][ny] == 'W') continue;
				if (!checked[nx][ny]) {
					result = temp[2] + 1;
					q.offer(new int[] {nx, ny, result});
					checked[nx][ny] = true;
				}
			}
		}
		// 최댓값 갱신
		if (max < result) max = result;
	}
}
