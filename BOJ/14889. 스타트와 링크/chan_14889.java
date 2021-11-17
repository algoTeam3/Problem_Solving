import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chan_14889 {

	static int N, ans;
	static int[][] S;
	static boolean[] selected;
	static int[] sTeam, lTeam;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		selected = new boolean[N];
		sTeam = new int[N/2];
		lTeam = new int[N/2];
		ans = Integer.MAX_VALUE;
		
		comb(0, 0);
		System.out.println(ans);
	}
	private static void comb(int cnt, int start) {
		if (start == N) return;
		
		if (cnt == N / 2) {
			int sNo = 0, lNo = 0;
			for (int i = 0; i < N; i++) {
				if (selected[i]) sTeam[sNo++] = i;
				else lTeam[lNo++] = i;
			}
			ans = Math.min(ans, Math.abs(cal(sTeam) - cal(lTeam)));
			return;
		}
		
		for (int i = start; i < N; i++) {
			selected[i] = true;
			comb(cnt + 1, i + 1);
			selected[i] = false;
		}
	}
	private static int cal(int[] team) {
		int sum = 0;
		
		for (int i = 0; i < team.length; i++) {
			for (int j = i + 1; j < team.length; j++) {
				sum += S[team[i]][team[j]] + S[team[j]][team[i]];
			}
		}
		return sum;
	}

}
