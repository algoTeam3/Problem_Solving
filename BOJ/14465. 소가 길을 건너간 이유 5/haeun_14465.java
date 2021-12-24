import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14465_소가길을건너간이유5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());	// 횡단보도 N개
		int K = Integer.parseInt(st.nextToken());	// 연속한 K개 신호등
		int B = Integer.parseInt(st.nextToken());	// 고장난 신호등 개수
		
		// 고장난 신호등
		boolean[] light = new boolean[N+1];
		int cnt = 0;
		
		for (int i = 0; i < B; i++) {
			int num = Integer.parseInt(br.readLine());
			light[num] = true;
			if (num <= K) cnt++;
		}
		
		// 최솟값
		int min = cnt;
		// 투포인터 위치
		int left = 1;
		int right = K;
		
		// 투포인터
		while (right < N) {
			if (!light[left] && light[right+1]) cnt++;
			else if (light[left] && !light[right+1]) cnt--;
			
			// 최솟값 갱신
			if (cnt < min) min = cnt;
			
			// 포인터 이동
			left++;
			right++;
		}
		
		// 출력
		System.out.println(min);
	}
}
