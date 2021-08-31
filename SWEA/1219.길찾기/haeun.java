import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_D4_1219_길찾기 {
	public static int result;
	public static int[] arr1, arr2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());	// 테스트케이스 번호
			int N = Integer.parseInt(st.nextToken());	// 순서쌍의 개수
			arr1 = new int[100];
			arr2 = new int[100];
			result = 0;									// 유효한 길인지 검사
			st = new StringTokenizer(br.readLine());
			// 데이터 저장
			for (int i = 0; i < N; i++) {
				int current = Integer.parseInt(st.nextToken());
				int next = Integer.parseInt(st.nextToken());
				if (arr1[current] == 0) arr1[current] = next;
				else arr2[current] = next;
			}
			solve(arr1[0]);
			solve(arr2[0]);
			// 출력
			System.out.printf("#%d %d\n", T, result);
		}
	}
	public static void solve(int index) {
		if (index == 0) return;
		// 도착지점까지 갔다면 유효함
		if (index == 99){
			result = 1;
			return;
		}
		solve(arr1[index]);
		solve(arr2[index]);
	}
}
