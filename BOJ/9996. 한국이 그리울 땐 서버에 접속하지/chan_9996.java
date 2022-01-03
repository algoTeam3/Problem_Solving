import java.io.BufferedReader;
import java.io.InputStreamReader;

public class chan_9996 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String pattern = br.readLine();
		pattern = pattern.replace("*", "[a-z]*");
		for (int t = 0; t < T; t++) {
			String fileName = br.readLine().trim();
			boolean result = fileName.matches(pattern);	// 비교할 문자열.matches(regex) 순서 지키기
			if (result) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}
			
		}
	}

}
