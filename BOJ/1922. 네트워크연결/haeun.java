import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크연결 {
	public static class Edge implements Comparable<Edge> {
		int start, end, weight;
		
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			// 오름차순
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int[] parents;	// 부모원소 관리
	
	private static void make() {
		parents = new int[N+1];
		// 모든 원소를 자신을 대표자로 만듬
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	// 대표자 찾기
	private static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}

	// 두 원소 합치기
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		// 연결시키기
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static int N, M;
	public static Edge[] edgeList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// 컴퓨터의 수
		M = Integer.parseInt(br.readLine());	// 간선의 수
		
		// 간선 리스트 작성
		edgeList = new Edge[M];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(start, end, weight);
		}
		
		// 오름차순으로 정렬
		Arrays.sort(edgeList);
		
		make();
		
		// 트리 만들기
		int result = 0;
		int cnt = 0;
		for (Edge edge : edgeList) {
			if (union(edge.start, edge.end)) {
				cnt++;
				result += edge.weight;
				// 최소 간선 = 정점의 수 - 1
				if (cnt == N-1) break;
			}
		}
		// 출력
		System.out.println(result);
	}
}
