import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	
	public static int V, E, K;
	public static int[] distance;
	public static List<Node>[] list;
	public static final int INF = 987654321;
	
	// Node 클래스
	public static class Node implements Comparable<Node>{
		int end, weight;
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		// 오름차순
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());	// 정점의 개수
        E = Integer.parseInt(st.nextToken());	// 간선의 개수
        K = Integer.parseInt(br.readLine());	// 시작 정점의 번호
        
        distance = new int[V+1];				// 가중치
        list = new ArrayList[V+1];
        
        Arrays.fill(distance, INF);				// 최댓값으로 채우기
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
        
        for (int i = 0; i < E; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());	// 가중치
        	list[u].add(new Node(v, w));
        }
        
        dijkstra(K);
        
        // 출력
        for (int i = 1; i <= V; i++) {
        	System.out.println(distance[i] == INF ? "INF" : distance[i]);
        }
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		pq.add(new Node(start, 0));
		distance[start] = 0;
		
		while (!pq.isEmpty()) {
			Node temp = pq.poll();
			int n = temp.end;
			if (visited[n]) continue;
			visited[n] = true;
			
			for (Node node : list[n]) {
				if (distance[node.end] > distance[n] + node.weight) {
					distance[node.end] = distance[n] + node.weight;
					pq.add(new Node(node.end, distance[node.end]));
				}
			}
		}
	}
}
