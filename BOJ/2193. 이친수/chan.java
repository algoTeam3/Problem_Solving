import java.util.Scanner;

/**
 * 요구사항 : N이 주어지면, N자리의 이친수의 개수를 구해라
 * 이진수 : 0과 1로만 이루어진 수
 * 이친수 : 아래 조건을 만족하는 이진수
 * - 조건1. 0으로 시작하지 않는다.
 * - 조건2. 1이 두번 연속 나타나지 않는다.
 *
 * 점화식 : dp[i] = dp[i - 1] + dp[i - 2]
 * - dp[i-2]의 이친수들에서 i-1번째가 0이 오는 이친수들만 i번째에 1이 올 수 있고, 
 * - dp[i-1]의 이친수들에서 0인지 1인지 상관없이 모두 i번째에 0이 올 수 있다고 봄
 * 
 * 주의 : dp 결과값이 int 범위를 넘어서기 때문에 long으로 해줘야함
 */
public class chan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[N + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];	// 점화식
		}
		
		System.out.println(dp[N]);
		
		sc.close();
	}

}
