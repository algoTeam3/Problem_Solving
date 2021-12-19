import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14728_벼락치기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// 단원 개수
		int T = Integer.parseInt(st.nextToken());	// 공부할 수 있는 총 시간
		
		int[] K = new int[N+1];						// 단원별 예상 공부 시간
		int[] S = new int[N+1];						// 단원 문제의 배점
		int[][] dp = new int[N+1][T+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			K[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= T; j++) {
				// 해당 단원을 공부할 수 없다.
				if (K[i] > j) dp[i][j] = dp[i-1][j];
				// 해당 단원을 공부할 수 있다.
				else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-K[i]]+S[i]);
			}
		}
		
		// 출력
		System.out.println(dp[N][T]);
	}
}
