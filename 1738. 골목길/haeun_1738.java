import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1738_골목길 {
	public static int n, m, INF;
	public static int[] dist, result;
	public static ArrayList<Edge> list;
	
	public static class Edge {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());			// 지점의 개수
		m = Integer.parseInt(st.nextToken());			// 골목길의 개수
		dist = new int[n+1];
		result = new int[n+1];
		list = new ArrayList<>();
		
		Arrays.fill(dist, INF);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());	// u번 교차점
			int v = Integer.parseInt(st.nextToken());	// v번 교차점
			int w = Integer.parseInt(st.nextToken());	// 금품의 양
			list.add(new Edge(u, v, w));
		}
		
		// 출력
		if (bellmanford()) System.out.println("-1");
		else {
			for (int i = 1; i <= n; i++) System.out.print(result[i] + " ");
		}
	}
	
	// 벨만-포드
	public static boolean bellmanford() {
		// 시작
		dist[1] = 0;
		// 음수사이클 여부
		boolean cycle = false;
        
		    /*
        for (int i = 1; i <= n; i++) {
            for (Edge edge : list) {
                if (dist[edge.start] < dist[edge.end] + edge.weight) {
                    dist[edge.start] = dist[edge.end] + edge.weight;
                    result[edge.start] = edge.end;
                    if (i == n) cycle = true;
                }
            }
        }
        */

        return cycle;
	}
}
