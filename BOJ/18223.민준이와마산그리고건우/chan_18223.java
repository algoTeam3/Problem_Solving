import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 요구사항 : 민준이가 1번에서 V번까지 갈 수 있는 최단 경로 상에서 건우를 만날 수 있는지 구해라
 * 
 * 최단 경로 중 특정 정점을 거치는지 확인하는 과정 필요
 * - 1->V까지의 최단 경로 == 1->P + P->V
 * - 
 * @author chaeu
 *
 */
public class BOJ_18223_민준이와마산그리고건우 {
	static class Node implements Comparable<Node> {
		int vertex;
		int cost;
		public Node(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static int V, E, P;	
	static final int INFINITY = 987654231;
	static ArrayList<Node>[] list;
	static int[] path;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());	// 정점의 개수
		E = Integer.parseInt(st.nextToken());	// 간선의 개수
		P = Integer.parseInt(st.nextToken());	// 건우가 있는 정점
		path = new int[V + 1];
		list = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		
		if (dijkstra(1, V) == dijkstra(1, P) + dijkstra(P, V)) {
			System.out.println("SAVE HIM");
		} else {
			System.out.println("GOOD BYE");
		}
	}
	
	private static int dijkstra(int start, int end) {
		boolean[] visited = new boolean[V + 1];
		int[] distance = new int[V + 1];
		
		Arrays.fill(distance, INFINITY);
		distance[start] = 0;
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0));
		
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			int curV = current.vertex;
			if (visited[curV]) continue;
			visited[curV] = true;
			
			for (int i = 0; i < list[curV].size(); i++) {
				Node next = list[curV].get(i);
				int nextV = next.vertex;
				int nextC = next.cost;
				if (distance[nextV] >= distance[curV] + nextC) {
					distance[nextV] = distance[curV] + nextC;
					queue.offer(new Node(nextV, distance[nextV]));
				}
			}
		}
		return distance[end];	
	}

}
