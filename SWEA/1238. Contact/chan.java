import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class chan {
	
	static int N, C, start, ans;
	static boolean[][] adjMatrix;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			C = Integer.parseInt(st.nextToken()) / 2;
			adjMatrix = new boolean[101][101];
			start = Integer.parseInt(st.nextToken());
			ans = 0;
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < C; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjMatrix[from][to] = true; 
			}
			bfs(start);
			System.out.println("#" + t + " " + ans);
		}
		
	}
	static int depthSize = 0, depth = 1;
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[101];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			depth = queue.size();
			ans = 0;
			while(depth-- > 0) {
				int current = queue.poll();
				for (int i = 0; i < 101; i++) {
					if (!visited[i]	&& adjMatrix[current][i]) { 
						queue.offer(i);	// 큐에 넣고 나중 순서 기다리기
						visited[i] = true;	// 큐에 넣은 애는 방문처리하기
						ans = Math.max(ans, i);
					}
				}
				ans = Math.max(current, ans);
			}

		}
	}

}
