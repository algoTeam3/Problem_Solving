import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 연구소의 정보가 주어졌을 때, 총 놓인 바이러스 중 M개를 활성 바이러스, 나머지를 비활성 바이러스로 조합해 바이러스를 퍼뜨린다.
 * 모든 칸에 바이러스를 퍼뜨리는 최소 시간을 구해라 (비활성 바이러스 제외, 벽 제외)
 * 
 * 0은 빈칸, 1은 벽, 2는 바이러스의 위치
 * @author chaeu
 *
 */
public class chan_17142 {

	static class Location {
		int x; int y;
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, M, virusCnt, ans, totalEmpty;
	static int[][] lab;
	static ArrayList<Location> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 연구소의 크기
		M = Integer.parseInt(st.nextToken());	// 놓을 수 있는 바이러스의 개수
		lab = new int[N][N];	// 연구소 정보
		list = new ArrayList<>();	// 바이러스 위치를 담을 리스트
		active = new Location[M];	// 활성화된 바이러스를 담을 Location 배열
		virusCnt = 0;	// 총 바이러스의 개수
		totalEmpty = 0;	// 퍼뜨려야 하는 총 빈 칸 수
		ans = N * N;	// 시간을 최대로 설정
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j] == 2) {	// 바이러스일 때 
					list.add(new Location(i, j));	// 리스트에 추가
					virusCnt++;	// 개수 세기
				} else if (lab[i][j] == 0) {	// 빈 칸일 때
					totalEmpty++;	// 퍼뜨려야 하는 칸 수를 세기
				}
			}
		}	// 입력받기 완료

		if (totalEmpty == 0) // 빈 칸이 없을 때
			System.out.println(0);
		else {
			select(0, 0);
			
			if (ans == N * N) // 모든 빈 칸에 바이러스를 퍼뜨릴 수 없는 경우
				System.out.println(-1);
			else System.out.println(ans);
		}
	}
	
	static Location[] active;
	// 총 놓인 바이러스 중 M개를 선택하는 조합
	private static void select(int start, int cnt) {
		// 기저조건
		if (cnt == M) {
			ans = Math.min(ans, bfs(active));
			return;
		}
		// 조합으로 처음 바이러스 개수에서 M개 활성화 바이러스로 뽑기
		for (int i = start; i < list.size(); i++) {
			active[cnt] = list.get(i);
			select(i + 1, cnt + 1);
		}
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	// 선택된 조합의 경우에서 바이러스를 퍼뜨리는 최소 시간 bfs
	private static int bfs(Location[] active) {
		Queue<Location> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		int time = 0;
		int empNum = totalEmpty;
		for (int i = 0; i < M; i++) {
			queue.offer(active[i]);
			visited[active[i].x][active[i].y] = true;
		}
		int num = queue.size();
		
		while(!queue.isEmpty()) {
			for (int i = 0; i < num; i++) {
				Location current = queue.poll();
				int curX = current.x;
				int curY = current.y;
				for (int d = 0; d < 4; d++) {
					int nx = dx[d] + curX;
					int ny = dy[d] + curY;
					// 범위 체크
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					// 방문 체크 (바이러스가 이미 퍼진 칸인지)
					if (visited[nx][ny]) continue;
					// 벽이면 바이러스 퍼지지 않음
					if (lab[nx][ny] == 1) continue;
					// 비활성 상태 바이러스일 때
					if (lab[nx][ny] == 2) {
						empNum++;
					}
					empNum--;	// 비활성화 바이러스를 지날 때는 시간은 흐르지만, 빈 칸 수가 줄어들진 않음
					queue.offer(new Location(nx, ny));
					visited[nx][ny] = true;
				}
			}
			num = queue.size();	// 다음 1초동안 돌아야할 큐의 수 
			time++;	// 1초 증가
			
			if (queue.size() != 0) {	// 큐가 비어있지 않은데
				if (empNum == 0) {		// 빈 칸은 다 찼을 때 (=> 비활성화 바이러스만 큐에 남음)
					return time;	
				}
			}
			else {					// 큐가 비어있는데 
				if (empNum == 0) {	// 남은 빈 칸도 없을 때
					return time;
				}
			}
		}
		
		// 모든 빈 칸에 바이러스를 퍼뜨릴 수 없는 경우
		if (totalEmpty != 0) {
			return N * N;
		}
		
		return time;
	}
}
