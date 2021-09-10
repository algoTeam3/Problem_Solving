import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_D3_1234_비밀번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); 		// 문자열의 길이
			String num = st.nextToken();					        // 문자열
			
			// 문자열 탐색
			for (int i = 0; i < num.length(); i++) {
				// 같은 번호로 붙어있는 쌍 발견
				if (i+1 < num.length() && num.charAt(i) == num.charAt(i+1)) {
					// 왼쪽 오른쪽 쌍 탐색
					int left = -1;
					int right = 1;
					while (i+left >= 0 && i+right+1 < num.length() && num.charAt(i+left) == num.charAt(i+1+right)) {
						left--;
						right++;
					}
					// 소거하는 쌍을 제외한 왼쪽 문자열 잘라내기
					String strLeft = num.substring(0, i+left+1);
					// 소거하는 쌍을 제외한 오른쪽 문자열 잘라내기
					String strRight = num.substring(i+right+1, num.length());
					// 문자열 합쳐서 다시 처음부터 소거
					num = strLeft.concat(strRight);
					i = -1;
				}
			}
			// 출력
			System.out.printf("#%d %s\n", tc, num);
		}
	}
}
