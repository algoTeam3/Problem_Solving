import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chan_4781 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());	// 사탕 종류의 수
			int m = (int) Math.round(Float.parseFloat(st.nextToken()) * 100);	// 가진 돈의 양 (소수점 없애주기 위해 100 곱하기)
			
			if (n == 0 && m == 0) break;
			
			int[] c = new int[n + 1];	// 사탕의 칼로리
			int[] p = new int[n + 1];	// 사탕의 가격 (소수점 없애주기 위해 100 곱하기)
			
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				c[i] = Integer.parseInt(st.nextToken());
				p[i] = (int) Math.round(Float.parseFloat(st.nextToken()) * 100);
			}
			
			int[] D = new int[10001];
			
			for (int i = 1; i <= n; i++) {
				for (int j = p[i]; j <= m; j++) {
					D[j] = Math.max(D[j], c[i] + D[j - p[i]]);
				}
			}
			System.out.println(D[m]);
		}
	}

}
