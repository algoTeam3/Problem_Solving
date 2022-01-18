import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 요구사항 : 한 집하장에서 다른 집하장으로 최단경로로 화물을 이동시키기 위해 
 * 			가장 먼저 거쳐야하는 집하장 정보를 담은 경로표를 구해라
 * 
 */
public class chan_1719 {
	static class Node implements Comparable<Node> {
		int vertex;
		int time;
		public Node(int vertex, int time) {
			this.vertex = vertex;
			this.time = time;
		}
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	}
	static StringBuilder sb = new StringBuilder();
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 집하장 수
		int M = Integer.parseInt(st.nextToken());	// 집하장간 경로의 개수
		int[] distance = new int[N + 1];
		int[] path = new int[N + 1];
		ArrayList<Node>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());	
			int b = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());	// a와 b 집하장 사이를 오가는데 필요한 시간
			list[a].add(new Node(b, time));
			list[b].add(new Node(a, time));
		}
		
		for (int s = 1; s <= N; s++) {
			final int INFINITY = 987654321;
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
					int nextTime = next.time;
					if (distance[nextVertex] > distance[currentVertex] + nextTime) {
						distance[nextVertex] = distance[currentVertex] + nextTime;
						// nextVertex로 가기 직전 방문 정점이 currentVertex
						path[nextVertex] = currentVertex;
						queue.offer(new Node(nextVertex, distance[nextVertex]));
					}
				}
			}
			trace(s, path);
		}
		System.out.println(sb.toString());
	}
	/* start 정점에서 다른 정점들까지 가는 최단경로 추적
	 예를들어 1->6 최단 경로를 추적한다면 path[6]=5, path[5]=2, path[2]=1 로, 
	 1->2->5->6 정점을 거쳐야 최단경로로 1번에서 6번까지 이동하는 방법이다. */
	private static void trace(int s, int[] path) {
		// start 정점에서 각 정점[v]까지 최단 경로 추적 
        for(int v = 1; v <= N; v++) {
            // 자기 자신인 경우
            if(v == s) {
                sb.append("-");
            } else {
            	int answer = 0;
            	for(int j = v; j != s; j = path[j]) {
            		// 가장 먼저 방문해야되는 정점이 되도록 갱신
            		answer = j;
            	}
            	sb.append(answer);            	
            }
            sb.append(" ");
        }
        sb.append("\n");
	}

}
