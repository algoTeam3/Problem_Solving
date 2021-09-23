import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요구사항 : 주어진 횟수만큼 숫자판을 교환 후 숫자판의 위치에 따른 가중치에 의해 계산된 금액 중 최대값을 구해라.
 * 조건 : 반드시 횟수만큼 교환이 이뤄져야함, 동일한 위치의 교환이 중복되어도 허용
 * 
 * 입력 : 전체 테케 수
 * 		각 테케 별 ~ 숫자판 정보, 교환 횟수
 * 출력 : 각 테케 별 교환 후 받을 수 있는 가장 큰 금액
 * 
 * @author chaeu
 *
 */
public class chan {

	static int[] board;
	static int totalCnt, ans;
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			char[] input = st.nextToken().toCharArray();
			board = new int[input.length];
			for (int i = 0; i < input.length; i++) {
				board[i] = input[i] - '0';
			}
			totalCnt = Integer.parseInt(st.nextToken());
			ans = 0;
			solve(0, 0);
			
			System.out.println("#" + t + " " + ans);
		}
		
	}
	// 조합  + dfs
	private static void solve(int s, int cnt) {
		
		// 교환 횟수 끝나면 금액 확인
		if (cnt == totalCnt) {
			int cost = calculateAward();
			if (cost > ans) ans = cost;
			return;
		}
		
		for (int i = s; i < board.length; i++) {
			for (int j = i + 1; j < board.length; j++) {
				// 스왑 전 금액
				int before = calculateAward();
				// i번째 카드와 j번째 카드 스왑
				swap(i, j);
				// 스왑 후 금액
				int after = calculateAward();
				// 제일 큰 수인데 1번 교환해야할 때 (ex. 4321 1)
				if (cnt == 0 && i == board.length - 2 && j == board.length - 1)
					solve(i, cnt + 1);
				// 스왑 후 금액이 더 클 때 dfs 탐색
				if (before <= after)
					solve(i, cnt + 1);
				swap(i, j);
			}
		}
	}
	
	private static int calculateAward() {
		int cost = 0;
		for (int i = 0; i < board.length; i++) {
			cost += (board[i] * Math.pow(10, board.length - 1 - i));
		}
		return cost;
	}
	
	private static void swap(int i, int j) {
		int temp = board[j];
		board[j] = board[i];
		board[i] = temp;
	}

}
