import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW_D3_10912_외로운문자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테스트케이스 개수
		
		for (int tc = 1; tc <= T; tc++) {
			String result = "";
			String str = br.readLine();				// 문자열
			char[] arr = new char[str.length()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = str.charAt(i);
			}
			// 오름차순으로 정렬
			Arrays.sort(arr);
			for (int i = 0; i < arr.length; i++) {
				// 같은 문자열 짝짓기
				if (i < arr.length-1 && arr[i] == arr[i+1]) {
					i++;
					continue;
				}
				// 남은 문자열
				else {
					result += arr[i];
				}
			}
			// 어떤 문자도 남지 않았을 때
			if (result == "") result = "Good";
			// 출력
			System.out.printf("#%d %s\n", tc, result);
		}
	}
}
