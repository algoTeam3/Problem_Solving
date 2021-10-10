import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11404_플로이드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());		// n개의 도시
		int m = Integer.parseInt(br.readLine());		// 버스의 개수
		int INF = 10000000;
		
		// 최소비용
		int[][] distance = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) distance[i][j] = 0;
				else distance[i][j] = INF;
			}
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());	// 시작 도시
			int b = Integer.parseInt(st.nextToken());	// 도착 도시
			int c = Integer.parseInt(st.nextToken());	// 비용
			distance[a][b] = Math.min(distance[a][b], c);
		}
		
		// 플로이드와샬
		// 경유지
		for (int k = 1; k <= n; k++) {
			// 시작
            for (int i = 1; i <= n; i++) {
            	// 도착
                for (int j = 1; j <= n; j++) {
                	// 최솟값 갱신
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
                }
            }
        }
		
		// 출력
		for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
            	if (distance[i][j] >= INF) System.out.print(0 + " ");
            	else System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
	}
}
