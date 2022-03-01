public class D4_단체사진찍기 {
    public static void main(String[] args) {
        String[] data = {"N~F=0", "R~T>2"};
        int n = 2;
        int res = solution(n, data);

        System.out.println(res);
    }
    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static char[] picture;
    static boolean[] selected;
    static int ans;

    static public int solution(int n, String[] data) {

        picture = new char[friends.length];
        selected = new boolean[friends.length];

        perm(0, data);

        return ans;
    }

    private static void perm(int cnt, String[] data) {

        if (cnt == friends.length){
            if(check(data)){
                ans++;
            }
        }

        for (int i = 0; i < friends.length; i++){
            if(selected[i]) continue;
            picture[cnt] = friends[i];
            selected[i] = true;
            perm(cnt+1, data);
            selected[i] = false;
        }

    }

    private static boolean check(String[] data) {
        for (String datum : data) {
            char op = datum.charAt(3);
            int from = 0, to = 0;
            for(int i = 0; i < friends.length; i++){
                if(datum.charAt(0) == picture[i]) from = i;
                if(datum.charAt(2) == picture[i]) to = i;
            }
            int dist = Math.abs(from-to);
            int dist_ = datum.charAt(4) - '0' + 1;

            if(op == '='){
                if(dist != dist_) return false;
            }else if(op == '<'){
                if(dist >= dist_) return false;
            }else if(op == '>'){
                if(dist <= dist_) return false;
            }
        }
        return true;
    }
}
