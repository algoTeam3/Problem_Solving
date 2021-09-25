import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리 {
	
	public static class Edge implements Comparable<Edge> {
		int start, end;
		long weight;
		
		public Edge(int start, int end, long weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			// 오름차순
			if (this.weight < o.weight) return -1;
			return 1;
		}
	}

	public static int[] parents;
	
	// 자기자신을 부모로 설정
	public static void make() {
		parents = new int[V+1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	// 부모 찾기
	public static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	// 합치기
	public static boolean union(int a, int b){
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		parents[aRoot] = bRoot;
		return true;
	}
	
	public static int V, E;
	public static Edge[] edgeList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());	// 정점의 수
		E = Integer.parseInt(st.nextToken());	// 간선의 수
		
		edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			long weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(start, end, weight);
		}
		
		// 정렬
		Arrays.sort(edgeList);
		
		// 트리 만들기
		make();
		
		long result = 0;
		int cnt = 0;
		for (Edge edge : edgeList) {
			if (union(edge.start, edge.end)) {
				result += edge.weight;
				cnt++;
				// 최소 간선의 수
				if (cnt == V-1) break;
			}
		}
		
		// 출력
		System.out.println(result);
	}
}
