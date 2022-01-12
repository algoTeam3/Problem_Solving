import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_2667_단지번호붙이기 {
	// 4방 탐색
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int N, total, cnt;
	public static char[][] map;
	public static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();	// 집의 수 저장
		
		N = Integer.parseInt(br.readLine());	// 지도의 크기
		map = new char[N][N];		        // 지도
		visited = new boolean[N][N];		// 방문체크
		for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();
		
		total = 0;		                // 총 단지수
		// 지도 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 새로운 단지 발견
				if (map[i][j] == '1' && !visited[i][j]) {
					cnt = 0;	// 단지에 속하는 집의 수
					dfs(i, j);
					total++;	// 단지 + 1
					stack.push(cnt);// cnt 값을 stack에 저장
				}
			}
		}
		
		// 집의 수를 home 배열에 저장
		int[] home = new int[total];
		int idx = 0;
		while (!stack.isEmpty()) home[idx++] = stack.pop();
		
		// 오름차순 정렬
		Arrays.sort(home);
		
		// 출력
		System.out.println(total);
		for (int num : home) System.out.println(num);
	}
	
	// dfs
	public static void dfs(int x, int y) {	
		// 방문체크
		visited[x][y] = true;
		// 집 + 1
		cnt++;
		
		// 4방 탐색
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			// 지도를 벗어나면 다음 값 탐색
			if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			// 집이 없거나, 방문했던 위치라면 다음 값 탐색
			if (map[nx][ny] == '0' || visited[nx][ny]) continue;
			
			// 다음 위치 탐색
			dfs(nx, ny);
		}
	}
}
