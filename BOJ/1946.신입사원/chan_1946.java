import java.awt.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class chan_1946 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			int ans = 0;
			int N = Integer.parseInt(br.readLine());
			ArrayList<Applicant> list = new ArrayList<>();
			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.add(new Applicant(a, b));
			}
			Collections.sort(list);
			
			int mMin = 0;
			ans = 1; mMin = list.get(0).m;
			for (int i = 1; i < list.size(); i++) {
				Applicant a = list.get(i);
				if (a.m < mMin) {
					ans++;
					mMin = a.m;
				}
			}
			
			System.out.println(ans);
			
		}

	}
	
	public static class Applicant implements Comparable<Applicant> {
		int s;
		int m;
		
		public Applicant(int s, int m) {
			this.s = s;
			this.m = m;
		}

		@Override
		public int compareTo(Applicant o) {
			if (this.s > o.s) return 1;
			else return -1;
		}
	}
}
