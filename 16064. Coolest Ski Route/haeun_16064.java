import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16064_CoolestSkiRoute {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int INF = -123456789;
		int[][] map = new int[n+1][n+1];
		int max = Integer.MIN_VALUE;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) map[i][j] = 0;
				else map[i][j] = INF;
			}
		}
 		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[s][t] = Math.max(map[s][t], c);
		}
		
		// 플로이드와샬
		// 경유
		for (int k = 1; k <= n; k++) {
			// 출발
            for (int i = 1; i <= n; i++) {
            	// 도착
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.max(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
		
		// 최댓값 갱신
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (max < map[i][j]) max = map[i][j];
			}
		}
		
		// 출력
		System.out.println(max);
	}
}
