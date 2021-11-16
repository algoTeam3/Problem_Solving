import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20529_가장가까운세사람의심리적거리 {
	
	public static int N, result;
	public static String[] mbti, three;
	public static boolean[] checked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테스트케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());	// 학생의 수
			mbti = new String[N];					// mbti
			checked = new boolean[N];
			result = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				mbti[i] = st.nextToken();
			}
			
			// 출력
			if (N > 32) System.out.println(0);
			else {
				comb(0, 0);
				System.out.println(result);
			}
		}
	}
	
	// 조합
	public static void comb(int n, int start) {
		// 기저조건
		if (n == 3) {
			three = new String[3];					// 3명 뽑기
			int index = 0;
			for (int i = 0; i < N; i++) {
				if (checked[i]) three[index++] = mbti[i];
			}
			getDistance();
			return;
		}
		
		for (int i = start; i < N; i++) {
			checked[i] = true;
			comb(n + 1, i + 1);
			checked[i] = false;
		}
	}
	
	// 심리적 거리 구하기
	public static void getDistance() {
		int distance = 0;
		for (int i = 0; i < 4; i++) {
			if (three[0].charAt(i) != three[1].charAt(i)) distance++;
			if (three[0].charAt(i) != three[2].charAt(i)) distance++;
			if (three[1].charAt(i) != three[2].charAt(i)) distance++;
		}

		// 최솟값 갱신
		if (distance < result) result = distance;
	}
}
