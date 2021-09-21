import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 요구사항 : N X M 배열의 미로가 있을 때, (1, 1)에서 출발해 (N, M)에 도착하기까지 최소 칸 수 구하기
 * 조건 : 한칸에서 다른칸으로의 이동은 서로 인접한 칸으로만 가능
 * 		1은 이동 가능한 칸, 0은 이동 불가능한 칸
 * 
 * (1, 1)이 출발점, (N, M)이 도착점이라, 미로와 방문체크하는 배열의 크기는 [N + 1][M + 1]로 해줌 
 */
public class chan {

	static int N, M;	// 미로의 크기 N X M
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split(" ");
		N = Integer.parseInt(data[0]);
		M = Integer.parseInt(data[1]);
		map = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				map[i][j] = temp[j - 1] - '0';
			}
		}	// 입력 받기 완료
		
		bfs();
		System.out.println(min);
	}
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int min = Integer.MAX_VALUE;
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N + 1][M + 1];
		
		q.offer(new int[] {1, 1, 1});	// 시작 x좌표, 시작 y좌표, 지나온 칸 수
		visited[1][1] = true;
		while(!q.isEmpty()) {
			int[] current = q.poll();
			// 현재 위치(current)에서 사방탐색으로 갈 수 있는 점 위치 확인
			for (int d = 0; d < 4; d++) {
				// 기저 조건 : (N, M)까지 왔으면, 지나온 칸 수가 최소값인지 구하기
				if (current[0] == N && current[1] == M) {
					min = Math.min(min, current[2]);
				}
				
				int nx = dx[d] + current[0];
				int ny = dy[d] + current[1];
				// 미로 범위 내인지 범위체크
				if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
				// 왔던 좌표인지 방문체크
				if (visited[nx][ny]) continue;
				// 이동할 수 있는 칸인지 체크
				if (map[nx][ny] == 0) continue;
				// 방문한 좌표가 아니고, 이동 가능한 칸이면 그 좌표와, 1을 더한 카운트 값을 큐에 넣기
				q.offer(new int[] {nx, ny, current[2] + 1});
				visited[nx][ny] = true;
			}
		}
	}

}
