import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_D4_1231_중위순회 {
	public static int N;
	public static String[] alpha;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());						// 정점의 총 수
			alpha = new String[N+1];									      // 알파벳
			
			// 정점에 해당하는 알파벳 채우기
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int num = Integer.parseInt(st.nextToken());		// 정점
				String str = st.nextToken();							    // 알파벳
				alpha[num] = str;
				
				int end = N / 2;
				
				if (num <= end) {
					int left = Integer.parseInt(st.nextToken()); 			  // 왼쪽 자식
					// 자식을 가지고 있다면
					if (num == end) {
						if (N % 2 != 0) {
							int right = Integer.parseInt(st.nextToken()); 	// 오른쪽 자식
						}
					} else {
						int right = Integer.parseInt(st.nextToken()); 		// 오른쪽 자식
					}
				}
			}
			// 출력
			System.out.printf("#%d ", tc);
			solve(1);
			System.out.println();
		}
	}
	
	// 중위순회
	public static void solve(int num) {
		if (num > N) return;
		solve(num*2);
		System.out.printf("%s", alpha[num]);
		solve(num*2+1);
	}
}
