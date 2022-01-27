import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 요구사항 : 폭탄을 설치해놓은 초기 상태가 주어졌을 때, N초가 흐른 후의 격자판 상태를 출력해라
 * 	- 0초 : 처음 주어진 상태
 * 	- 1초 : 봄버맨은 아무것도 안 함
 * 	- 2초 : 폭탄이 없는 모든 칸에 폭탄 설치
 * 	- 3초 : 3초 전에 설치된 폭탄이 모두 폭발
 * 
 * - 폭탄이 폭발될 때에는 인접한 네 칸도 함께 파괴됨
 * 
 * 풀이 과정
 * - 1초를 제외한 홀수초일 때는 2초 전의 격자판 상태에서 폭탄과 인접한 4칸을 제외한 나머지부분에 폭탄 설치
 * - 짝수초일 때는 모든 칸에 폭탄 설치
 * - 단, N==1이면 바로 출력해주기
 * @author chaeu
 *
 */
public class chan_16918 {
	static int R, C, N;
	static char[][] map;
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		} // 입력받기 완료
		
		if (N == 1) {	// 초기 상태 출력
			printBomb();
		} else if (N % 2 == 0) {	// 짝수일 때는 모든 지역에 폭탄 설치된 상태 출력
			printAllBomb();
		} else if (N % 4 == 3) {
			installBomb(); 
			printBomb();
		} else {
			installBomb(); 
			installBomb(); 
			printBomb();
		} 
	}
	
	// 격자판 상태 출력
	private static void printBomb() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
	}
	// 모든 지역에 폭탄이 설치된 격차판 출력
	private static void printAllBomb() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print('O');
			}
			System.out.println();
		}
	}

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	// 폭탄 설치
	private static void installBomb() {
		boolean[][] isBomb = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 'O') {
					isBomb[r][c] = true;
					for (int d = 0; d < 4; d++) {
						int nx = r + dx[d];
						int ny = c + dy[d];
						if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
						isBomb[nx][ny] = true;
					}
				}
			}
		}
		// 격자판 상태 바꿔주기
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (isBomb[r][c]) {
					map[r][c] = '.';
				} else {
					map[r][c] = 'O';
				}
			}
		}
	}

}

