import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Expert1234 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            Stack<Integer> stack = new Stack<>();
            String str = st.nextToken();
            for (int j = 0; j < N; j++) {
                if (!stack.isEmpty()&&stack.peek() == Character.getNumericValue(str.charAt(j))) {
                    stack.pop();
                } else {
                    stack.push(Character.getNumericValue(str.charAt(j)));
                }

            }
            System.out.print("#" + test_case+" ");
            for (Integer n : stack) {
                System.out.printf("%d",n);
            }
            System.out.println();

        }
    }
}
