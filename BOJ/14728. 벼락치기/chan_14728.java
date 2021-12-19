import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chan_14728 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 이번 시험의 단원 개수
		int T = Integer.parseInt(st.nextToken()); // 시험까지 공부 할 수 있는 총 시간
		
		int[] time = new int[N + 1];
		int[] score = new int[N + 1];
		
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			time[n] = Integer.parseInt(st.nextToken()); //각 단원 별 예상 공부 시간
			score[n] = Integer.parseInt(st.nextToken()); // 그 단원 문제의 배점
		}
		
		int[] D = new int[T + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int t = T; t >= time[i]; t--) 
				D[t] = Math.max(D[t], score[i] + D[t - time[i]]);
		}
		
		System.out.println(D[T]);
	}

}
