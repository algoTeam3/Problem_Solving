import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());	// 물품의 수
		int K = Integer.parseInt(st.nextToken());	// 버틸 수 있는 무게
		
		int[] weight = new int[N+1];		        // 물건의 무게
		int[] value = new int[N+1];		        // 해당 물건의 가치
		int[][] dp = new int[N+1][K+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				// 해당 물건을 가방에 넣을 수 없다.
				if (weight[i] > j) dp[i][j] = dp[i-1][j];
				// 해당 물건을 가방에 넣을 수 있다.
				else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
			}
		}
		
		// 출력
		System.out.println(dp[N][K]);
	}
}
