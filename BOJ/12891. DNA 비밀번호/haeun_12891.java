import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간초과..
public class BOJ_12891_DNA비밀번호 {
	
	public static int[] ACGT;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;		// 만들 수 있는 비밀번호의 종류의 수
		
		int S = Integer.parseInt(st.nextToken());	// DNA 문자열 길이
		int P = Integer.parseInt(st.nextToken());	// 부분문자열의 길이
		String str = br.readLine();					// 임의로 만든 DNA 문자열
		
		// {'A', 'C', 'G', 'T'}의 최소 개수
		ACGT = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			ACGT[i] = Integer.parseInt(st.nextToken());
		}
		
		// 슬라이딩 윈도우
		int left = 0;
		int right = left + P;
		
		while (right <= S) {
			// 문자열 확인 후 사용가능하면 cnt + 1
			String temp = str.substring(left, right);
			if (check(temp)) cnt++;
			
			// 이동
			left++;
			right++;
		}
		
		// 출력
		System.out.println(cnt);
	}
	
	// 사용 가능한 비밀번호인지 확인
	public static boolean check (String temp) {
		int[] arr = new int[4];
		
		// {'A', 'C', 'G', 'T'} 등장 횟수
		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) == 'A') arr[0]++;
			else if (temp.charAt(i) == 'C') arr[1]++;
			else if (temp.charAt(i) == 'G') arr[2]++;
			else if (temp.charAt(i) == 'T') arr[3]++;
		}
		
		// 조건을 다 만족하는지 확인
		for (int i = 0; i < arr.length; i++) {
			// 조건 불만족
			if (arr[i] < ACGT[i]) return false;
		}
		
		// 조건 만족
		return true;
	}
}
