import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 요구사항 : 계단에 쓰여있는 점수가 주어질 때, 조건에 맞게 얻을 수 있는 총 점수의 최댓값을 구해라
 * 조건
 * - 1. 연속된 세 개의 계단을 모두 밟으면 안 된다.
 * - 2. 마지막 도착 계단은 반드시 밟아야한다.
 * 
 * 점화식 구하기
 * - 연속 세 개를 밟으면 안되니, 
 * - 현재 계단에서의 dp[i]는 
 * - 1) i-2번째 계단을 밟고, i번째를 밟을 때와, (dp[i - 2] + arr[i])
 * - 2) i-2번째 계단을 밟지 않고 i-1번째 계단을 밟고 i번째 계단을 밟는 (dp[i - 3] + arr[i - 1] + arr[i])
 * - 두 가지 방법 중 더 큰 값이 dp의 값이 된다.
 * 
 * 주의사항 : N이 2일 때 조건을 잘 맞춰주어야함
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 0;
		dp[1] = arr[1];
		
		if (N > 1)
			dp[2] = arr[1] + arr[2];
		
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
		}
		System.out.println(dp[N]);
	}

}
