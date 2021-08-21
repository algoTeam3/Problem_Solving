import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class chan {

	static int[] input;
	static int[] numbers;
	static Set<Integer> sumSet;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		// 입력된 테케만큼 반복
		for (int t = 1; t <= T; t++) {
			input = new int[7];	// 서로 다른 7개의 정수를 담을 배열 선언
			numbers = new int[3];	// 7개중 3개를 조합으로 뽑을 때 사용할 배열 선언
			String[] data = br.readLine().split(" ");
			for (int i = 0; i < 7; i++) {
				input[i] = Integer.parseInt(data[i]);
			}
			
			sumSet = new HashSet<>();	// 3개의 정수의 합을 담을 Set 생성
			comb(0, 0);
			// Set 을 List로 바꿔 순서 정렬하기
			List<Integer> list = new ArrayList<>(sumSet);
			Collections.sort(list);
			// 오름차순으로 되어있는 합들의 리스트 중 5번째로 큰 수를 구하기
			ans = list.get(list.size() - 5);
			System.out.println("#" + t + " " + ans);
			
		}
	}
	// 서로 다른 7개 중 3개 조합으로 선택
	static void comb(int cnt, int start) {
		if (cnt == 3) {
			int sum = 0;
			// 뽑은 세 수의 합 구하기
			for (int i = 0; i < 3; i++) {
				sum += numbers[i];
			}
            // Set에 중복되지 않게 세 수의 합을 넣기
			sumSet.add(sum);
			return;
		}
		
		for (int i = start; i < 7; i++) {
			numbers[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}
	}
}
