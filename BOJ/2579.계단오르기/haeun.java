import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579_계단오르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 계단의 개수
		int[] score = new int[N+1];					// 점수
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		// dp
		dp[0] = score[0];
		dp[1] = dp[0] + score[1];
		if (N >= 2)	dp[2] = dp[1] + score[2];
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + score[i-1]) + score[i];
		}
		
		// 출력
		System.out.println(dp[N]);
	}
}
