import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2193_이친수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// N자리
		long[] memo = new long[N+1];				      // 값 저장
		memo[0] = 0;
		memo[1] = 1;
		
		// DP
		for (int i = 2; i <= N; i++) {
			if (memo[i] == 0) memo[i] = memo[i-2] + memo[i-1];
		}
		
		// 출력
		System.out.println(memo[N]);
	}
}
