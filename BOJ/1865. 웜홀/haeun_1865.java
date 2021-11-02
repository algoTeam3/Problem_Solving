import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1865_웜홀 {
	public static int N, M, W, INF=123456789;
	public static int[] dist;
	public static ArrayList<Edge> list;
	
	public static class Edge {
		int start, end, time;

		public Edge(int start, int end, int time) {
			this.start = start;
			this.end = end;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());			// 테스트케이스의 수
		
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());			// 지점의 수
			M = Integer.parseInt(st.nextToken());			// 도로의 개수
			W = Integer.parseInt(st.nextToken());			// 웜홀의 개수
			list = new ArrayList<>();
			
			dist = new int[N+1];
			Arrays.fill(dist, INF);
			
			// 도로의 정보
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int S = Integer.parseInt(st.nextToken());	// 연결
				int E = Integer.parseInt(st.nextToken());	// 연결
				int T = Integer.parseInt(st.nextToken());	// 걸리는 시간
				list.add(new Edge(S, E, T));
				list.add(new Edge(E, S, T));
			}
			
			// 웜홀의 정보
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int S = Integer.parseInt(st.nextToken());	// 시작
				int E = Integer.parseInt(st.nextToken());	// 도착
				int T = Integer.parseInt(st.nextToken());	// 줄어드는 시간
				list.add(new Edge(S, E, -T));
			}
			
			// 출력
			if (bellmanford()) System.out.println("YES");
			else System.out.println("NO");
		}
	}
		
	// 벨만-포드
	public static boolean bellmanford() {
		// 시작
		dist[1] = 0;
		// 음수사이클 여부
		boolean cycle = false;
        
        for (int i = 1; i <= N; i++) {
            for (Edge edge : list) {
                if (dist[edge.end] > dist[edge.start] + edge.time) {
                    dist[edge.end] = dist[edge.start] + edge.time;
                    if (i == N) cycle = true;
                }
            }
        }
        return cycle;
	}
}
