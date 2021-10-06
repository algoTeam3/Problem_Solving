import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 요구사항 : 네트워크 상에서 한 사용자가 다른 모든 사람과 얼마나 가까운가를 나타내는 CC가 가장 짧은 사람의 CC를 구해라
 * 			( 각 정점에서 나머지 정점들로의 거리들의 합의 최솟값 )
 * 입력 : 총 테케 수 T
 * 		각 테케 ~ 사람 수 N, 사람 네트워크 인접행렬 행 우선으로 한줄에 입력됨
 * 출력 : 각 테케 별 사람들의 CC값 중 최솟값
 * @author chaeu
 *
 */
public class chan_1263 {

	static int N;
	static int[][] matrix;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 전체 테케 수
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			matrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}// 입력받기 완료
			System.out.println("#" + t + " " + solve());
		}
	}
	/**
	 * N개의 노드 별로 다익스트라를 이용해 모든 정점으로 가는 거리의 최솟값들의 합을 구하는 함수 호출
	 * @return N개의 노드가 가지는 CC값 중 최소값
	 */
	private static int solve() {
		int cc = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			cc = Math.min(cc, dijkstra(i));
		}
		return cc;
	}
	/**
	 * N개의 노드 별로 각 정점에서 다른 모든 정점으로 가는 거리의 합 구하는 함수
	 * @param 노드 번호
	 * @return 거리들의 합
	 */
	private static int dijkstra(int n) {
		boolean[] visited = new boolean[N];
		int[] dist = new int[N];
		Arrays.fill(dist, N + 1);
		dist[n] = 0;
		int min = 0, current = 0;
		for (int i = 0; i < N; i++) {
			min = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				if (!visited[j] && dist[j] < min) {
					current = j;
					min = dist[j];
				}
			}
			visited[current] = true;
			if (current == N - 1) break;
			for (int j = 0; j < N; j++) {
				if (visited[j]) continue; 
				if (matrix[current][j] == 0) continue;
				if (dist[j] > min + matrix[current][j])
					dist[j] = min + matrix[current][j];
			}
		}
		// n번 정점에서 다른 모든 정점으로의 거리 합 구하기
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += dist[i];
		}
		return sum;
	}

}
