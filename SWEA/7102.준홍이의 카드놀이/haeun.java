import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();						// 테스트케이스 개수
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();					// 1~N번 카드
			int M = sc.nextInt();					// 1~M번 카드
			int[] numCount = new int[N + M + 1];	// 등장하는 숫자의 개수를 담을 배열
			
			// 합계의 빈도수 구하기
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					numCount[i + j]++;
				}
			}
			
			// 최댓값 구하기
			int max = -1;
			for (int num : numCount) if (max < num) max = num;
			
			// 출력
			System.out.print("#" + tc + " ");
			for (int num = 1; num < numCount.length; num++) {
				if (numCount[num] == max) System.out.printf("%d ", num);
			}
			System.out.println();
		}
		sc.close();
	}
}
