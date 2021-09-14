import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert1232 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input\\input1232.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int num = Integer.parseInt(br.readLine());
            String[] str = new String[num];
            for (int i = 0; i < str.length; i++) {
                str[i] = br.readLine();
            }
            int[] arr = new int[num + 1];
            for (int i = str.length - 1; i >= 0; i--) {
                if (str[i].contains("/") || str[i].contains("*") || str[i].contains("-") || str[i].contains("+")) {
                    StringTokenizer st = new StringTokenizer(str[i]);
                    int pos = Integer.parseInt(st.nextToken());
                    String sign = st.nextToken();
                    int num1 = Integer.parseInt(st.nextToken());
                    int num2 = Integer.parseInt(st.nextToken());
                    switch (sign) {
                        case "+":
                            arr[pos] = arr[num1] + arr[num2];
                            break;
                        case "-":
                            arr[pos] = arr[num1] - arr[num2];
                            break;
                        case "/":
                            arr[pos] = arr[num1] / arr[num2];
                            break;
                        case "*":
                            arr[pos] = arr[num1] * arr[num2];
                            break;

                    }
                } else {
                    StringTokenizer st = new StringTokenizer(str[i]);
                    int pos = Integer.parseInt(st.nextToken());
                    int num3 = Integer.parseInt(st.nextToken());
                    arr[pos] = num3;

                }
            }
            System.out.println("#" + test_case + " " + arr[1]);
        }


    }
}
