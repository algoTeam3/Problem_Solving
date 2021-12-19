import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chan_12865 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] weights = new int[N + 1];
		int[] profits = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			weights[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] D = new int[K + 1];
		for (int i = 1; i <= N; i++) {
			for (int k = K; k >= weights[i]; k--)
				D[k] = Math.max(D[k], profits[i] + D[k - weights[i]]);
		}
		
		System.out.println(D[K]);
	}

}
