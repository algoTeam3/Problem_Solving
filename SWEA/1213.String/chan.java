import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class chan {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			String searching = br.readLine();
			String sentence = br.readLine();
			int ans = 0;
			
			for (int i = 0; i <= sentence.length() - searching.length(); i++) {
				if (searching.equals(sentence.substring(i, i + searching.length()))) ans++;
			}
			
			System.out.printf("#%d %d%n", tc, ans);
		}
	}

}
