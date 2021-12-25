import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요구사항 : 총 N일동안 블로그 방문자 수 중에서 X일 동안 가장 많이 들어온 방문자 수와, 그 기간의 수를 구해라
 * 입력 : 블로그 운영 일 수 N, 연속 일 수 X
 * 		1일차부터 N일차까지 하루 방문자 수 (N개)
 * 제약 : 1 <= X <= N <= 250,000
 * 		0 <= 방문자 수 <= 8,000
 * 출력 : X일동안 가장 많이 들어온 방문자 수 (최대 방문자 수가 0명이면 SAD 출력)
 * 		기간의 수
 * 
 * 슬라이딩 윈도우
 * 	- 윈도우 크기 : X
 * 
 * @author chaeu
 *
 */
public class chan_21921 {
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 블로그 운영 일 수 N
		int X = Integer.parseInt(st.nextToken()); // 연속 일 수
		int[] visitors = new int[N + 1];	// 하루 방문자 수
		
		st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;	// 기간의 수
		int max = 0;	// 최대 방문자 수
		for (int i = 1; i <= N; i++) {
			visitors[i] = Integer.parseInt(st.nextToken());
		} // 입력받기 완료
		
		int start = 1;	// window 시작 인덱스
		int sum = 0;	// X일 동안의 방문자 수
		// 첫 윈도우 총 방문자 수
		for (int i = 1; i <= X; i++) {
			sum += visitors[i];
		}
		// 슬라이딩 윈도우
		while (start <= N - X + 1) {
			// 윈도우 크기만큼 다 더하지 않고(시간초과), 이전의 윈도우를 이용해 계산하기
			if (start != 1) {
				sum -= visitors[start - 1];
				sum += visitors[start + X - 1];
			}
			// 기간의 수 세기
			if (sum == max) {
				cnt++;
			}
			// 최대 방문자 수 갱신
			if (sum > max) {
				max = sum;
				cnt = 1;
			}
			start++;
		}
		
		if (max == 0) { 	// 최대 방문자 수가 0명일 때
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
	
}
