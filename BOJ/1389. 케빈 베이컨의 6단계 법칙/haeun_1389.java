import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1389_케빈베이컨의6단계법칙 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// 유저의 수
		int M = Integer.parseInt(st.nextToken());	// 친구 관계의 수
		int INF = 99999;
		int min = Integer.MAX_VALUE;
		
		// 친구관계 배열 초기값
		int[][] friends = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) friends[i][j] = 0;
				else friends[i][j] = INF;
			}
		}

		// 친구관계 입력 받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			friends[A][B] = friends[B][A] = 1;
		}
		
		// 플로이드와샬
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
				}
			}
		}
		
		// 최솟값을 가진 사람
		int num = 100;
		// 최솟값 찾기
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += friends[i][j];
			}
			// 최솟값 갱신
			if (sum < min) {
				min = sum;
				num = i;
			}
		}
		
		// 출력
		System.out.println(num);
	}
}
