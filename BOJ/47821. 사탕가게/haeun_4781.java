import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4781_사탕가게 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		while (st.hasMoreTokens()) {
			int n = Integer.parseInt(st.nextToken());			        // 사탕 종류의 수
			int m = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);	// 가지고 있는 돈의 양
			
			// 종료조건
			if (n == 0 && m == 0) break;
			
			int[] c = new int[n];	// 칼로리
			int[] p = new int[n];	// 가격
			int[] dp = new int[m+1];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				c[i] = Integer.parseInt(st.nextToken());
				p[i] = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);
			}
			
			// dp
			for (int i = 0; i < n; i++) { 
				for (int j = 0; j <= m; j++) { 
					// 구매 가능
					if (j - p[i] >= 0) dp[j] = Math.max(dp[j], dp[j-p[i]] + c[i]);
				}
			}
	
			// 출력
			System.out.println(dp[m]);
			st = new StringTokenizer(br.readLine(), " ");
		}
	}
}
