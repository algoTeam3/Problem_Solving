import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1707_이분그래프 {
	
	public static int V;
	public static int[] checked;
	public static boolean result;
	public static ArrayList<Integer> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());		// 테스트 케이스의 개수
		
		for (int tc = 1; tc <= K; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());	// 정점의 개수
			int E = Integer.parseInt(st.nextToken());	// 간선의 개수
			
			result = false;
			checked = new int[V+1];
			list = new ArrayList[V+1];
			for (int i = 1; i <= V; i++) list[i] = new ArrayList<>();
			
			for (int i = 1; i <= E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				// 두 정점의 번호
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				list[u].add(v);
				list[v].add(u);
			}
			
			for (int i = 1; i <= V; i++) {
				if (checked[i] == 0) dfs(i, 1);
			}
			
			// 출력
			if (result) System.out.println("NO");
			else System.out.println("YES");
		}
	}
	
	// dfs
	public static void dfs(int num, int col) {
		checked[num] = col;
		if (result) return;
		
		for (Integer i : list[num]) {
			if (checked[i] == checked[num]) {
				result = true;
				return;
			}
			if (checked[i] == 0) dfs(i, col*-1);
		}
	}
}
