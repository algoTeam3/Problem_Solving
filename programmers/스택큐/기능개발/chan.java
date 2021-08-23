import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
class chan {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int left = 100 - progresses[i];
            int funcDays = left / speeds[i];
            if (left % speeds[i] != 0) funcDays += 1;
            queue.offer(funcDays);
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            int howmany = 1;
                while (!queue.isEmpty() && queue.peek() <= cur) {
                    queue.poll();
                    howmany++;
                }
            
            list.add(howmany);
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer; 
    }
}