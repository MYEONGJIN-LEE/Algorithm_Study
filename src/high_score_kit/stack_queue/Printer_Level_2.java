package high_score_kit.stack_queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Printer_Level_2 {
	public static int printer_Level_2(int[] priorities, int location) {
		int answer = 0;
		
		List<Integer> list = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Boolean> tq = new LinkedList<Boolean>();
		
		for(int i=0;i<priorities.length;i++) {
			list.add(priorities[i]);
			q.offer(priorities[i]);
			if(i==location) {
				tq.offer(true);
			} else {
				tq.offer(false);
			}
		}
		
		Collections.sort(list, (o1,o2) -> (o2-o1));
		
		while(!q.isEmpty()) {
			int target = q.poll();
			boolean isIt = tq.poll();

			if(target == list.get(answer)) {
				answer ++;
				if(isIt) {
					break;
				}
			} else {
				q.offer(target);
				tq.offer(isIt);
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// Sample 1
		{
			int[] priorities = { 2, 1, 3, 2 };
			int location = 2;
			int answer = 1;
			int result = printer_Level_2(priorities, location);
			if (answer == result) {
				System.out.println("Pass Sample-1");
			} else {
				System.out.println("Fail Sample-1");
				System.out.println("[Expected] : " + answer);
				System.out.println("[Value] : " + result);
			}
		}

		// Sample 2
		{
			int[] priorities = { 1, 1, 9, 1, 1, 1 };
			int location = 0;
			int answer = 5;
			int result = printer_Level_2(priorities, location);
			if (answer == result) {
				System.out.println("Pass Sample-2");
			} else {
				System.out.println("Fail Sample-2");
				System.out.println("[Expected] : " + answer);
				System.out.println("[Value] : " + result);
			}
		}

	}

}
