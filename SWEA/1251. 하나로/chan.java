import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 요구사항 : 환경 부담금을 최소로 하면서 모든 섬을 연결해라
 * - 환경 부담금 : (환경 부담 세율 X 각 해저 터널 길이의 제곱)
 * 
 * 입력 : 전체 테케 수 T
 * 		각 테케 ~ 섬의 개수 N
 * 				각 섬들의 X좌표
 * 				각 섬들의 Y좌표
 * 				환경 부담 세율 E
 * 제약 : 1 <= N <= 1,000
 * 		0 <= X, Y <= 1,000,000 (X, Y는 정수)
 * 		0 <= E <= 1 (E는 실수)
 * 출력 : 각 테케 별 최소 환경 부담금(소수 첫째자리에서 반올림하여 정수형태로 출력)
 * 
 * 최소신장트리
 * 주의 : double형의 compareTo 오버라이딩
 *
 */
public class SWEA_1251_하나로 {
	static class Edge implements Comparable<Edge>{
		int start, end;
		double weight;
		public Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			if (this.weight > o.weight) return 1;
			else if (this.weight < o.weight) return -1;
			else return 0;
		}
	}
	static int N;
	static Edge[] edgeList;
	static double E;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int[][] input = new int[N][2];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				input[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				input[i][1] = Integer.parseInt(st.nextToken());
			}
			
			edgeList = new Edge[N * (N - 1) / 2];
			E = Double.parseDouble(br.readLine());
			int idx = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					int start = i;
					int end = j;
					double weight = getDistance(input[i], input[j]);
					edgeList[idx++] = new Edge(start, end, weight);
				}
			}
			
			Arrays.sort(edgeList);

			make();
			
			int cnt = 0;
			double result = 0;
			for (Edge edge : edgeList) {
				if (union(edge.start, edge.end)) {
					result += (E * (Math.pow(edge.weight, 2)));
					if (++cnt == N - 1) break;
				}
			}
			System.out.println(Math.round(result));
		}
	
	}
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	private static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	static int[] parents;
	private static void make() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	// 거리 구하는 함수
	private static double getDistance(int[] a, int[] b) {
		return Math.sqrt(Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2));
	}
}
