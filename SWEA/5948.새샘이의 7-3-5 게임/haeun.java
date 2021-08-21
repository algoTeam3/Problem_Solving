import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	private static int[] arr, result;
	private static HashSet<Integer> hs = new HashSet<>();	// 중복제거

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());			// 테스트케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			arr = new int[7];								// 7개의 정수 중
			result = new int[3];							// 3개 고르기
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 7; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 조합
			comb(0, 0);
			// HashSet을 배열로 변환
			Integer[] sort = hs.toArray(new Integer[0]);
			// 오름차순으로 정렬
			Arrays.sort(sort);
			// 출력
			System.out.printf("#%d %d\n", tc, sort[sort.length-5]);
			hs.clear();
		}
	}

	// 7개중 3개 뽑기
	private static void comb(int cnt, int start) {
		// 기저조건
		if (cnt == 3) {
			// 합계 구하기
			int sum = 0;
			for (int num : result) sum += num;
			// HashSet에 추가
			hs.add(sum);
			return;
		}
		
		for (int i = start; i < 7; i++) {
			result[cnt] = arr[i];
			comb(cnt+1, i+1);
		}
	}
}
