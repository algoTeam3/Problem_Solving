import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_D3_1215_회문1 {
	private static int N, total;
	private static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());		// 찾아야 하는 회문의 길이
			board = new char[8][8];						// 글자판
			total = 0;									// 회문의 총 개수
			
			// 글자판 채우기
			for (int i = 0; i < 8; i++) {
				String str = br.readLine();
				for (int j = 0; j < 8; j++) {
					board[i][j] = str.charAt(j);
				}
			}
			
			// 회문 찾기
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					// 가로, 세로 둘다 구하기
					if (i <= 8-N && j <= 8-N) {
						solveCol(j, i);
						solveRow(i, j);
					}
					// 세로 구하기
					else if (i <= 8-N && j > 8-N) {
						solveCol(i, j);
					}
					// 가로 구하기
					else if (j <= 8-N && i > 8-N) {
						solveRow(i, j);
					}
				}
			}
			// 출력
			System.out.printf("#%d %d\n", tc, total);
		}
	}
	
	// 세로 구하기
	private static void solveCol(int x, int y) {
		int cnt = N/2;
		for (int i = 0; i < N/2; i++) {
			// 회문일 때
			if (board[x+i][y] == board[x+N-1-i][y]) cnt--;
		}
		if (cnt == 0) total++;
	}
	
	// 가로 구하기
	private static void solveRow(int x, int y) {
		int cnt = N/2;
		for (int i = 0; i < N/2; i++) {
			// 회문일 때
			if (board[x][y+i] == board[x][y+N-1-i]) cnt--;
		}
		if (cnt == 0) total++;
	}
}
