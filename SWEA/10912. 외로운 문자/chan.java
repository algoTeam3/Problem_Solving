import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1. 입력받은 알파벳 수 세서 홀짝인지 비교하는 방법
// 2. 입력받은 알파벳들 정렬해서 옆에랑 짝이 맞는지 확인하는 방법
public class chan {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuffer sb = new StringBuffer();
			char[] input = br.readLine().toCharArray();
			Arrays.sort(input);	// 입력 문자들 사전순 정렬
			
			// 정렬했을 때 다음 원소랑 같으면 짝이 있는 것
			for (int i = 0; i < input.length; i++) {
				// 지금 원소가 다음 원소랑 같으면 다다음 원소로 이동
				if (i < input.length - 1 && input[i] == input[i + 1]) {
					i++;
				}
				// 지금 원소가 다음 원소랑 다르면 지금 원소를 sb에 추가
				else {
					sb.append(input[i]);
				}
			}

			System.out.print("#" + t + " " );
			if (sb.length() == 0) {
				System.out.println("Good");
			} else System.out.println(sb.toString());
			
		}
	}

}
