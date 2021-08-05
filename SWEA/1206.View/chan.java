import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chan {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int t = 1; t <= 10; t++) {
			int ans = 0;	// 조망권 확보 세대 수
			int N = Integer.parseInt(br.readLine());
			int[] building = new int[N];	// 지역 빌딩들의 높이 
			st = new StringTokenizer(br.readLine(), " ");
			// 빌딩 높이 입력받기
			for (int i = 0; i < N; i++) {
				building[i] = Integer.parseInt(st.nextToken());
			}
			// 맨 앞에서 두번째까지와 맨 뒤에서 두번째까지는 건물이 없는 걸 고려하여 범위 지정
			for (int i = 2; i < N - 2; i++) {
				int h = building[i];	// 현재 탐색중인 빌딩의 높이
				// 가까운 왼쪽 빌딩 두개와 오른쪽 빌딩 두개의 높이가 현재 빌딩보다 높으면 조망권이 없으므로 다음 빌딩 탐색
				if (building[i - 2] > h || building[i - 1] > h || building[i + 1] > h || building[i+2] > h) continue;
				// 현재 빌딩에서 좌우 두칸 빌딩중 가장 높은 빌딩을 빼준 것이 조망권이 확보된 세대이다.
				ans += (h - highest(building[i - 2], building[i - 1], building[i + 1], building[i + 2]));
			}
			
			System.out.printf("#%d %d%n", t, ans);
		}
	}

	// 4개의 빌딩 중 가장 높은 빌딩의 층 수 반환
	private static int highest(int i, int j, int k, int l) {
		return Math.max(Math.max(i, j), Math.max(k, l));
	}
}
