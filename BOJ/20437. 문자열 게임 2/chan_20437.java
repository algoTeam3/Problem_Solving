import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class chan_20437 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
			// 소문자 알파벳 별로 ArrayList 생성
			for (int i = 0; i < 26; i++) {
				ArrayList<Integer> idxs = new ArrayList<>();
				map.put((char)(i + 97), idxs);
			}
			// 주어진 문자열의 알파벳별로 map에 인덱스만 저장하기
			for (int i = 0; i < W.length(); i++) {
				map.get(W.charAt(i)).add(i);
			}
			
			int shortest = 10000;
			int longest = 0;
			
			// 알파벳별로 문자를 K개 포함하는 길이 구하기
			for (int i = 0; i < 26; i++) {
				ArrayList<Integer> idxs = map.get((char)(i + 97));
				if (idxs.size() < K) continue;	// K개 미만의 문자가 있다면 조건에 만족하지 않음
				
				// 알파벳별 저장된 인덱스를 K개씩 포함하도록 해서 길이 구하기
				for (int j = 0; j < idxs.size() - K + 1; j++) {
					shortest = Math.min(shortest, idxs.get(j + K - 1) - idxs.get(j) + 1);
					longest = Math.max(longest, idxs.get(j + K - 1) - idxs.get(j) + 1);
				}
			}
			
			if (longest == 0) System.out.println(-1);
			else {
				System.out.println(shortest + " " + longest);
			}
			
		}
	}

}
