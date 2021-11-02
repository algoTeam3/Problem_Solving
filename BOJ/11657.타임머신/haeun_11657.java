import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657_타임머신 {
	
	public static int N, M;
	public static long[] distance;
	public static ArrayList<Edge> list = new ArrayList<>();
	public static int INF = 123456789;
	
	public static class Edge {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());			// 도시의 개수
		M = Integer.parseInt(st.nextToken());			// 버스 노선의 개수
		
		distance = new long[N+1];
		Arrays.fill(distance, INF);						// 최댓값으로 설정
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());	// 출발
			int b = Integer.parseInt(st.nextToken());	// 도착
			int c = Integer.parseInt(st.nextToken());	// 걸리는 시간
			list.add(new Edge(a, b, c));
		}
		
		// 출력
		// 음수 사이클 존재, -1 출력
		if (bellmanford(1)) {
			System.out.println(-1);						
		} else {
			for (int i = 2; i <= N; i++) {
				// 도달 불가능
				if (distance[i] == INF) {
					System.out.println("-1");			
				}
				// 도달 가능
				else {
					System.out.println(distance[i]);
				}
			}
		}
	}
	
	// 벨만-포드
	public static boolean bellmanford(int begin){
		// 시작점
		distance[begin] = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int start = list.get(j).start;
				int end = list.get(j).end;
				int weight = list.get(j).weight;
						
				if (distance[start] == INF) continue;
				// 최단 거리 갱신
				if (distance[end] > distance[start] + weight) {
					distance[end] = distance[start] + weight;
							
					// 마지막 간선인데 값이 갱신된다면, 음수 사이클 존재
					if (i == N-1) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
