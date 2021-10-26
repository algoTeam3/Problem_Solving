import java.util.HashSet;
import java.util.Scanner;

public class BOJ_16922_로마숫자만들기 {
	
	public static int N, count;
	public static int[] text, arr;
	public static HashSet<Integer> hs;	// 만들 수 있는 수 중복 체크

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();				          // 사용할 수 있는 문자의 개수
		text = new int[] {1, 5, 10, 50};  // 로마 숫자 {'I', 'V', 'X', 'L'}
		arr = new int[N];
		hs = new HashSet<>();
		count = 0;
		
		comb(0, 0);
		
		// 출력
		System.out.println(count);
		sc.close();
	}
	
	// 중복조합
	public static void comb(int num, int start) {
		// 기저조건
		if (num == N) {
			// 합계 구하기
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += arr[i];
			}
			// 중복되지 않는 수라면 count+1
			if (hs.add(sum)) count++;
			return;
		}
		
		for (int i = start; i < 4; i++) {
			arr[num] = text[i];
			comb(num+1, i);
		}
	}
}
