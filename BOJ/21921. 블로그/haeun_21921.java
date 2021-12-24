import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21921_블로그 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());	// 블로그 시작한지 N일
		int X = Integer.parseInt(st.nextToken());	// X일 탐색
		
		int[] people = new int[N];					// 방문자 수
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) people[i] = Integer.parseInt(st.nextToken());
		
		int max;									// 최대 방문자 수
		int term = 1;								// 기간 수(초기 1)
		int sum = 0;								// 최댓값과 비교할 sum 변수

		// 방문자들의 합 계산
		for (int i = 0; i < X; i++) {
			sum += people[i];
		}
		max = sum;

		// 슬라이딩 윈도우
		for (int i = X; i < N; i++) {
			sum += people[i] - people[i - X]; 
			
			// 최댓값 갱신
			if (max < sum) {
				max = sum;
				// 기간 초기화
				term = 1;
			}
			// 기간 + 1
			else if (max == sum) term++;
		}
		
		// 출력
		if (max == 0) System.out.println("SAD");
		else {
			System.out.println(max);				// 최대 방문자 수
			System.out.println(term); 				// 기간
		}
	}
}
