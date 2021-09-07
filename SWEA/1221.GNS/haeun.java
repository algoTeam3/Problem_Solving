import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_D3_1221_GNS {

	public static void main(String[] args) throws IOException {
		String[] num = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스 개수
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int trash = st.nextToken().charAt(1)-'0';	// 테스트케이스 번호
			int N = Integer.parseInt(st.nextToken());	// 테스트케이스 길이
			StringBuilder sb = new StringBuilder();		// 결과값
			int[] count = new int[10];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				String str = st.nextToken();
				// 숫자에 해당하는 인덱스값에 +1
				count[Arrays.asList(num).indexOf(str)]++;
			}
			
			// 문자열 정렬
			for (int i = 0; i < count.length; i++) {
				while (count[i]-- != 0) {
					sb.append(num[i]).append(" ");
				}
			}
			
			// 출력
			System.out.printf("#%d\n", tc);
			System.out.println(sb);
		}
	}
}
