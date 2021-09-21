import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	
	public static int N, M;
	public static int[][] arr;
	public static boolean[] checked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());		// 정점의 개수
		M = Integer.parseInt(st.nextToken());		// 간선의 개수
		int V = Integer.parseInt(st.nextToken());	// 탐색을 시작할 정점의 번호
		arr = new int[N+1][N+1];
		checked = new boolean[N+1];
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = arr[y][x] = 1;
		}
		
		dfs(V);
		checked = new boolean[N+1];
		System.out.println();
		bfs(V);
	}
	
	// dfs
	public static void dfs(int i) {
		checked[i] = true;
		System.out.print(i + " ");
		for (int j = 1; j <= N; j++) {
			if (arr[i][j] == 1 && !checked[j]) dfs(j);
		}
	}
	
	// bfs
	public static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(i);
		checked[i] = true;
		System.out.print(i + " ");
		
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			for (int j = 1; j <= N; j++) {
				if (arr[temp][j] == 1 && !checked[j]) { 
					queue.offer(j);
					checked[j] = true;
					System.out.print(j + " ");
				}
			}
		}
	}
}
