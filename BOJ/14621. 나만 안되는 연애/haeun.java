import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14621_나만안되는연애 {
	
	public static class Edge implements Comparable<Edge> {
		int u, v, d;

		public Edge(int u, int v, int d) {
			super();
			this.u = u;
			this.v = v;
			this.d = d;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.d, o.d);
		}
	}
	
	public static int[] parents;
	
	// 자기자신을 부모로 지정
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
	public static String[] gender;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 학교의 수
		M = Integer.parseInt(st.nextToken());	// 도로의 수
		
		// 남초대학 여초대학 입력받기
		st = new StringTokenizer(br.readLine(), " ");
		gender = new String[N+1];
		for (int i = 1; i <= N; i++) {
			gender[i] = st.nextToken();
		}
		
		Edge[] edgeList = new Edge[M];
		
		// 간선 입력받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(u, v, d);
		}
		
		// 정렬
		Arrays.sort(edgeList);
		make();
		
		// 트리만들기
		int result = 0;
		int cnt = 0;
		for (int i = 0; i < edgeList.length; i++) {
			// 성별이 다르다면
			if (!gender[edgeList[i].u].equals(gender[edgeList[i].v])) {
				// 합쳐진다면
				if (union(edgeList[i].u, edgeList[i].v)) {
					result += edgeList[i].d;
					cnt++;
					// 최소간선갯수
					if (cnt == N-1) break;
				}
			}
		}
		
		// 모든 학교를 연결하는 경로가 없을 경우
		if (cnt != N-1) result = -1;
		// 출력
		System.out.println(result);
	}
}
