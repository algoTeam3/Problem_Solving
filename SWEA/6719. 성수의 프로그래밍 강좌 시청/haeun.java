import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_D4_6719_성수의프로그래밍강좌시청 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스 개수
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	// 강좌 개수
			int K = Integer.parseInt(st.nextToken());	// K개 시청
			int[] video = new int[N];
			double grade = 0;
			
			// 강좌 수준
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				video[i] = Integer.parseInt(st.nextToken());
			}
			// 오름차순으로 정렬
			Arrays.sort(video);
			for (int i = N-K; i < N; i++) {
				grade = (grade+video[i])/2;
			}
			// 출력
			System.out.printf("#%d %.6f\n", tc, grade);
		}
	}
}
