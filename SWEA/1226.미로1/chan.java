import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

	static int[][] maze;
	static boolean[][] visited;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			ans = 0;	// 판단. 0 또는 1
			maze = new int[16][16];
			visited = new boolean[16][16];
			
			// 미로 입력받기
			for (int i = 0; i < 16; i++) {
				char[] data = br.readLine().toCharArray();
				for (int j = 0; j < 16; j++) {
					maze[i][j] = data[j] - '0';
				}
			}
			
			dfs(1, 1);
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	private static boolean dfs(int x, int y) {
		if (maze[x][y] == 3) {
			ans = 1; 
			return true;
		}
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if (nx < 1 || ny < 1 || nx > 16 || ny > 16 || visited[nx][ny] || maze[nx][ny] == 1) continue;
			
			visited[nx][ny] = true;
			if (dfs(nx, ny)) return true;
		}
		return false;
	}

}
