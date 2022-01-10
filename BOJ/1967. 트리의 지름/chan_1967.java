import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 노드 최대 개수 = 10000개 => 인접 리스트로 구현해야함 (행렬 X)
 */
public class chan_1967 {
	static class Node {
		int vertex;
		int weight;
		Node link;
		public Node(int vertex, int weight, Node link) {
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}
	}
	static int N;
	static int ans = 0;
	static int maxVertex = 1;
	static Node[] tree;
	static boolean[] visited;
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new Node[N + 1];
		visited = new boolean[N + 1];
		for (int n = 1; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int parentNode = Integer.parseInt(st.nextToken());
			int childNode = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			tree[parentNode] = new Node(childNode, weight, tree[parentNode]);
			tree[childNode] = new Node(parentNode, weight, tree[childNode]);
		}
		// 1. 루트 노드로부터 거리가 가장 먼 maxVertex 찾기
		dfs(1, 0);
		
		// 2. maxVertex로부터 가장 거리가 먼(가중치가 큰) 노드 찾기
		dfs(maxVertex, 0);
		System.out.println(ans);
	}
	private static void dfs(int current, int sum) {
		visited[current] = true;
		
		for (Node temp = tree[current]; temp != null; temp = temp.link) {
			if (!visited[temp.vertex])
				dfs(temp.vertex, sum + temp.weight);
		}
		
		if (ans < sum) {
			ans = sum;
			maxVertex = current;
		}
		
		visited[current] = false;
	} 

}
