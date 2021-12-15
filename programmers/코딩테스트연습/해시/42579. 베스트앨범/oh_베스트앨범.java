package programmers;

import java.util.*;

public class oh_베스트앨범 {
    static class num implements Comparable<num>{
        int index;
        int vol;

        num(int index,int vol){
            this.index = index;
            this.vol = vol;
        }


        @Override
        public int compareTo(num o) {
            if(o.vol==this.vol){
                return this.index-o.index;
            }
            return o.vol-this.vol;
        }
    }
    public static void main(String[] args) {
        int[] answer =solution(new String[]{"classic","classic", "classic", "pop"},new int[]{800, 150, 150, 2500});
        Arrays.stream(answer).forEach(value -> System.out.println(value));
    }

    public static int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> map1 = new HashMap<>();
        //어떤 장르가 얼마나 재생됐나
        for (int i = 0; i < genres.length; i++) {
            map1.put(genres[i],map1.getOrDefault(genres[i],0)+plays[i]);
        }
        //장르 중에 어떤 플레이 리스트가 많이 재생되었나
        HashMap<String, PriorityQueue<num>> map2 = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            //같은 장르면 기존 que에 넣기
            if(map2.containsKey(genres[i])){
               PriorityQueue<num> que =map2.get(genres[i]);
               que.add(new num(i,plays[i]));
                map2.put(genres[i],que);

            }else{
                PriorityQueue<num> que = new PriorityQueue<>();
                que.add(new num(i,plays[i]));
                map2.put(genres[i],que);
            }

        }

        Map<String,String> map3 = new HashMap();
        for (String s : map1.keySet()) {
            map3.put(s, Integer.toString(map1.get(s)));
            map3.put(Integer.toString(map1.get(s)),s);
        }
        PriorityQueue<Integer> priority = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (String m : map1.keySet()) {
            priority.add(map1.get(m));
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while (!priority.isEmpty()){
            String nums = Integer.toString(priority.poll());
            String gen=map3.get(nums);
            if(map2.get(gen).size()==1){
                answer.add(map2.get(gen).poll().index);
            }else{
                answer.add(map2.get(gen).poll().index);
                answer.add(map2.get(gen).poll().index);
            }
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i]=answer.get(i);
        }

        return result;
    }
}
