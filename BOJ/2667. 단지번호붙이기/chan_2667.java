import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class chan_2667 {
	static int totalComplex = 0;	// 총 단지 수
	static int N;	// 지도의 크기
	static int[][] map; // 지도
	static int count;
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] data = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(data[j]);
			}
		}	// 입력받기완료
		
		boolean[][] visited = new boolean[N][N];	// 지도의 각 집 방문 체크할 배열
		ArrayList<Integer> list = new ArrayList<>();	// 단지내 집 수를 저장할 리스트
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				count = 1;	// 단지내 집의 수 1로 초기화
				// 방문하지 않은 곳 중 1인 곳(집)을 만나면 dfs 탐색
				if (map[i][j] == 1 && !visited[i][j]) {
					dfs(i, j, visited);
					list.add(count);
				}
			}
		}
		
		// 출력
		System.out.println(list.size());
		Collections.sort(list);	// 단지내 집의 수를 오름차순 정렬
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	// dfs
	private static void dfs(int i, int j, boolean[][] visited) {
		visited[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			// 범위 체크, 방문 체크, 집이 아닌지 체크
			if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] == 0) continue;
			count++;	// 집의 수 세기
			dfs(nx, ny, visited);
		}
	}

}
