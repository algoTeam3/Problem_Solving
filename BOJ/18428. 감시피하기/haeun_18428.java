import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_18428_감시피하기 {
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int N;
	public static String result;
	public static String[][] map;
	public static ArrayList<int[]> teacher, empty;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// N*N
		map = new String[N][N];					// 복도
		teacher = new ArrayList<>();			// 선생님 좌표
		empty = new ArrayList<>();				// 비어있는 칸 좌표
		result = "NO";							// 결과
		
		// 복도
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken();
				if (map[i][j].equals("T")) teacher.add(new int[] {i, j});
				if (map[i][j].equals("X")) empty.add(new int[] {i, j});
			}
		}
		
		comb(0, 0);
		
		// 출력
		System.out.println(result);
	}
	
	// 조합
	public static void comb(int cnt, int start) {
		// 기저조건
		if (cnt == 3) {
			for (int[] temp : teacher) {
				if (!check(temp[0], temp[1])) return;
			}
			result = "YES";
			return;
		}
		
		for (int i = start; i < empty.size(); i++) {
			map[empty.get(i)[0]][empty.get(i)[1]] = "O";
			comb(cnt + 1, i + 1);
			map[empty.get(i)[0]][empty.get(i)[1]] = "X";
		}
	}
	
	// 선생님의 4방탐색
	public static boolean check(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x;
			int ny = y;
			while (true) {
				nx += dx[d];
				ny += dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny].equals("O")) break;
				if (map[nx][ny].equals("S")) return false;
			}
		}
		return true;
	}
}
