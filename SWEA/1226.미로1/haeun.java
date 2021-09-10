import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_D4_1226_미로1 {
	// 4방탐색
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	public static char map[][];
	public static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());	// 테스트케이스 번호
			map = new char[16][16];						// 미로
			result = 0;									// 유효성 판단
			// 미로
			for (int i = 0; i < 16; i++) {
				String str = br.readLine();
				map[i] = str.toCharArray();
			}
			// 출발지점
			dfs(1, 1);
			// 출력
			System.out.printf("#%d %d\n", tc, result);
		}
	}
	
	public static void dfs(int x, int y) {
		// 4방탐색
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			// 길이 막혀있거나 범위를 벗어난다면 다음 값 탐색
			if (nx < 0 || ny < 0 || nx >= 16 || ny >= 16 || map[nx][ny] == '1') continue;
			// 도착지점에 도착했다면, 유효한 미로
			if (map[nx][ny] == '3') {
				result = 1;
				return;
			}
			// 방문완료
			map[nx][ny] = '1';
			dfs(nx, ny);
		}
	}
}
