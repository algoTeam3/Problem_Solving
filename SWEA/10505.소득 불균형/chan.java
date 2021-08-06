import java.util.Scanner;

public class chan {
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();			// 사람의 수
			int[] earnings = new int[N];	// 각 사람의 소득을 담을 배열	
			int average = 0;				// 소득 평균을 저장할 변수
			int ans = 0;					// 평균 이하의 소득을 가진 사람 수를 카운트 할 변수
			// N명의 소득을 입력받아 배열에 저장하면서, 평균을 구하기 위해 모두 더한다.
			for (int i = 0; i < N; i++) {
				earnings[i] = sc.nextInt();
				average += earnings[i];
			}
			average /= N;					// N명의 평균
			// 평균 이하의 소득을 가진 사람이 있으면 카운팅
			for (int e : earnings) {
				if (e <= average) ans++;
			}
			System.out.println("#" + t + " " + ans);
		}
		sc.close();
	}
}