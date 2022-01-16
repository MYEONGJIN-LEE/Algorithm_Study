package high_score_kit.stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Function_Develop_Level_2 {

	public static int[] function_Develop_Level_2(int[] progresses, int[] speeds) {
		int[] answer = {};
		List<Integer> ansList = new ArrayList<Integer>();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<progresses.length;i++) {
			queue.offer(progresses[i]);
		}
		
		int popNum = 0;
		while(!queue.isEmpty() ) {
			int ans = 0;
			for(int i=popNum;i<speeds.length;i++) {
				Integer progress = queue.poll();
				queue.offer(progress + speeds[i]);
			}
			
			boolean isComplete = false;
			while(!queue.isEmpty() && queue.peek() >= 100) {
				queue.poll();
				popNum++;
				ans ++;
				isComplete = true;
			}
			
			if(isComplete) {
				ansList.add(ans);
			}
		}
		
		answer = new int[ansList.size()];
		for(int i=0;i<ansList.size();i++) {
			answer[i] = ansList.get(i);
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// Sample 1
		{
			int[] progresses = { 93, 30, 55 };
			int[] speeds = { 1, 30, 5 };
			int[] answer = { 2, 1 };
			int[] result = function_Develop_Level_2(progresses, speeds);
			if (Arrays.equals(answer, result) ) {
				System.out.println("Pass Sample-1");
			} else {
				System.out.println("Fail Sample-1");
				System.out.println("[Expected] : " + answer);
				System.out.println("[Value] : " + result);
			}
		}

		// Sample 2
		{
			int[] progresses = { 95, 90, 99, 99, 80, 99 };
			int[] speeds = { 1, 1, 1, 1, 1, 1 };
			int[] answer = { 1, 3, 2 };
			int[] result = function_Develop_Level_2(progresses, speeds);
			if (Arrays.equals(answer, result)) {
				System.out.println("Pass Sample-2");
			} else {
				System.out.println("Fail Sample-2");
				System.out.println("[Expected] : " + answer);
				System.out.println("[Value] : " + result);
			}
		}

	}

}
