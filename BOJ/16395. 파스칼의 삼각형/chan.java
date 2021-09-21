import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 요구사항 : 정수 N과 K가 주어졌을 때, 파스칼의 삼각형에 있는 N번째 행에서 K번째 수를 구해라
 * 제한 : 1 <= K <= N <= 30
 * 
 * 파스칼의 삼각형 
 * - 1. N번째 행에는 N개의 수가 있다.
 * - 2. 첫번째 행은 1이다.
 * - 3. 두번째 행부터 각 행의 양 끝의 값은 1이고, 나머지 수의 값은 바로 위 행의 인접한 두 수의 합이다.
 * 
 * 점화식
 * - dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
 * - 바로 위 행의 인접한 두 수의 합이 현재 행의 값이다.
 * - 조건 처리 : 각 행의 양 끝 값 1로 초기화하기
 *
 */
public class chan {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split(" ");
		int N = Integer.parseInt(data[0]);
		int K = Integer.parseInt(data[1]);
		int[][] dp = new int[31][31];
		
		dp[1][1] = dp[2][1] = dp[2][2] = 1;
		
		for (int i = 3; i <= N; i++) {
			dp[i][1] = dp[i][i] = 1;
			for (int j = 2; j < i; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		System.out.println(dp[N][K]);
	}

}
