import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chan {
	static int N, L, answer;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 지도 한 변의 길이
		L = Integer.parseInt(st.nextToken());	// 경사로의 길이
		answer = 0;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력받기 완료
		
		// 가로 길 탐색
		for (int i = 0; i < N; i++) {
			int beforeHeight = 0;
			int sameHeightCnt = 1;
			int j = 0;
			for (j = 0; j < N; j++) {
				if (beforeHeight == 0) { 	// 길의 첫번째 칸이면 다음 칸 탐색하러 가기
					beforeHeight = map[i][j];
					continue;
				}
				
				if (beforeHeight == map[i][j]) { 	// 현재 칸의 높이가 이전 높이와 같을 때
					sameHeightCnt++;
					continue;
				}
				
				if (beforeHeight < map[i][j]) { 	// 현재 칸의 높이가 이전 높이보다 클 때
					if (map[i][j] - beforeHeight != 1 || sameHeightCnt < L) {	// 경사로를 놓을 수 없을 때 다음 길 탐색
						break;
					} else {
						beforeHeight = map[i][j];
						sameHeightCnt = 1;
						continue;
					}
				}
				if (beforeHeight > map[i][j]) { 	// 현재 칸의 높이가 이전 높이보다 작을 때
					if (beforeHeight - map[i][j] != 1) {	// 높이 차 조건 불만족으로 경사로를 놓을 수 없을 때 다음 길 탐색
						break;
					} else {	
						if (check(i, j)) {	// 경사로를 놓을 수 있을 때
							j = j + L - 1;
							beforeHeight = map[i][j];
							sameHeightCnt = 0;
							continue;
						} else {	// 경사로를 놓을 수 없을 때
							break;
						}
					}
				}
			}
			if (j == N) answer++;
		}
		// 세로 길 탐색
		for (int i = 0; i < N; i++) {
			int beforeHeight = 0;
			int sameHeightCnt = 1;
			int j = 0;
			for (j = 0; j < N; j++) {
				if (beforeHeight == 0) { 	// 길의 첫번째 칸이면 다음 칸 탐색하러 가기
					beforeHeight = map[j][i];
					continue;
				}
				
				if (beforeHeight == map[j][i]) { 	// 현재 칸의 높이가 이전 높이와 같을 때
					sameHeightCnt++;
					continue;
				}
				
				if (beforeHeight < map[j][i]) { 	// 현재 칸의 높이가 이전 높이보다 클 때
					if (map[j][i] - beforeHeight != 1 || sameHeightCnt < L) {	// 경사로를 놓을 수 없을 때 다음 길 탐색
						break;
					} else {
						beforeHeight = map[j][i];
						sameHeightCnt = 1;
						continue;
					}
				}
				if (beforeHeight > map[j][i]) { 	// 현재 칸의 높이가 이전 높이보다 작을 때
					if (beforeHeight - map[j][i] != 1) {	// 높이 차 조건 불만족으로 경사로를 놓을 수 없을 때 다음 길 탐색
						break;
					} else {	
						if (check2(j, i)) {	// 경사로를 놓을 수 있을 때
							j = j + L - 1;
							beforeHeight = map[j][i];
							sameHeightCnt = 0;
							continue;
						} else {	// 경사로를 놓을 수 없을 때
							break;
						}
					}
				}
			}
			if (j == N) answer++;
		}
		System.out.println(answer);
	}
	private static boolean check(int i, int j) {
		int height = 0;
		for (int k = j; k < j + L; k++) {
			if (k >= N) return false;
			if (height == 0) {
				height = map[i][k];
				continue;
			}
			if (map[i][k] != height) return false;
		
		}
		return true;
	}
	private static boolean check2(int j, int i) {
		int height = 0;
		for (int k = j; k < j + L; k++) {
			if (k >= N) return false;
			if (height == 0) {
				height = map[k][i];
				continue;
			}
			if (map[k][i] != height) return false;
			
		}
		return true;
	}
}
