import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class chan_1446 {

	static class Node implements Comparable<Node> {
		int start;
		int end;
		int cost;
		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		public int compareTo(Node o) {
			return this.start - o.start;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		ArrayList<Node> list = new ArrayList<>();
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if (d > D) continue;
			if (d - s <= w) continue;
			list.add(new Node(s, d, w));
		}
		
		int[] dp = new int[D + 1];
		dp[0] = 0;
		Collections.sort(list);

		for (int i = 0; i < D + 1; i++) dp[i] = i;
		
		int idx = 0;
		int n = 0;
		while (idx < D) {
			if (n < list.size() && list.get(n).start == idx) {
				Node path = list.get(n);
				for (int i = path.start + 1; i <= path.end; i++) {
					if (dp[i] > dp[i - 1] + 1) {
						dp[i] = dp[i - 1] + 1;
					}
				}
				if ((dp[path.start] + path.cost) < dp[path.end]) {
					dp[path.end] = (dp[path.start] + path.cost);
				}
				n++;
			} else {
				idx++;
				if (dp[idx] > dp[idx - 1] + 1) {
					dp[idx] = dp[idx - 1] + 1;
				}
			}
		}
		System.out.println(dp[D]);
	}

}
