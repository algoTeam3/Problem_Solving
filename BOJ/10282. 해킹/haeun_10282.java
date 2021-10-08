import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10282_해킹 {
	
	public static class Node implements Comparable<Node> {
		int end, value;		// 연결된 컴퓨터, 걸리는 시간

		public Node(int end, int value) {
			super();
			this.end = end;
			this.value = value;
		}

		// 오름차순
		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
	}
	
	public static int n;
	public static int[] computer;
	public static ArrayList<Node>[] list;
	public static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());			// 테스트케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());			// 컴퓨터 개수
			int d = Integer.parseInt(st.nextToken());		// 의존성 개수
			int c = Integer.parseInt(st.nextToken());		// 해킹당한 컴퓨터의 번호
			
			computer = new int[n+1];
			Arrays.fill(computer, INF);
			list = new ArrayList[n+1];
			for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
			
			// 의존 관계
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());	// 컴퓨터 a가
				int b = Integer.parseInt(st.nextToken());	// 컴퓨터 b를 의존
				int s = Integer.parseInt(st.nextToken());	// b감염 s초 후 a감염
				list[b].add(new Node(a, s));
			}
			
			dijkstra(c);
			
			int cnt = 0;	// 총 감염되는 컴퓨터 수
			int time = 0;	// 마지막 컴퓨터가 감염되기까지 걸리는 시간
			
			for (int i = 1; i <= n; i++) {
				// 감염되는 컴퓨터가 있다면
				if (computer[i] != INF) {
					cnt++;
					// 소요시간 최댓값 갱신
					time = Math.max(time, computer[i]);
				}
			}
			
			// 출력
			System.out.println(cnt + " " + time);
		}
	}
	
	// 다익스트라
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n+1];
		pq.offer(new Node(start, 0));
		computer[start] = 0;
		
		while (!pq.isEmpty()) {
			int num = pq.poll().end;
			if (visited[num]) continue;
			visited[num] = true;
			
			for (Node next : list[num]) {
				if (computer[next.end] > computer[num] + next.value) {
					computer[next.end] = computer[num] + next.value;
					pq.offer(new Node(next.end, computer[next.end]));
				}
			}
		}
	}
}
