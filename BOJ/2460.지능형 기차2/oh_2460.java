import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class oh_2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int min = Integer.parseInt(st.nextToken());
            int plus = Integer.parseInt(st.nextToken());
            sum += plus - min;
            max= Math.max(max,sum);
        }
        if(max>10000) max =10000;
        System.out.println(max);
    }
}
