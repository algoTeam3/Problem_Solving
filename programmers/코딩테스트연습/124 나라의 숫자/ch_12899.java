public class ch_12899 {
    public String solution(int n) {
        String[] num = {"4", "1", "2"};
        String answer = "";

        while (n > 0) {
            answer = num[n % 3] + answer;
            // 3으로 나누어 떨어질 땐 -1
            n = (n - 1) / 3;
        }
        return answer;
    }
}
