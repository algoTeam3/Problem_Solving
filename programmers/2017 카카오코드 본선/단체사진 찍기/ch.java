import java.util.*;

class ch {
    static HashMap<Character, Integer> kakaos;
    static int[] list;
    static int answer;
    static boolean[] visited;
    static String[] s_data;
    public int solution(int n, String[] data) {
        s_data = data;

        kakaos = new HashMap<Character, Integer>();
        list = new int[8];
        visited = new boolean[8];

        kakaos.put('A', 0);
        kakaos.put('C', 1);
        kakaos.put('F', 2);
        kakaos.put('J', 3);
        kakaos.put('M', 4);
        kakaos.put('N', 5);
        kakaos.put('R', 6);
        kakaos.put('T', 7);
        answer = 0;

        perm(0);
        return answer;
    }

    private static void perm(int cnt){
        if(cnt == 8){
            if(check()){
                answer++;
            }
        }

        for(int i = 0; i < 8; i++){
            if(visited[i]) continue;

            visited[i] = true;
            list[cnt] = i;
            perm(cnt + 1);
            visited[i] = false;
        }
    }

    private static boolean check(){
        for(String str : s_data){
            int first = list[kakaos.get(str.charAt(0))];
            int second = list[kakaos.get(str.charAt(2))];
            char op = str.charAt(3);
            int w = str.charAt(4) - '0' + 1;

            int dist = Math.abs(first - second);

            if(op == '='){
                if(dist != w) {
                    return false;
                }
            }else if(op == '>'){
                if(dist <= w) {
                    return false;
                }
            } else if(dist >= w) {
                return false;
            }
        }
        return true;
    }
}