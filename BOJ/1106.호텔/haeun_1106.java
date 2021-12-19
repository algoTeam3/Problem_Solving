import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1106_호텔 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int C = Integer.parseInt(st.nextToken());	      // 최소 C명
		int N = Integer.parseInt(st.nextToken());	      // 도시의 개수
		int INF = 987654321;
		
		int[] dp = new int[C+101]; // 최소 비용
		Arrays.fill(dp, INF);
		dp[0] = 0;
		
		// dp
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cost = Integer.parseInt(st.nextToken());	// 홍보비용
			int customer = Integer.parseInt(st.nextToken());// 얻을 수 있는 고객의 수
			
			for (int j = customer; j < C + 101; j++) {
				dp[j] = Math.min(dp[j], cost + dp[j - customer]);
			}
		}

		// 최솟값 갱신
		int answer = INF;
		for (int i = C; i < C + 101; i++) {
			answer = Math.min(answer, dp[i]);
		}
		
		// 출력
		System.out.println(answer);
	}
}
