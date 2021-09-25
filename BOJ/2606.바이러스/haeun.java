import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	
	public static int N, M, cnt;
	public static int[][] arr;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());			// 컴퓨터의 수
		M = Integer.parseInt(br.readLine());			// 연결 선의 수
		arr = new int[N+1][N+1];						// 컴퓨터 연결 상태
		visited = new boolean[N+1];
		cnt = 0;										// 감염되는 컴퓨터의 수
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;					// 연결
		}
		
		bfs(1);
		System.out.println(cnt);
	}
	
	// bfs
	public static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		visited[n] = true;
		
		while (!queue.isEmpty()) {
			n = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (arr[n][i] != 0 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
	}
}
