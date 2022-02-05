import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] chessBoard;
	static int L, ans;
	static int[] start, end;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			L = Integer.parseInt(br.readLine());
			chessBoard = new int[L][L];
			
			String[] data = br.readLine().split(" ");
			start = new int[2];
			start[0] = Integer.parseInt(data[0]);
			start[1] = Integer.parseInt(data[1]);
			data = br.readLine().split(" ");
			end = new int[2];
			end[0] = Integer.parseInt(data[0]);
			end[1] = Integer.parseInt(data[1]);
			
			ans = bfs();
			System.out.println(ans);
		}
	}
	
	static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	private static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[L][L];

		queue.add(new int[] {start[0], start[1], 0});
		visited[start[0]][start[1]] = true;
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			if (current[0] == end[0] && current[1] == end[1]) {
				return current[2];
			}
			for (int d = 0; d < 8; d++) {
				int nx = dx[d] + current[0];
				int ny = dy[d] + current[1];
				
				if (nx < 0 || ny < 0 || nx >= L || ny >= L) continue;
				if (visited[nx][ny]) continue;
				queue.offer(new int[] {nx, ny, current[2] + 1});
				visited[nx][ny] = true;
			}
		}
		return 0;
	}
}
