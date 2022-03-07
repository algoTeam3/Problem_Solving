class chan {
    public String solution(int n) {
        String answer = "";
        int k = 0;

        while (n > 0) {
            k = n % 3; //나머지  - 자릿수 (낮은자리부터)
            n = n / 3; //몫        - 다음루프의 피제수
            if (k == 0) {
                n = n-1; //자리올림을 안 하는 효과
                k = 4;
            }
            answer = k + answer;
        }
        return answer;
    }
}