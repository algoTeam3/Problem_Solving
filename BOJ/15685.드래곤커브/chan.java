import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class chan {

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		boolean[][] map = new boolean[101][101];
		for (int n = 0; n < N; n++) {
			ArrayList<Integer> rotate = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			// 0세대일 때
			map[x][y] = true;
			x += dx[d];
			y += dy[d];
			map[x][y] = true;
			rotate.add(d);
			
			// 1세대 이상일 때 반복문
			int curG = 1;
			while (curG <= g) {
				int size = rotate.size();
				for (int i = size - 1; i >= 0; i--) {
					d = (rotate.get(i) + 1) % 4;
					rotate.add(d);
					x += dx[d];
					y += dy[d];
					map[x][y] = true;
					
				}
				curG++;
			}
		}
		
		// 네 꼭짓점이 모두 드래곤 커브의 일부인지 확인
		for (int i = 0; i < map.length - 1; i++) {
			for (int j = 0; j < map.length - 1; j++) {
				if (map[i][j]) {
					if (map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1])
						answer++;
				}
			}
		}
		System.out.println(answer);
	}

}

