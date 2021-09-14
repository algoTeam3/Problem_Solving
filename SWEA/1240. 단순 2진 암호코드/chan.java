import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] pw = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] data = br.readLine().split(" ");
			int N = Integer.parseInt(data[0]);
			int M = Integer.parseInt(data[1]);
			String code = null;
			
			for (int n = 0; n < N; n++) {
				String arr = br.readLine();
				int sum = 0;
				for (int m = 0; m < M; m++) {
					sum += arr.charAt(m) - '0';
				}
				if (code == null && sum != 0) {
					code = arr;
				}
			}
			int[] eight = new int[9];	// 인식한 암호코드를 저장할 공간
			
			/*
			 * 처음에는 앞에서부터 7개씩 살피면서 pw와 일치하는게 있으면 그거를 암호코드로 저장했으나
			 * 테케 7에서 0으로 에러가 나왔다.
			 * 한 줄에서 다양한 암호코드가 나올 수 있기 때문이다.
			 * 그래서, 모든 pw가 1로 끝나는 것을 참고해, 뒤에서부터 1이 나오면 앞으로 7개를 잘라서 pw와 비교함.
			 * 그리고! 모든 암호코드는 연속되어 나오기 때문에 바로 전, 전 해서 7개씩 8개, 연속 56글자를 자르면 된다.
			 */
			int idx = 8;	// eight에 차례로 넣을 변수. 뒤에서부터 삽입하기 때문에 8로 초기화
			int ans = 0;	// 8자리 코드의 합을 구해서 담을 변수
			// 범위가 넘지 않도록 끝에서부터 i-6이 0이 될 수 있는 6까지를 조건식으로 잡음
			for (int i = M - 1; i > 5; i--) {
				if (code.charAt(i) == '1') {	// 1로 끝나면
					for (int k = 1; k < 9; k++) {		// 연속되어있는 8개의 암호코드 자르기
						String str = code.substring(i - 6, i + 1);
						for (int j = 0; j < 10; j++) {	// 0부터 9까지의 pw와 겹치면 그 수는 j이다.
							if (str.equals(pw[j])) {
								eight[idx--] = j;
								i -= 7;					
							}
						}
					}
				}
			}
			// (홀수 자리의 합) * 3 + 짝수 자리의 합 + 검증 코드 가 10의 배수이면 정상, 아니면 비정상
			int check = (eight[1] + eight[3] + eight[5] + eight[7]) * 3 + (eight[2] + eight[4] + eight[6]) + eight[8];
			if (check % 10 == 0) {
				for (int i = 1; i < 9; i++) {
					ans += eight[i];
				}
			} 
			
			System.out.println("#" + t + " " + ans);
		}
	}

}
