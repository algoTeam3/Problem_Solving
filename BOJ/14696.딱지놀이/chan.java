import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chan {
	static int[] aCards, bCards;
	static char ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 총 N라운드 진행
		for (int n = 0; n < N; n++) {
			ans = 'D';
			aCards = new int[5];
			bCards = new int[5];
			// 라운드 별 a의 카드 입력받기 
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			for (int i = 0; i < a; i++) {
				aCards[Integer.parseInt(st.nextToken())]++;
			}
			// 라운드 별 b의 카드 입력받기
			st = new StringTokenizer(br.readLine(), " ");
			int b = Integer.parseInt(st.nextToken());
			for (int i = 0; i < b; i++) {
				bCards[Integer.parseInt(st.nextToken())]++;
			}
			// 해당 라운드 딱지치기 진행
			game();
			System.out.println(ans);
		}
	}
	
	private static void game() {
		// 우선순위가 높은 카드가 많으면 이기므로 4부터 1까지 반복문 진행
		for (int i = 4; i > 0; i--) {
			// i번째 카드가 a가 더 많으면 A가 승리
			if (aCards[i] > bCards[i]) {
				ans = 'A';
				break;
			}
			// i번째 카드가 b가 더 많으면 B가 승리
			else if (aCards[i] < bCards[i]) {
				ans = 'B';
				break;
			}
			// i번째 카드가 a와 b가 가진 개수 동일하다면 현재 무승부(1번째도 같다면 결과는 무승부)
		}
		
	}
}
