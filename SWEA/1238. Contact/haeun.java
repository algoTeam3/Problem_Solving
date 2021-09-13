import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());		  // 데이터의 길이
			int start = Integer.parseInt(st.nextToken());	// 시작점
			int result = 0;
			
			boolean[][] arr = new boolean[101][101];		  // 연락망
			
			// 연결된 연락망
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from][to] = true;
			}
			
			// bfs
			boolean[] visited = new boolean[101];
			
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.offer(start);
			visited[start] = true;
			
			// 연락망 탐색
			while (!queue.isEmpty()) {
				int size = queue.size();
				int num = 0;
				// 같은 레벨 탐색
				while (size-- > 0) {
					int current = queue.poll();
					for (int i = 1; i <= 100; i++) {
						// 동시에 연락받는 사람들 중 가장 숫자가 큰사람 탐색
						if (arr[current][i] && !visited[i]) {
							queue.offer(i);
							visited[i] = true;
							if (num < i) num = i;
						}
					}
				}
				// 연락받는 사람이 존재한다면 result에 저장
				if (num > 0) result = num;
			}
			
			// 출력
			System.out.printf("#%d %d\n", tc, result);
		}
	}
}
