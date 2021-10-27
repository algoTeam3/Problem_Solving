import java.io.BufferedReader;
import java.io.InputStreamReader;

public class chan_2529 {

    static int k;
    static long max, min;
    static int[] numbers, ansNum;
    static boolean[] isSelected;
    static String[] input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        numbers = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // 부등호 기호 앞뒤에 넣을 수 있는 숫자
        isSelected = new boolean[10]; // 숫자가 선택됐는지 체크하기 위한 배열
        ansNum = new int[k + 1]; // k+1개의 숫자를 뽑아서 담을 배열
        max = 0;
        min = Long.MAX_VALUE;
        perm(0);

        System.out.println(max);
        // 첫자리가 0인 경우 출력에 포함하기
        if (min / Math.pow(10, k) < 1) {
            System.out.print("0");
        }
        System.out.println(min);
    }

    // 순열
    private static void perm(int cnt) {
        if (cnt == (k + 1)) {
            // 배열의 원소들을 모두 하나의 수로 붙이기
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < cnt; i++) {
                sb.append(ansNum[i]);
            }
            // 붙인 문자열을 long타입 숫자로 변환
            long current = Long.parseLong(sb.toString());
            if (current > max)
                max = current;
            if (min > current)
                min = current;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (isSelected[i])
                continue;

            ansNum[cnt] = numbers[i];
            // 부등호 관계를 만족하지 않으면 continue(백트래킹)
            if (cnt > 0) {
                if ("<".equals(input[cnt - 1])) {
                    if (ansNum[cnt - 1] > ansNum[cnt])
                        continue;
                } else if (">".equals(input[cnt - 1])) {
                    if (ansNum[cnt - 1] < ansNum[cnt])
                        continue;
                }
            }
            isSelected[i] = true;

            perm(cnt + 1);
            isSelected[i] = false;
        }
    }

}
