import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요구사항 : N개의 신호등 중 몇몇개가 망가졌을 때, 연속한 K개의 신호등이 존재하도록 신호등을 수리하려고 한다. 
 * 			최소 몇 개의 신호등을 수리해야 할 지 출력해라
 * 입력 : 원래 신호등 개수 N, 연속으로 K개의 신호등 존재해야함, 고장난 신호등 개수 B
 * 		B개 줄 ~ 고장난 신호등의 번호
 * 제약 : 1 <= B,K <= N
 * 출력 : 연속 K개의 신호등이 존재하도록 수리해야 하는 최소 신호등 개수
 * 
 * 슬라이딩 윈도우
 * 	- 윈도우 크기 : K
 * 
 * @author chaeu
 *
 */
public class chan_14465 {
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 원래 신호등 개수
		int K = Integer.parseInt(st.nextToken()); // 연속으로 K개의 신호등 존재해야함
		int B = Integer.parseInt(st.nextToken()); // 고장난 신호등 개수
		int ans = N;
		boolean[] trafficLight = new boolean[N + 1];
		for (int i = 0; i < B; i++) {
			// 고장난 신호등 true로 변경
			trafficLight[Integer.parseInt(br.readLine())] = true;
		}
		
		int start = 1;	// 슬라이딩 횟수
		while(start <= N - K + 1) {
			int cnt = 0;
			// window 크기개의 신호등 중 true인 개수 구하기
			for (int i = start; i < K + start; i++) {
				if (trafficLight[i]) cnt++;
			}
			ans = Math.min(ans, cnt);
			start++;
		}
		System.out.println(ans);
	}
	
}
