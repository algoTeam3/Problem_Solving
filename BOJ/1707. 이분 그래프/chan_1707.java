import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 요구사항 : 입력으로 주어진 그래프가 이분 그래프인지 아닌지 판별해라
 * - 이분 그래프 : 그래프의 정점의 집합을 둘로 분할하여 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있는 그래프
 * 
 * 입력 : 테케 수 K
 * 		각 테케 ~ 첫째줄 ~ 그래프 정점의 개수 V, 간선의 개수 E
 * 				E개의 줄 ~ 간선 정보 ( 인접한 두 정점의 번호 u, v)
 * 출력 : 이분 그래프이면 YES, 아니면 NO
 * 제약 : 2 <= K <= 5
 * 		1 <= V <= 20,000
 * 		1 <= E <= 200,000
 * 
 * 인접 행렬이 아닌 인접리스트 형태로 풀어야함(내 약점)
 * 
 * 풀이 방법
 * - 두 개의 그룹을 지어야함.
 * - 그룹이 지어지지 않은 정점으로부터 dfs 탐색을 하면서
 * - 인접 정점을 반대 그룹으로 설정해주는데, 이미 그룹이 되어있다면 이분 그래프가 될 수 없는 것임.
 * 
 * @author chaeu
 *
 */
public class chan_1707 {
	static class Node {
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}
	static Node[] adjList;
	static int[] group;
	static String ans;
	static int V, E;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			String[] data = br.readLine().split(" ");
			V = Integer.parseInt(data[0]);
			E = Integer.parseInt(data[1]);
			adjList = new Node[V + 1];
			group = new int[V + 1];
			ans = "YES";
			for (int e = 0; e < E; e++) {
				data = br.readLine().split(" ");
				int from = Integer.parseInt(data[0]);
				int to = Integer.parseInt(data[1]);
				adjList[from] = new Node(to, adjList[from]);
				adjList[to] = new Node(from, adjList[to]);
			}
			
			for (int i = 1; i <= V; i++) {
				if (group[i] == 0) {	// 그룹이 정해지지 않은 정점은 dfs 탐색
					if (dfs(i, 1)) break;
				}
			}
			System.out.println(ans);
		} 
	}
	private static boolean dfs(int current, int g) {
		group[current] = g;
		
		// current 정점에서 연결된 점들을 dfs 하면서, 번갈아가면서 그룹 지정하기
		for (Node temp = adjList[current]; temp != null; temp = temp.link) {
			// 이미 같은 그룹이면 이분 그래프 실패
			if (group[temp.vertex] == g) {
				ans = "NO";
				return true;
			}
			// 아직 방문되지 않은 정점이면 다른 그룹으로 설정
			if (group[temp.vertex] == 0) {
				// g *= -1로 하면 계속 -1만 나오네;;
				if (dfs(temp.vertex, -g)) 
					return true;
			}
		}
		return false;
	}
	
}
