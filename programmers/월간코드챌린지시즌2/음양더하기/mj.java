public class D8_음양더하기 {

    public static void main(String[] args) {
        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};

        int ans = solution(absolutes, signs);
        System.out.println(ans);

    }

    static public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            int k = absolutes[i];
            if(!signs[i]) k *= -1;
            answer += k;
        }

        return answer;
    }
}
