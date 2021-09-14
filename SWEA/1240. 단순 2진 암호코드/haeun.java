import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_D3_1240_단순2진암호코드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 테스트케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	// 배열의 세로 크기
			int M = Integer.parseInt(st.nextToken());	// 배열의 가로 크기
			String[] arr = new String[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine();
			}
			
			// 암호문 추출
			String allCode = "";
			for (int i = 0; i < N; i++) {
				// 쓸모없는 배열값
				if (arr[i].indexOf("1") == -1) continue;
				// 암호문 시작, 암호문 추출
				int endIndex = arr[i].lastIndexOf("1");
				allCode = arr[i].substring(endIndex-55, endIndex+1);
				break;
			}
			
			String code = "";
			// 암호문 분석
			for (int i = 0; i < allCode.length(); i+=7) {
        // 숫자 추출
				String temp = allCode.substring(i, i+7);
				if (temp.equals("0001101")) code += "0";
				else if (temp.equals("0011001")) code += "1";
				else if (temp.equals("0010011")) code += "2";
				else if (temp.equals("0111101")) code += "3";
				else if (temp.equals("0100011")) code += "4";
				else if (temp.equals("0110001")) code += "5";
				else if (temp.equals("0101111")) code += "6";
				else if (temp.equals("0111011")) code += "7";
				else if (temp.equals("0110111")) code += "8";
				else if (temp.equals("0001011")) code += "9";
			}
			// 검증코드를 제외한 숫자코드
			String numCode = code.substring(0, code.length()-1);
			// 검증코드
			int check = code.charAt(code.length()-1)-'0';
			
			// 검증코드 계산
			int result = check;
			int odd = 0;
			for (int i = 0; i < numCode.length(); i++) {
				if (i % 2 == 0) odd += numCode.charAt(i) - '0';
				else result += numCode.charAt(i) - '0';
			}
			result += odd*3;
			
			int answer = 0;
			// 검증코드가 틀렸을 시
			if (result % 10 != 0) answer = 0;
			else {
				// 숫자들의 합(출력값)
				for (int i = 0; i < code.length(); i++) {
					answer += code.charAt(i) - '0';
				}
			}
			// 출력
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
}
