import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class chan {
    public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/com/ssafy/study0814/input8931.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			int K = Integer.parseInt(br.readLine());	// 재현이가 수를 얼만큼 부를지
			ArrayList<Integer> ledger = new ArrayList<>(K);
			int value;
			for (int k = 0; k < K; k++) {
				value = Integer.parseInt(br.readLine());	// 재현이가 부른 수
				if (value == 0) ledger.remove(ledger.size() - 1);	// 제로를 외쳤으면 마지막에 쓰고 안 지운 수 지우기
				else ledger.add(value);		// 제로가 아니면 재현이가 부른 수를 장부에 적기
			}
			
			// 지운 수를 빼고 적힌 수들을 모두 더한다.
			for (int i = 0; i < ledger.size(); i++) {
				ans += ledger.get(i);
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
