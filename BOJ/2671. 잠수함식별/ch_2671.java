import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class ch_2671 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 엔진소리 패턴 : (100~1~|01)~
        String pattern = "(100+1+|01)+";

        if (Pattern.matches(pattern, br.readLine())) System.out.println("SUBMARINE");
        else System.out.println("NOISE");
    }
}
