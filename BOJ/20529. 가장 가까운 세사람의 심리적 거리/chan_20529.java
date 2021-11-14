import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 비둘기집 원리 : n+1개의 물건을 n개의 상자에 넣을 때 적어도 어느 한 상자에는 두 개 이상의 물건이 들어 있다
 * mbti도 모든 경우가 16가지이니까 17명이면 최소 두명이 같은 것이고, 33명이면 최소 3명이 같다.
 *  
 * @author chaeu
 *
 */
public class chan_20529 {
	static int N, ans;
	static String[] mbti, closest;
	static boolean[] selected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테케수
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			mbti = new String[N];
			closest = new String[N];
			selected = new boolean[N];
			ans = 12;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				mbti[i] = st.nextToken();
			}
			if (N > 32) // 비둘기집의 원리(없으면 시간초과)
				System.out.println(0);
			else {
				comb(0, 0);
				System.out.println(ans);
			}
		}
	}
	// 입력받은 학생 수 중 가까운 세 사람의 경우를 찾는 조합
	private static void comb(int cnt, int start) {
		if (cnt == 3) {
			int idx = 0;
			for (int i = 0; i < N; i++) {
				if (selected[i]) closest[idx++] = mbti[i];
			}
			ans = Math.min(ans, getDistance(closest));
			return;
		}
		
		for (int i = start; i < N; i++) {
			selected[i] = true;
			comb(cnt + 1, i + 1);
			selected[i] = false;
		}
	}
	// 세 명의 거리 합를 구하는 함수
	private static int getDistance(String[] closest) {
		int dist = 0;
		dist += cal(closest[0], closest[1]);
		dist += cal(closest[1], closest[2]);
		dist += cal(closest[0], closest[2]);
		return dist;
	}
	// 두 개의 mbti에서 다른 문자의 수 찾는 함수
	private static int cal(String a, String b) {
		int diff = 0;
		for (int i = 0; i < 4; i++) {
			if (a.charAt(i) != b.charAt(i))
				diff++;
		}
		return diff;
	}
}
