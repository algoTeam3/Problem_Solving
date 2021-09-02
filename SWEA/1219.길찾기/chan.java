import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chan {

	static int[] pair1, pair2;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int tc = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());	// 길의 총 개수
			ans = 0;
			// size[100]의 정적 배열 2개 선언
			pair1 = new int[100];
			pair2 = new int[100];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int n = 1; n <= N; n++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				if (pair1[start] == 0) {
					pair1[start] = end;
				} else {
					pair2[start] = end;
				}
			}
			// 두 개의 배열에 입력 받기 완료
			
			// 두 개의 배열의 0번 정점부터 시작해서 선택 가능한 길이 있는지 재귀탐색
			find(pair1[0]);
			find(pair2[0]);

			System.out.println("#" + t + " " + ans);
		}
	}
	private static void find(int i) {
		// 길을 찾았거나 정점에서 선택할 수 있는 길이 없을 때 리턴
		if (ans == 1 || i == 0) return;
		// 두 개의 배열 중 어느 곳에서든 도착점에 도착했을 때 길이 존재함
		if (pair1[i] == 99 || pair2[i] == 99) {
			ans = 1; return;
		}
		
		find(pair1[i]);
		find(pair2[i]);
		
	}

}
