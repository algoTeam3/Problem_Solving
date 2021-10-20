import java.util.Scanner;

public class BOJ_10996_별찍기21 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = n / 2;
		
		// N번만큼 반복
		for (int i = 0; i < n; i++) {
			// 윗줄
			int up;
			// N이 짝수일때, 홀수일때 윗줄이 다름
			if (n % 2 == 0) up = cnt;
			else up = cnt + 1;
			while (up-- > 0) System.out.print("* ");
			System.out.println();
			
			// 아랫줄
			int down = cnt;
			while (down-- > 0) System.out.print(" *");
			System.out.println();
		}
		sc.close();
	}
}
