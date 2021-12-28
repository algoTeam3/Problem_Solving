import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 요구사항 : DNA 문자열이 주어졌을 때, 주어진 조건을 만족하는 부분 문자열의 개수를 구해라
 * 입력 : DNA 문자열 길이 S, 부분 문자열 길이 P
 * 		DNA 문자열
 * 		부분 문자열 조건 {'A', 'C', 'G', 'T'} 각각의 최소 개수
 * 제약 : 1 <= |P| <= |S| <= 1,000,000
 * 출력 : 조건을 만족하는 부분 문자열의 개수
 * 
 * 슬라이딩 윈도우
 * 	- 윈도우 크기 : P
 * @author chaeu
 *
 */
public class chan_12891 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());	// DNA 문자열 길이
		int P = Integer.parseInt(st.nextToken()); 	// 부분 문자열 길이
		int ans = 0;
		char[] dna = br.readLine().toCharArray();
		int[] acgt = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			acgt[i] = Integer.parseInt(st.nextToken());
		}	// 입력받기 완료
		
		// 부분 문자열의 DNA 문자 개수를 세기 위한 map
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 0);
		map.put('G', 0);
		map.put('T', 0);
		// DNA 문자열의 처음 P개의 부분 문자열 개수 먼저 세기
		for (int i = 0; i < P; i++) {
			map.put(dna[i], map.get(dna[i]) + 1);
		}
		
		if (map.get('A') >= acgt[0] && map.get('C') >= acgt[1] 
				&& map.get('G') >= acgt[2] && map.get('T') >= acgt[3]) {
					ans++;
				}
			
		int start = 1;
		while (start <= S - P) {	// 부분 문자열의 DNA 문자 개수는 중복되는 윈도우 부분은 계속 가져가면서 중복되지 않은 부분을 더하고 빼서 구한다.
			map.put(dna[start - 1], map.get(dna[start - 1]) - 1);	// 이전 윈도우의 맨 앞은 제외
			map.put(dna[start + P - 1], map.get(dna[start + P - 1]) + 1);	// 이전 윈도우의 바로 다음 문자 포함
			
			if (map.get('A') >= acgt[0] && map.get('C') >= acgt[1] 
					&& map.get('G') >= acgt[2] && map.get('T') >= acgt[3]) {
						ans++;
					}
			start++;
		}
		
		System.out.println(ans);
	}

}
