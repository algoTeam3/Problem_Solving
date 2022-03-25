import java.util.PriorityQueue;

public class ch_42626 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    private static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            pq.offer(scoville[i]);
        }

        for (int i = 0; i < pq.size(); i++) {
            if (pq.size() == 1) return -1;
            if (pq.peek() >= K) break;
            int temp = pq.poll();
            int temp2 = pq.poll();
            pq.offer(temp + (temp2 * 2));
            answer++;
        }
        return answer;
    }
}