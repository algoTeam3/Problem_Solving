import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chan {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String ans = "Possible";
			int[] line = new int[11112];
			st = new StringTokenizer(br.readLine(), " ");
			// 입력된 초에 그 순번에 사람이 기다리므로 1씩 증가
			for (int n = 1; n <= N; n++) {
				line[Integer.parseInt(st.nextToken())]++;
			}
			
			int curMade = 0;	// 0초부터 매초마다 만들어지는 붕어빵의 개수
			int guestSum = 0;	// 0초부터 매초마다 오는 손님 수

			// 0초에 손님이 올 때는 붕어빵이 만들어지지 않음.
			if (line[0] != 0) ans = "Impossible";
			  
			// 1초부터 매초마다 손님 확인
			for (int l = 1; l < line.length; l++) {
				// 해당 초에 손님이 있다면 총 손님 수에 합하기
				if (line[l] != 0) {
					guestSum += line[l];
				}
				// M초마다 K개의 붕어빵 만들어지면 해당 초까지 만들어진 총 붕어빵 개수에 합하기
				if (l % M == 0) {
					curMade += K;
				}
				// 해당 초까지의 총 손님 수가 만들어진 붕어빵 수보다 많으면 불가능한.
				if (guestSum > curMade) {
					ans = "Impossible";
					break;
				}
				// N명을 모두 확인했으면 반복문 빠져나가기
				if (guestSum == N) break;
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}

}
