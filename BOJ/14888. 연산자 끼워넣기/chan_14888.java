import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chan_14888 {
    static int N, max, min;
    static boolean[] isSelected;
    static int[] input;
    static char[] op, selectOp;
    static char[] operation = { '+', '-', '*', '/' };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 주어지는 수의 개수
        min = Integer.MAX_VALUE; // 출력할 최솟값
        max = Integer.MIN_VALUE; // 출력할 최댓값
        isSelected = new boolean[N - 1]; // 주어진 연산자에서 배열에서 그 연산자가 순열에 뽑힌 상태인지 체크하는 배열
        input = new int[N]; // 주어진 N개의 수
        selectOp = new char[N - 1]; // 연산자 순열(경우의 수)을 저장할 배열
        op = new char[N - 1]; // 주어진 연산자

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        } // N개의 수 입력받기

        String[] opCntStr = br.readLine().split(" ");
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            int opCnt = Integer.parseInt(opCntStr[i]);
            while (opCnt-- > 0) {
                op[idx++] = operation[i];
            }
        } // 주어진 연산자 개수대로 연산자 배열에 저장

        perm(0); // 연산자 순열 경우의 수 뽑으러 가기

        System.out.println(max);
        System.out.println(min);

    }

    private static void perm(int cnt) {
        // 기저조건 : 연산자 수는 (주어진 수 - 1)개이다.
        if (cnt == N - 1) {
            int curResult = input[0];
            for (int i = 0; i < N - 1; i++) {
                char curOp = selectOp[i]; // i번째 연산자
                switch (curOp) {
                case '+': // +일 때
                    curResult += input[i + 1];
                    break;
                case '-': // -일 때
                    curResult -= input[i + 1];
                    break;
                case '*': // *일 때
                    curResult *= input[i + 1];
                    break;
                case '/': // -일 때
                    if (curResult < 0) { // 음수일 때는 -1을 곱했다가 나눗셈 후 다시 몫에 -1 곱해주기
                        curResult *= (-1);
                        curResult /= input[i + 1];
                        curResult *= (-1);
                    } else {
                        curResult /= input[i + 1];
                    }
                    break;
                }
            }
            if (curResult > max)
                max = curResult;
            if (min > curResult)
                min = curResult;
            return;
        }

        // 가능한 연산자 배치 모두 해보는 연산자 순열
        for (int i = 0; i < N - 1; i++) {
            if (isSelected[i])
                continue;

            selectOp[cnt] = op[i];
            isSelected[i] = true;

            perm(cnt + 1);
            isSelected[i] = false;
        }

    }
}
