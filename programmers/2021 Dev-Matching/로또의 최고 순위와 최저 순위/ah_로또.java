package Programmers;

public class ah_로또{
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		int[] rank = { 6, 6, 5, 4, 3, 2, 1 };
		int zero = 0;
		int min = 0;

		for (int i = 0; i < lottos.length; i++) {
			if (lottos[i] == 0) {
				zero++;
			}
			for (int j = 0; j < win_nums.length; j++) {
				if (lottos[i] == win_nums[j]) {
					min++;
				}
			}
		}
		answer[0] = rank[zero + min];
		answer[1] = rank[min];

		return answer;
	}
}
