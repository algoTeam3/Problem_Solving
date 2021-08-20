import java.util.Scanner;

public class chan {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			StringBuffer sb = new StringBuffer("#" + t + " ");
            // 테케 별 N, M 입력받기
			int N = sc.nextInt();
			int M = sc.nextInt();
					
            /*
            N = 6, M = 3이라면 카드를 한장씩 골라 숫자를 합하는 경우의 수는
            N\M 1 2 3
            1   2 3 4
            2   3 4 5
            3   4 5 6
            4   5 6 7 
            5   6 7 8
            6   7 8 9
            가장 많이 등장하는 값은 위의 표에서 가장 긴 대각선에 해당하는 값이다.
            N 인덱스를 기준으로, [M][1]부터 [N][1]까지의 수가 가장 많이 등장하는 값이다.
            */
            // N이 더 길다면 N 인덱스 기준
			if (N >= M) {
				for (int i = M; i <= N; i++) {
					sb.append(1 + i).append(" ");
				}
			} else {    // M이 더 길다면 M 인덱스 기준
				for (int i = N; i <= M; i++) {
					sb.append(1 + i).append(" ");
				}
			}
			
			System.out.println(sb.toString());
		}
        sc.close();
	}
}
