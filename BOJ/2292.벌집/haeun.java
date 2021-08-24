import java.util.Scanner;

public class BOJ_2292_벌집 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();					// N번방
		int total = 0;							// 지나는 방
		int num = 0;							// 한 테두리 지나가기
		int next = 1;							// 다음 테두리방에서 제일 큰 값
		
		while (true) {
			// N이 next보다 더 크다면 테두리를 하나 더 지나야하므로 total+1
			if (N > next) {
				total++;
			}
			// N이 next보다 작다면 이미 지나왔음, 반복문 탈출
			else break;
			// 다음 테두리에서 제일 큰 방 구하기
			next += 6*num;
			// 다음 테두리로 이동
			num++;
		}
		
		// N이 1번방일 때
		if (N == 1) total = 1;
		// 출력
		System.out.println(total);
		sc.close();
	}
}
