
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class chan {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 총 10개의 테스트 케이스
		for (int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			int sum = 0;
			int MAX_VALUE = Integer.MIN_VALUE;
			int[][] twoDimArr = new int[100][100];
			String[] data;
			// 한 테스트 케이스의 2차원 배열 입력 받기
			for (int i = 0; i < 100; i++) {
				data = br.readLine().split(" ");
				for (int j = 0; j < 100; j++) {
					twoDimArr[i][j] = Integer.parseInt(data[j]);
				}
			}
			
			// 각 행의 합 중에 최댓값
			for (int[] row : twoDimArr) {
				for (int r : row) {
					sum += r;
				}
				if (sum > MAX_VALUE) {
					MAX_VALUE = sum;
				}
				sum = 0;
			}
			
			// 각 열의 합 과 각 행의 합 중에 최댓값
			for (int j = 0; j < 100; j++) {
				for (int i = 0; i < 100; i++) {
					sum += twoDimArr[i][j];
				}
				if (sum > MAX_VALUE) {
					MAX_VALUE = sum;
				}
				sum = 0;
			}
			
			// 우하향 대각선 합 포함 최댓값
			for (int i = 0; i < 100; i++) {
				sum += twoDimArr[i][i];
			}
			if (sum > MAX_VALUE) {
				MAX_VALUE = sum;
			}
			sum = 0;
			
			// 우상향 대각선 합 포함 최댓값
			for (int i = 99; i >= 0; i--) {
				sum += twoDimArr[i][99-i];
			}
			if (sum > MAX_VALUE) {
				MAX_VALUE = sum;
			}
			System.out.printf("#%d %d%n", tc, MAX_VALUE);
		}
	}

}

}
