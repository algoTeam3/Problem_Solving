import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1956_운동 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());	// V개의 마을
		int E = Integer.parseInt(st.nextToken());	// E개의 도로
		int INF = 999999;
		int min = INF;								// 최소 사이클의 도로길이의 합
		
		// 최댓값으로 배열 채우기
		int[][] distance = new int[V+1][V+1];
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				distance[i][j] = INF;
			}
		}
		
		// 거리 입력 받기
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());	// a번 마을
			int b = Integer.parseInt(st.nextToken());	// b번 마을
			int c = Integer.parseInt(st.nextToken());	// c인 도로
			distance[a][b] = c;
		}
		
		// 플로이드와샬
		for (int k = 1; k <= V; k++) {
			// 시작
			for (int i = 1; i <= V; i++) {
				// 도착
				for (int j = 1; j <= V; j++) {
					if (distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
		
		// 최솟값 갱신
		for (int i = 1; i <= V; i++) {
			min = Math.min(distance[i][i], min);
		}
		
		// 출력
		if (min == INF) System.out.println(-1);
		else System.out.println(min);
	}
}
