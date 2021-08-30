import java.io.BufferedReader;
import java.io.InputStreamReader;

public class chan {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split(" ");
		int N = Integer.parseInt(data[0]);	// 카드의 개수
		int K = Integer.parseInt(data[1]);	// 카드를 섞은 횟수
		int[] S = new int[N + 1];
		int[] D = new int[N + 1];
		int[] P = new int[N + 1];
		data = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			S[i] = Integer.parseInt(data[i - 1]);
		}
		data = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			D[i] = Integer.parseInt(data[i - 1]);
		}
		// 입력 받기 완료

		// K번 섞는다.
		for (int k = 0; k < K; k++) {
			// Di는 PDi 값을 i번째로 가져와서 Si에 저장했으므로
			// Si의 값을 P의 Di번째에 두는 것이 한 번 섞기 전의 카드 배치이다.
			for (int i = 1; i <= N; i++) {
				P[D[i]] = S[i];
			}
			
			// Pi가 곧 이전에 카드 섞기의 결과이므로 Si가 Pi로 되어야한다.
			for (int i = 1; i <= N; i++) {
				S[i] = P[i];
			}
		}
		
		// 결과 출력
		for (int i = 1; i <= N; i++) {
			System.out.print(P[i] + " ");
		}
		
	}

}
