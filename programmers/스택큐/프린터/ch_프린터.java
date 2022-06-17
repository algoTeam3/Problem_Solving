import java.util.Collections;
import java.util.PriorityQueue;

public class ch_프린터 {
    public static void main(String[] args) {
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < priorities.length; i++){
            pq.add(priorities[i]);
        }

        while(!pq.isEmpty()){
            for(int i = 0; i < priorities.length; i++){
                if(pq.peek() == priorities[i]){
                    if(i == location){
                        return answer;
                    }
                    answer++;
                    pq.poll();
                }
            }
        }

        return answer;
    }
}
