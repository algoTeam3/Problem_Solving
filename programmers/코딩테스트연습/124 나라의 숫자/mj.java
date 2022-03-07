public class D6_124나라의숫자 {

    public static void main(String[] args) {
        int n = 4;
        String ans = solution(n);
        System.out.println(ans);
    }

    static public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int[] Ns = {1,2,4};

        while(true){
            if(n-1 < 3){
                answer.insert(0, Ns[n-1]);
                break;
            }
            answer.insert(0, Ns[(n-1)%3]);
            // 더 큰자리가 나온다면
            n = (n-1)/3;

        }
        return answer.toString();
    }
}
