import java.io.BufferedReader;
import java.io.InputStreamReader;

public class chan_9342 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String regex = "[A-F]?A+F+C+[A-F]?$";
			String dna = br.readLine();
			boolean result = dna.matches(regex);
			if (result) {
				System.out.println("Infected!");
			} else {
				System.out.println("Good");
			}
		}
	}

}
