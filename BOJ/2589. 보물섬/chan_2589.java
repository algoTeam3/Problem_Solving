import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 요구사항 : 최단 거리로 이동가능한 경우 중 가장 긴 시간을 구해라.(한 칸 이동하는데 한 시간 걸린다.)
 * @author chaeu
 */
public class chan_2589 {

	static char[][] map;
	static int H, W, ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());	// 지도의 세로 크기
		W = Integer.parseInt(st.nextToken());	// 지도의 가로 크기
		ans = 0;	// 최단거리로 이동하는 시간
		map = new char[H][W];
		for (int i = 0; i < H; i++) {
			char[] data = br.readLine().toCharArray();
			for (int j = 0; j < W; j++) {
				map[i][j] = data[j];
			}
		}// 입력 받기 완료
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'L') {	// 육지일 때 최단거리 구하기
					ans = Math.max(ans, bfs(i, j));	// 최단거리 중 가장 긴 시간 구하기
				} 
			}
		}
		System.out.println(ans);
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	private static int bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[H][W];
		
		int dist = 0;
		queue.offer(new int[] {i, j, 0});
		visited[i][j] = true;
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			dist = current[2];	
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				// 범위 체크
				if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
				// 바다인지 체크
				if (map[nx][ny] == 'W') continue;
				// 방문 체크
				if (visited[nx][ny]) continue;
				queue.offer(new int[] {nx, ny, dist + 1});
				visited[nx][ny] = true;
			}
		}
		return dist;	// 가장 마지막에 저장되는 거리가 bfs 출발점에서 최단거리
	}

}
