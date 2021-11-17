import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chan_1107 {
	static int N, M;
	static boolean[] btns;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// 이동하려는 채널
		M = Integer.parseInt(br.readLine());	// 고장난 버튼의 개수
		btns = new boolean[10];	// 고장난 버튼인지 체크할 배열
		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				btns[Integer.parseInt(st.nextToken())] = true;;
			}
		}
		
		if (N == 100) System.out.println(0);
		else {
			int ans = Math.abs(N - 100);	// +,- 버튼으로만 이동하는 경우를 초기값으로 설정
			// 브루트포스 - 숫자버튼으로 i를 누른 후 +,- 버튼으로 이동
			for (int i = 0; i < 1000000; i++) {
				String strNum = String.valueOf(i);
				boolean isPossible = true;
				// 고장난 버튼이 있으면 숫자버튼으로 이동 불가 (다음 i 탐색)
				for (int j = 0; j < strNum.length(); j++) {
					int btn = strNum.charAt(j) - '0';
					if (btns[btn]) {
						isPossible = false;
						break;
					}
				}
				if (isPossible) {	
					int upDown = strNum.length() + Math.abs(i - N); // 숫자로 이동 후 +, -로 이동
					ans = Math.min(ans, upDown);
				}
			}
			System.out.println(ans);
		}
	}
}
