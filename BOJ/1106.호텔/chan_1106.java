import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 요구사항 : 각 도시별로 홍보하는데 드는 비용과, 그때 몇명의 호텔 고객이 늘어나는지에 대한 정보가 주어질때,
 * 			호텔의 고객을 적어도 C명 늘이기 위해 투자해야 하는 돈의 최솟값을 구해라
 * 입력 : 늘여야 하는 최소 고객 수 C, 홍보할 수 있는 도시의 개수 N
 * 		N개 줄 ~ 각 도시에서 홍보할 때 대는 비용 costs, 그 비용으로 얻는 고객의 수 customers
 * 출력 : 투자해야 하는 돈의 최솟값
 * 제약 : 0 < C <= 1000
 * 		0 < N <= 20
 * 		0 < customers <= 100
 * 
 * @author chaeu
 *
 */
public class chan_1106 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] costs = new int[N + 1];
		int[] customers = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			costs[i] = Integer.parseInt(st.nextToken());
			customers[i] = Integer.parseInt(st.nextToken());
		}
		
		final int INF = 987654321;
		int[] D = new int[C + 101];
		Arrays.fill(D, INF);
		D[0] = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int c = customers[i]; c < C + 101; c++) {
				D[c] = Math.min(D[c], costs[i] + D[c - customers[i]]);
			}
		}
		
		int min = INF;
		for (int i = C; i < C + 101; i++) 
			min = Math.min(min, D[i]);
		System.out.println(min);
	}

}
