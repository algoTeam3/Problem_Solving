class ch_약수의개수와덧셈 {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            int primeN = getPrimeNum(i);
            if(primeN % 2 == 0){
                answer += i;
            }else {
                answer -= i;
            }
        }
        return answer;
    }

    public int getPrimeNum(int N){
        int primeCnt = 1;

        for(int i = 1; i < N; i++){
            if(N % i == 0) primeCnt++;
        }
        return primeCnt;
    }
}