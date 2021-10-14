import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10159_저울 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 물건의 개수
		int M = Integer.parseInt(br.readLine());	// 물건 쌍의 개수
		int[][] thing = new int[N+1][N+1];
		
		// 미리 측정된 비교 결과
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			thing[a][b] = 1;						// a > b
			thing[b][a] = -1;						// b < a
		}
		
		// 플로이드와샬
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					// 큰 경우
					if (thing[i][k] == 1 && thing[k][j] == 1) {
						thing[i][j] = 1;
					}
					// 작은 경우
					else if (thing[i][k] == -1 && thing[k][j] == -1) {
						thing[i][j] = -1;
					}
				}
			}
		}
		
		// 출력
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				if (thing[i][j] != 0) {
					cnt++;
				}
			}
			// 자기자신 제외
			System.out.println(N-cnt-1);
		}
	}
}
