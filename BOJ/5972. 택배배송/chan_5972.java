import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class chan_5972 {
	static class Node implements Comparable<Node>{
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
		final int INFINITY = 987654321;
		int N = Integer.parseInt(st.nextToken());	// 헛간의 수
		int M = Integer.parseInt(st.nextToken());	// 소가 있는 양방향 길의 수
		
		int[] distance = new int[N + 1];
		boolean[] visited = new boolean[N + 1]; 

		ArrayList<Node>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list[x].add(new Node(y, z));
			list[y].add(new Node(x, z));
		}
		
		Arrays.fill(distance, INFINITY);
		distance[1] = 0;
		
		// 다익스트라
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(1, 0));
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			
			if (visited[current.vertex]) continue;
			visited[current.vertex] = true;
			
			for (int i = 0; i < list[current.vertex].size(); i++) {
				Node next = list[current.vertex].get(i);
				if(distance[next.vertex] > distance[current.vertex] + next.cost) {
					distance[next.vertex] = distance[current.vertex] + next.cost;
					queue.offer(new Node(next.vertex, distance[next.vertex]));
				}
			}
		}
		System.out.println(distance[N]);
	}

}
