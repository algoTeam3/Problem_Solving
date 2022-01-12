import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요구사항 : 빙산이 1년마다 사방에 붙어있는 0이 저장된 칸의 개수만큼 줄어들 때, 
 * 			주어진 한 덩어리의 빙산이 두 덩어리 이상으로 분리되는 최초의 시간(년)을 구해라
 * 입력 : 행의 개수 N, 열의 개수 M
 * 		N개 줄 ~ M개의 정수
 * 제약 : 3 <= N, M <= 300
 * 		0 <= 빙산의 높이 <= 10
 * 		빙산이 차지하는 칸의 개수 <= 10,000
 * 		배열의 첫번째 행, 열, 마지막 행, 열은 항상 0
 * 출력 : 빙산이 분리되는 최초의 시간(년)
 * 		(다 녹을 때 까지 분리되지 않으면 0)
 * @author chaeu
 *
 */
public class chan_2573 {
	static int N, M, chunk, year, ans;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		} // 입력받기 완료
		
		// 1년마다 반복
		year = 1;
		while (true) {
			// 1. 빙산이 있는 칸은 사방의 0의 개수를 빼서 새로운 2차원 배열에 저장하기
			meltingIceBerg();
			
			// 2. 빙산 덩어리 개수 dfs로 세기
			boolean[][] visited = new boolean[N][M];
			chunk = 0;
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (map[n][m] == 0) {	// 바다이면 방문처리만 하기
						visited[n][m] = true;
					}
					if (!visited[n][m]) {	// 방문하지 않은 빙산이면 dfs
						dfs(n, m, visited);
						chunk++;
					}
				}
			}
			
			// 덩어리 두 개 이상이면 끝
			if (chunk >= 2) {
				ans = year;
				break;
			} 
			
			// 빙산이 모두 다 녹았으면 끝
			if (chunk == 0) {
				ans = chunk;
				break;
			}
			
			// 한 주기가 끝나면 1년 증가
			year++;
		}
		
		System.out.println(ans);
	}
	
	private static void dfs(int n, int m, boolean[][] visited) {
		visited[n][m] = true;
		
		// 사방으로있는 빙산 탐색
		for (int d = 0; d < 4; d++) {
			int nx = n + dx[d];
			int ny = m + dy[d];
			// 범위 체크
			if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			// 빙산인지 체크
			if (map[nx][ny] == 0) continue;
			// 방문 체크
			if (visited[nx][ny]) continue;
			dfs(nx, ny, visited);
		}
	}

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	private static void meltingIceBerg() {
		int[][] temp = new int[N][M];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				// 빙산이면
				if (map[n][m] != 0) {
					// 사방에 있는 0의 개수 세기
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int nx = n + dx[d];
						int ny = m + dy[d];
						if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
						if (map[nx][ny] == 0) cnt++;
					}
					// 0 개수만큼 빙산 녹이기
					temp[n][m] = map[n][m] - cnt;
					if (temp[n][m] < 0) temp[n][m] = 0;
				}
				// 바다이면
				else {
					temp[n][m] = map[n][m];
				}
			}
		}
		
		// temp를 다시 map으로 복사
		cloneMap(temp);
	}
	
	private static void cloneMap(int[][] temp) {
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				map[n][m] = temp[n][m];
			}
		}
	}

}
