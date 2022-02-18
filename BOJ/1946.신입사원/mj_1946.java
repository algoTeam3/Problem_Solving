import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class W2_1946 {

    /**
     * 인재 선발은 1차 서류심사와 2차 면접시험으로 이루어진다.
     * 다른 모든 지원자와 비교했을 때 서류와 면접 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발
     */
    static class Score implements Comparable<Score> {
        int one;
        int two;

        public Score(int one, int two) {
            this.one = one;
            this.two = two;
        }

        @Override
        public int compareTo(Score o) {
            return this.one - o.one;
        }
    }

    static int N, ans;
    static ArrayList<Score> scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());
            ans = 0;
            scores = new ArrayList<>();
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                scores.add(new Score(a,b));
            }

            Collections.sort(scores);
            ans++;
            int k = scores.get(0).two;
            for(int j = 1; j < N; j++){
                if(scores.get(j).two < k){
                    ans++;
                    k = scores.get(j).two;
                }
            }
            System.out.println(ans);
        }
    }
}
