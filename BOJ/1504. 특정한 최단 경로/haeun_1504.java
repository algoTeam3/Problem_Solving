import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1504_특정한최단경로 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());		// 정점의 개수
		int E = Integer.parseInt(st.nextToken()); 		// 간선의 개수
		int INF = 99999999;
		
		// 본인을 제외한 나머지 경로 최댓값으로 설정
		int[][] distance = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) distance[i][j] = 0;
				else distance[i][j] = INF;
			}
		}
		
		// 경로
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());	// a정점에서
			int b = Integer.parseInt(st.nextToken());	// b정점까지
			int c = Integer.parseInt(st.nextToken());	// 거리
			distance[a][b] = distance[b][a] = c;
		}
		
		// 꼭 거쳐야하는 정점
		st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		// 플로이드워샬
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
				}
			}
		}
		
		// 최단 경로의 길이
		int result = Math.min(distance[1][x] + distance[x][y] + distance[y][N], distance[1][y] + distance[y][x] + distance[x][N]);
		if (result >= INF) result = -1;
		
		// 출력
		System.out.println(result);
	}
}
