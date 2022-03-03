class chan_62048 {
    public long solution(int w, int h) {
        // int 자료형을 long으로 바꿔준 후 계산해야 오차가 안 생김
        return (long)w * h - (w + h - gcd(w, h));
    }
    
    public long gcd(int a, int b) {
        long answer = 0;
        
        long x = (a > b) ? b : a;
        for (int i = 1; i <= x; i++) {
            if (a % i == 0 && b % i == 0) {
                answer = i;
            }
        }
        return answer;
    }
}