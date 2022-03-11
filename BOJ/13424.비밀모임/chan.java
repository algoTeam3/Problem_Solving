import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class chan {

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
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			final int INF = 987654321;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	// 방의 개수
			int M = Integer.parseInt(st.nextToken());	// 통로의 개수
			
			ArrayList<Node>[] list = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());	
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				list[a].add(new Node(b, c));
				list[b].add(new Node(a, c));
			}
			
			int[] answer = new int[N + 1];
			int K = Integer.parseInt(br.readLine());	// 친구의 수
			st = new StringTokenizer(br.readLine(), " ");
			for(int k = 0; k < K; k++) {
				int[] distance = new int[N + 1];
				boolean[] visited = new boolean[N + 1];
				
				int start = Integer.parseInt(st.nextToken());	// 친구가 있는 방 번호
				
				Arrays.fill(distance, INF);
				distance[start] = 0;
				
				PriorityQueue<Node> queue = new PriorityQueue<>();
				queue.offer(new Node(start, 0));
				
				while(!queue.isEmpty()) {
					Node current = queue.poll();
					
					if (visited[current.vertex]) continue;
					visited[current.vertex] = true;
					
					for (int i = 0; i < list[current.vertex].size(); i++) {
						Node next = list[current.vertex].get(i);
						if (distance[next.vertex] > distance[current.vertex] + next.cost) {
							distance[next.vertex] = distance[current.vertex] + next.cost;
							queue.offer(new Node(next.vertex, distance[next.vertex]));
						}
					}
				}
				for (int n = 1; n <= N; n++) {
					answer[n] += distance[n];
				}
			}
			
			int min = INF;
			int room = 0;
			for (int n = 1; n <= N; n++) {
				if (min > answer[n]) {
					min = answer[n];
					room = n;
				}
			}
			
			System.out.println(room);
		}
		
	}

}
