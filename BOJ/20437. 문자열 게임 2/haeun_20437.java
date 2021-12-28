import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20437_문자열게임2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());	// 문자열 게임의 수

    	for (int tc = 1; tc <= T; tc++) {
    		int[] alpha = new int[26];		// 문자 탐색
    		String W = br.readLine(); 	        // 문자열 W
    		int K = Integer.parseInt(br.readLine());// 특정 문자 K개 포함
    		int len = W.length();		         // 문자열 W의 길이
    		
    		// 문자열 W의 알파벳 파악
    		for (int i = 0; i < len; i++) alpha[W.charAt(i) - 'a']++;
    		
    		int min = Integer.MAX_VALUE;			// 가장 짧은 문자열의 길이
    		int max = Integer.MIN_VALUE;			// 가장 긴 문자열의 길이
    		
    		for (int i = 0; i < len; i++) {
    			// 탐색하려는 문자
    			int temp = W.charAt(i);
    			
    			// 만일 해당 문자가 K개 미만 존재할 경우 다음 문자 탐색
    			if (alpha[temp - 'a'] < K) continue;
    			// 몇개 존재하는지 탐색하기 위한 변수
    			int cnt = 0;

    			for (int j = i; j < len; j++) {
    				// 해당 문자가 존재할 시 cnt + 1
    				if (temp == W.charAt(j)) cnt++;
					// 만일 cnt값이 K개와 같다면
    				if (cnt == K) {
    					// min, max 값 갱신
    					min = Math.min(min, j - i + 1);
    					max = Math.max(max, j - i + 1);
    					break;
    				}
    			}
    		}

    		// 출력
    		if (min != Integer.MAX_VALUE) System.out.println(min + " " + max);
    		else System.out.println(-1);
    	}
	}
}
