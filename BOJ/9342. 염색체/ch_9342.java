import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class ch_9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // () : 한 문자로 인식
        // ? : 앞 문자가 없거나 하나
        // + : 앞 문자가 하나 이상
        // $ : 문자열 종료
        String pattern = "(A|B|C|D|E|F)?A+F+C+(A|B|C|D|E|F)?$";

        for (int t = 0; t < T; t++) {
            if (Pattern.matches(pattern, br.readLine())) System.out.println("Infected!");
            else System.out.println("Good");
        }
    }
}
