import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chan {
	/**
	 * 조건 : 실력이 A, 강좌 수준이 M일 때, 강좌 시청 후 실력은 (A + M) / 2
	 * 요구사항 : 볼 수 있는 강좌 N개 중 K개를 적절한 순서로 한 번씩 시청해서 가질 수 있는 실력의 최대 수치를 구해라.
	 * 풀이 : 1) N, K 보고서 범위가 크길래 순열 안 될 것 같단 생각하면서도 일단 순열로 풀었더니 역시나 시간초과남.
	 * 		2) 그래서 레벨 높은 애들만 K개의 배열 만들어서 가지치기 해봤는데도 시간초과남
	 * 		3) 레벨 높여놓고 레벨 낮은 강의를 들으면 안되니까, 레벨이 높은 상위 K개의 강의중에 낮은 순으로 그냥 들으면 되는거였음.
	 */

	static int[] input, highSortArr; 
	static int N, K;
	static double ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			ans = 0.0;	// 현재 성수는 실력이 0
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());	// 볼 수 있는 강좌
			K = Integer.parseInt(st.nextToken());	// 시청할 강좌 수
			input = new int[N];	
			highSortArr = new int[K];	// 순위가 높은 상위 K개의 강좌를 담을 배열
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			// 배열 정렬 후 가장 큰 K개의 수를 따로 배열에 담기
			Arrays.sort(input);
			System.arraycopy(input, input.length - K, highSortArr, 0, K);
			
			// 레벨이 높은 K개의 강좌 중 낮은 순으로 강좌 시청 후 실력 계산하기
			for (int i = 0; i < K; i++) {
				ans = (ans + highSortArr[i]) / 2;
			}
			System.out.printf("#%d %.6f%n", t, ans);
		}
	}	
}
