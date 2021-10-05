import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2665_미로만들기 {
	
	public static int n;
	public static int[][] room, check;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());		// n*n
		room = new int[n][n];
		check = new int[n][n];
		for (int i = 0; i < n; i++) Arrays.fill(check[i], Integer.MAX_VALUE);
		check[0][0] = 0;
		
		// 방채우기
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				room[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs();
		// 출력
		System.out.println(check[n-1][n-1]);
	}

	// bfs
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0});
		
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			// 4방 탐색
			for (int d = 0; d < 4; d++) {
				int nx = temp[0] + dx[d];
				int ny = temp[1] + dy[d];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
				
				int val = check[temp[0]][temp[1]];
				// 검은방이면 + 1
				int next = room[nx][ny] == 0 ? val + 1 : val;
				// 최솟값 갱신
				if (next < check[nx][ny]) {
					check[nx][ny] = next;
					queue.add(new int[] {nx,ny});
				}
			}
		}
	}
}
