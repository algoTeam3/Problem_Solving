import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 요구사항 : N개의 마을에서 학생 한 명씩 X마을까지 파티에 올 때, 가장 많은 시간이 걸리는 마을의 번호를 구해라
 * - 주어지는 도로는 단방향
 * 
 * 입력 : 학생의 수 N, 단방향 도로의 총 수 M, 파티가 열리는 마을의 번호 X
 * 		M개의 줄 ~ i번째 도로의 시작점 s, 끝점 e, 소요시간 T
 * 제약 : 1 <= X <= N
 * 		1 <= T <= 100
 * 		1 <= N <= 1,000 
 * 		1 <= M <= 10,000
 * 출력 : N명의 학생 중 가장 오래 걸리는 학생의 소요시간
 * 
 * @author chaeu
 *
 */
public class chan_1238 {
	static class Node implements Comparable<Node> {
		int vertex;
		int cost;
		public Node(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// 학생(혹은 마을)의 수
		int M = Integer.parseInt(st.nextToken());	// 단방향 도로의 개수
		int X = Integer.parseInt(st.nextToken());	// 파티가 열리는 마을 번호
		
		int[] eachTime = new int[N + 1];	// 학생별 최단시간
		ArrayList<Node>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, time));	// 단방향 도로
		}
		
		// 각 마을의 학생별로 X까지의 최단거리 구하기
		for (int s = 1; s <= N; s++) {
			final int INFINITY = 987654321;
			int[] distance = new int[N + 1];
			boolean[] visited = new boolean[N + 1]; 
			
			Arrays.fill(distance, INFINITY);
			distance[s] = 0;
			
			PriorityQueue<Node> queue = new PriorityQueue<>();
			queue.offer(new Node(s, 0));
			
			while (!queue.isEmpty()) {
				Node current = queue.poll();
				int currentVertex = current.vertex;
				
				if (visited[currentVertex]) continue;
				visited[currentVertex] = true;
				
				for (int i = 0; i < list[currentVertex].size(); i++) {
					Node next = list[currentVertex].get(i);
					int nextVertex = next.vertex;
					int nextCost = next.cost;
					if (distance[nextVertex] > distance[currentVertex] + nextCost) {
						distance[nextVertex] = distance[currentVertex] + nextCost;
						queue.offer(new Node(nextVertex, distance[nextVertex]));
					}
				}
			}
			// 파티 지점에서 다시 집으로 돌아가는 길 구하기(파티장에서 각 정점까지 최단거리)
			if (s == X) {
				for (int i = 1; i <= N; i++) {
					eachTime[i] += distance[i];
				}
			}
			// 파티 지점까지 최단 거리 더하기
			eachTime[s] += distance[X];
		}
		 
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			ans = (ans < eachTime[i]) ? eachTime[i] : ans;
		}
		System.out.println(ans);
		
	}

}
