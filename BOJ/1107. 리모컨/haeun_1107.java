import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {
	
	public static int N, M, min;
	public static boolean[] btn;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// 이동하려는 채널
		M = Integer.parseInt(br.readLine());	// 고장난 버튼의 수
		btn = new boolean[10];					// 고장난 버튼
		min = Math.abs(N-100);					// +, -버튼만 사용
		
		// 고장난 버튼이 있을 때
		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				int temp = Integer.parseInt(st.nextToken());
				btn[temp] = true;
			}
		}
		
		// 숫자 10개가 다 고장났을 때
		if (M == 10) System.out.println(min);
		else {
			for (int i = 0; i <= 1000000; i++){
	            int cnt = solution(i);
	            // 고장난 버튼일 때
	            if (cnt == -1) continue;
	            // 최솟값 갱신
	            min = Math.min(min, cnt + Math.abs(N-i));
	        }
			// 출력
			System.out.println(min);
		}
	}
	
	public static int solution(int n) {
		// 버튼 누른 횟수
        int cnt = 0;
        
        while (true) {
            // 고장난 버튼일 때 반복문 탈출
            if(btn[n % 10]) break;

            // 다음 숫자 탐색, 누른 횟수 +1
            n /= 10;
            cnt++;
  
            // 다 나눴을 때
            if (n == 0) return cnt;
        }
        // 고장난 버튼일 때
        return -1;
	}
}
