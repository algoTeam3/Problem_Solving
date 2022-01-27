import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 요구사항 : 각 나라의 인구수가 주어졌을 때, 인구 이동 방법에 따라 인구 이동이 며칠동안 발생하는지 구해라
 * - 인구 이동
 * 	- 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하일 때 국경선을 하루 연다.
 *  - 열려야 할 국경선이 모두 열렸다면 인구 이동을 시작한다.
 *  - 국경선이 열려있어 인접한 칸으로 이동 가능하다면 그 국가들을 연합이라고 한다.
 *  - 연합을 이루는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수) 이다. 소수점은 버린다.
 *  
 * 입력 
 * - 땅의 크기 N, 인구 차이 기준 L, R
 * - N개의 줄 ~ 각 나라의 인구수
 * 제약
 * - 1 <= N <= 50
 * - 1 <= L <= R <= 100
 * 0 <= A[r][c] <= 100
 * 출력 : 인구 이동이 며칠동안 발생하는지 일 수
 * @author chaeu
 *
 */
public class chan_16234 {
	static int N, L, R, ans;
	static int[][] map, temp;
	static boolean[][] visited;
	static boolean flag;
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	
		L = Integer.parseInt(st.nextToken());	
		R = Integer.parseInt(st.nextToken());	
		ans = 0;
		map = new int[N][N];
		temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (true) {
			cloneMap(); 	// 인구 이동 여부 확인을 위해 이전 인구 복사해놓기
			
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						bfs(i, j);
					}
				}
			}
			// 인구 이동이 일어났는지 검사
			if (!isChange()) break;
			ans++;
		}
		System.out.println(ans);
	}
	// 인구 이동 여부 검사 - 이전 인구와 비교
	private static boolean isChange() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (temp[i][j] != map[i][j]) return true;
			}
		}	
		return false;
	}
	// 이차원배열 복사
	private static void cloneMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = map[i][j];
			}
		}		
	}
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		LinkedList<int[]> list = new LinkedList<>();	// 국경선이 열린 연합 국가들의 좌표 저장
		queue.offer(new int[] {r, c});
		visited[r][c] = true;
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			list.add(new int[] {current[0], current[1]});
			for (int d = 0; d < 4; d++) {
				int nx = current[0] + dx[d];
				int ny = current[1] + dy[d];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if (visited[nx][ny]) continue;
				int diff = Math.abs(map[current[0]][current[1]] - map[nx][ny]);	// 
				if (diff >= L && diff <= R) {
					queue.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					
				}
			}
		}
		// 연합을 이루는 국가가 두 개 이상일 때 인구 이동 발생
		if (list.size() > 1) {
			movePopulation(list);
		}
	}
	// 리스트의 좌표들끼리 인구 이동
	private static void movePopulation(LinkedList<int[]> list) {
		int average = 0;
		// 연합 인구수 평균 구하기
		for (int i = 0; i < list.size(); i++) {
			int r = list.get(i)[0];
			int c = list.get(i)[1];
			average += map[r][c];
		}
		// 평균 인구수로 맞추기
		for (int i = 0; i < list.size(); i++) {
			int r = list.get(i)[0];
			int c = list.get(i)[1];
			map[r][c] = average / list.size();
		}
	}
}

