public class D5_멀쩡한사각형 {

    public static void main(String[] args) {

        int w = 8;
        int h = 12;
        long res = solution(w, h);
        System.out.println(res);
    }

    //HxW 사용할 수 있는 정사각형의 개수
    static public long solution(int w, int h) {
        long answer = 1;
        int gcd = 0;
        int small = w>h?w:h;
        for(int i = small; i > 0; i--){
            if(w%i==0 && h%i==0){
                gcd = i;
                break;
            }
        }
        System.out.println(gcd);
        answer = w*h-(w+h)+gcd;
        return answer;
    }

}
