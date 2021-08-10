import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_10505_소득불균형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			int[] earnings = new int[N];
			for(int n = 0; n < N; n++) {
				int v = Integer.parseInt(st.nextToken());
				earnings[n] = v;
				sum += v;
			}
			
			int cnt = 0;
			for(int i = 0; i < earnings.length; i++) {
				if(earnings[i] <= sum/N) cnt++;
			}
			System.out.println("#" + t + " " + cnt);
		}
	}

}
