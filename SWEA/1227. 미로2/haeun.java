import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	// 4방탐색
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	public static char map[][];
	public static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());	// 테스트케이스 번호
			map = new char[100][100];					        // 미로
			result = 0;									              // 유효성 판단
			// 미로
			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				map[i] = str.toCharArray();
			}
			// 출발지점
			bfs(1, 1);
			// 출력
			System.out.printf("#%d %d\n", tc, result);
		}
	}
	
	//bfs
	public static void bfs(int x, int y) {
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		// 출발지점
		Integer[] pos = {x, y};
		queue.offer(pos);
		map[x][y] = '1';
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Integer[] current = queue.poll();
				// 4방탐색
				for (int d = 0; d < 4; d++) {
					int nx = current[0] + dx[d];
					int ny = current[1] + dy[d];
					// 길이 막혀있거나 범위를 벗어난다면 다음 값 탐색
					if (nx < 0 || ny < 0 || nx >= 100 || ny >= 100 || map[nx][ny] == '1') continue;
					// 도착지점에 도착했다면, 유효한 미로
					if (map[nx][ny] == '3') {
						result = 1;
						return;
					}
					// 탐색가능한 좌표 queue에 저장
					Integer[] temp = {nx, ny};
					queue.offer(temp);
					// 방문완료
					map[nx][ny] = '1';
				}
			}
		}
	}
}
