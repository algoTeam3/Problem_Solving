import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_D3_1216_회문2 {
	private static int max;
	private static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());	// 테스트케이스
			max = Integer.MIN_VALUE;					// 가장 긴 회문의 길이
			board = new int[100][100];
			
			// 글자판 채우기
			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				for (int j = 0; j < 100; j++) {
					board[i][j] = str.charAt(j);
				}
			}
			
			// 시작위치
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					solve(i, j);
				}
			}
			
			// 출력
			System.out.printf("#%d %d\n", T, max);
		}
	}
	
	private static void solve(int x, int y) {
		int cnt = 0;									// 맞아야하는 철자의 개수
		int num = 0;									// 회문의 길이
		
		// 세로 탐색
		for (int i = x+1; i < 100; i++) {
			num = i - x + 1;
			cnt = num/2;
			int temp = 0;
			// 왼-오 철자 비교
			while (temp != num/2) {
				if (board[x+temp][y] == board[i-temp][y]) cnt--;
				temp++;
			}
			// 만일 회문이라면, max값 저장
			if (cnt == 0) max = num > max ? num : max;
		}
		
		// 가로 탐색
		for (int j = y+1; j < 100; j++) {
			num = j - y + 1;
			cnt = num/2;
			int temp = 0;
			// 왼-오 철자 비교
			while (temp != num/2) {
				if (board[x][y+temp] == board[x][j-temp]) cnt--;
				temp++;
			}
			// 만일 회문이라면, max값 저장
			if (cnt == 0) max = num > max ? num : max;
		}
	}
}
