import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chan {
	static class Edge implements Comparable<Edge> {
		int start, end, weight;
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	static int N, M;
	static Edge[] edgeList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		char[] gender = new char[N + 1];
		for (int i = 1; i <= N; i++) {
			gender[i] = st.nextToken().charAt(0);
		}
		
		edgeList = new Edge[M];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[m] = new Edge(start, end, weight);
		}
		
		Arrays.sort(edgeList);
		
		make();
		
		int cnt = 0;
		int result = 0;
		for (int i = 0; i < edgeList.length; i++) {
			int u = edgeList[i].start;
			int v = edgeList[i].end;
			if (gender[u] == gender[v]) continue;
			if (union(u, v)) {
				result += edgeList[i].weight;
				if (++cnt == N - 1) break;
			}
		}
		
        if (cnt < N - 1) result = -1;

		System.out.println(result);
	}
	
	static int[] parents;
	
	private static void make() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
}
