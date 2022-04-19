class chan {
    public int solution(int[] nums) {
        int answer = 0;
        int pickNum = nums.length / 2;
        
        System.out.println(pickNum);
        
        boolean[] type = new boolean[200001];
        
        for (int i = 0; i < nums.length; i++) {
            type[nums[i]] = true;
        }
        
        // true 개수 세기
        int cnt = 0;
        for (int i = 1; i < type.length; i++) {
            if (type[i]) cnt++;
        }
        
        System.out.println(cnt);
        
        if (cnt <= pickNum) answer = cnt;
        else answer = pickNum;
        
        return answer;
    }
}