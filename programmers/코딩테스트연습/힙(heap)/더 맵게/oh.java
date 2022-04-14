import java.util.*;

class Solution {
    public static int solution(int[] scoville, int K) {
        int count =0;
        PriorityQueue<Integer> que = new PriorityQueue();
        for (int i : scoville) {
            que.add((i));
        }
        while(true){
            boolean flag = true;
            
            if(que.peek()>=K){
                break;
            }
            if(que.size()==1){
                count =-1;
                break;
            }
            int frist = que.poll();
            int second = que.poll();
            que.add(frist+second*2);
            count++;
        }
        return count;
    }
}
