import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할계획 {
	
	public static class Edge implements Comparable<Edge> {
		int A, B, C;	// A집, B집, 유지비 C

		public Edge(int A, int B, int C) {
			super();
			this.A = A;
			this.B = B;
			this.C = C;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.C, o.C);
		}
	}
	
	public static int[] parents;
	
	// 자기자신을 부모로
	public static void make() {
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	// 부모 찾기
	public static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	// 합치기
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		parents[aRoot] = bRoot;
		return true;
	}
	
	public static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());			// 집의 수
		M = Integer.parseInt(st.nextToken());			// 길의 수
		
		Edge[] edgeList = new Edge[M];
		
		// 값 넣기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());	// A집
			int B = Integer.parseInt(st.nextToken());	// B집
			int C = Integer.parseInt(st.nextToken());	// 유지비
			edgeList[i] = new Edge(A, B, C);
		}
		
		// 정렬
		Arrays.sort(edgeList);
		
		make();
		
		// 트리 만들기
		int cnt = 0;	// 간선의 수
		int result = 0;
		int max = 0;	// 최대 유지비
		for (Edge edge : edgeList) {
			if (union(edge.A, edge.B)) {
				cnt++;
				result += edge.C;
				// 최댓값 갱신
				if (edge.C > max) max = edge.C;
				// 최소 간선의 수
				if (cnt == N-1) break;
			}
		}
		
		// 마을을 분리시키고 유지비 합의 최솟값 출력
		System.out.println(result-max);
	}
}
