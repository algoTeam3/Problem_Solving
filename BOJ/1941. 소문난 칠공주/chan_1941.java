import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 요구사항 : 아래의 규칙을 만족시키는 '이다솜파'위주의 소문난 칠공주를 결성해라
 * - 규칙 
 *   - 1. 7명이어야함
 *   - 2. 7명의 자리는 가로나 세로로 반드시 인접해야함
 *   - 3. 7명의 학생 중 '이다솜파'가 적어도 4명 이상은 반드시 포함되어야함
 * 
 * 문제 제시 조건
 * - 5 X 5 형태의 자리에 총 25명의 여학생으로 구성
 * 
 * 입력 : 'S'(이다솜파) 또는 'Y'(임도연파)을 값으로 갖는 5*5 행렬이 다섯 줄에 걸쳐 주어짐
 * 출력 : '소문난 칠공주'를 결성할 수 있는 모든 경우의 수
 * 
 * @author chaeu
 *
 */
public class chan_1941 {
	static char[][] seat;
	static Student[] princess;
	static int ans, R;
	static Student[] linearStudent;
	static boolean[][] selected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		seat = new char[5][5];
		ans = 0;	// 경우의 수
		R = 7; 	// 소문난 칠공주
		linearStudent = new Student[25];
		princess = new Student[7];
		
		int idx = 0;
		for (int i = 0; i < 5; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < 5; j++) {
				seat[i][j] = input[j];
				linearStudent[idx++] = new Student(i, j, seat[i][j]);
			}
		}
		comb(0, 0);
		
		System.out.println(ans);
	}
	
	// 조합으로 25명 중 7명 뽑기
	private static void comb(int start, int cnt) {
		if (cnt == R) {
			// 이다솜파가 4명 이상인지 체크
			if (checkCondition(princess)) {
				// 7명이 모두 인접해있는지 bfs로 체크
				if (checkBfs(princess)) {
					ans++;	// 경우의 수 증가
				}
			}
			return;
		}
		
		for (int i = start; i < 25; i++) {
			princess[cnt] = linearStudent[i];
			comb(i + 1, cnt + 1);
		}
	}

	private static boolean checkCondition(Student[] princess) {
		// 4명 이상이 이다솜파인지
		int cnt = 0;
		for (int i = 0; i < 7; i++) {
			if (princess[i].pa == 'Y') cnt++;
			if (cnt >= 4) return false;	// 임도연파가 4명 이상되면 결성 불가
		}
		return true;
	}
	
	// 7명이 인접해있는지 bfs로 확인
	private static boolean checkBfs(Student[] princess) {
		selected = new boolean[5][5];
		for (int i = 0; i < 7; i++) {
			selected[princess[i].x][princess[i].y] = true;	// 선택된 7명의 selected 값을 true로 변경
		}
		// 시작점을 뽑은 7명 중 첫번째 요소로 한다.
		if (!bfs(princess[0].x, princess[0].y)) {
			return false;
		}
		
		// 이다솜파 우위의 소문난 칠공주가 결성된 경우
		return true;
	}

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	private static boolean bfs(int tempX, int tempY) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[5][5];
		
		// 선택된 7개의 위치 중 첫번째 (princess[0]) 위치부터 시작
		queue.offer(new int[] {tempX, tempY});
		visited[tempX][tempY] = true;
		int cnt = 1;	// 7명 중 첫번째부터 시작하므로 1 카운트하고 시작
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			// 사방탐색
			for (int d = 0; d < 4; d++) {
				int nx = current[0] + dx[d];
				int ny = current[1] + dy[d];
				// 범위 체크
				if (nx < 0 || ny < 0 || nx > 4 || ny > 4) continue;
				// 방문 체크
				if (visited[nx][ny]) continue;
				// 선택된 7명인지 체크
				if (!selected[nx][ny]) continue;
				// 칠공주 인원 중 한명이면 이동(인접 체크)
				queue.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
				cnt++;	
			}
		}
		// 이동해서 7명이 되면 조건을 만족
		if (cnt == 7) return true;
		else return false;
	}
	
	static class Student {
		int x; int y; char pa;
		public Student(int x, int y, char pa) {
			this.x = x;
			this.y = y;
			this.pa = pa;
		}
	}
}
