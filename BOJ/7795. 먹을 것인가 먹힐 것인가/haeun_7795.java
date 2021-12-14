import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7795_먹을것인가먹힐것인가 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스의 개수
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	// A의 수
			int M = Integer.parseInt(st.nextToken());	// B의 수
			int[] A = new int[N];
			int[] B = new int[M];
			int cnt = 0;
			
			// A
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
			
			// B
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) B[i] = Integer.parseInt(st.nextToken());
			
			// 정렬
			Arrays.sort(A);
			Arrays.sort(B);
			
			// A가 B보다 큰 쌍의 개수 구하기
			for (int i : A) {
				for (int j : B) {
					if (i > j) cnt++;
					else break;
				}
			}
			
			// 출력
			System.out.println(cnt);
		}
	}
}
