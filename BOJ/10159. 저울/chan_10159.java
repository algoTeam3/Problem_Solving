import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chan_10159 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 물건의 개수
		int M = Integer.parseInt(br.readLine());	// 측정된 물건쌍의 개수
		int[][] matrix = new int[N + 1][N + 1];
		final int INF = 987654321;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) matrix[i][j] = 0;
				else matrix[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			matrix[a][b] = 1;
		}
		
		// 플로이드 와샬 (i보다 j가 더 무거운지 바로 비교할 수 없고, i보다 무거운 k 보다 j가 더 무거운지를 따질 수 있을 때 비교 가능하다!)
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				// i보다 j가 더 무겁진 않지만, j보다 i가 더 무겁다는 결과가 있으면, 비교 가능하므로 값을 넣어준다.
				if (matrix[j][i] != INF) matrix[i][j] = matrix[j][i];
				// 비교 불가능할 때 개수 세기
				if (matrix[i][j] == INF) cnt++;
			}
			System.out.println(cnt);
		}
	}

}
