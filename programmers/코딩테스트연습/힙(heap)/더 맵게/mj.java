import java.util.PriorityQueue;

public class D8_더맵게 {

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int solution = solution(scoville, K);
        System.out.println(solution);
    }

    static public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for (int i : scoville) {
            pq.offer(i);
        }

        // K == 0 return 0
        // b == 0 return -1

        while(pq.size() >= 2 && pq.peek() < K){
            int a = pq.poll();
            int b = pq.poll();
            int k = a+b*2;
            if(k == 0) {
                // 계속 0이 나올 경우
                answer = -1;
                break;
            }
            pq.offer(k);
            answer++;
        }

        // 하나 밖에 남지 않으면 계속 진행이 어렵다.
        if (pq.size() == 1){
            int a = pq.poll();
            if(a < K) answer = -1;
        }

        return answer;
    }
}
