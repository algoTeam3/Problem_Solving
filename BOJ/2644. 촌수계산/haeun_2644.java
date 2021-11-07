import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {
	
	public static int n, a, b;
	public static int[][] family;
	public static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());	// 사람의 수
		family = new int[n+1][n+1];				// 부모 자식 관계
		count = new int[n+1];					// 촌수 계산
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 촌수를 계산해야 하는 두 사람의 번호
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());	// 부모 자식들 간의 관계의 수
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			family[x][y] = family[y][x] = 1;
		}
		
		bfs(a);
		// 출력
		if (count[b] == 0) System.out.println(-1);
		else System.out.println(count[b]);
	}

	// bfs
	public static void bfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int j = 1; j <= n; j++) {
				if (family[temp][j] == 1 && count[j] == 0) {
					q.offer(j);
					count[j] = count[temp] + 1;
				}
			}
		}
	}
}
