import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_D3_1213_String {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());	// 테스트케이스의 번호
			String match = br.readLine();				// 찾을 문자열
			String str = br.readLine();					// 검색할 문장
			String[] arr = str.split(match);			// 찾을 문자열을 기준으로 나눈 것을 배열에 담기
			int total = arr.length-1;					// 특정 문자열의 개수
			
			// 문장 끝에 찾는 문자열이 하나 더 있을 때, total+1
			int cnt = match.length();
			for (int i = str.length()-1, j = match.length()-1; j >= 0; i--, j--) {
				if (str.charAt(i) == match.charAt(j)) cnt--;
			}
			if (cnt == 0) total++;
			
			// 출력
			System.out.printf("#%d %d\n", T, total);
		}
	}
}
