package high_score_kit.hash;

import java.util.HashMap;

public class NotCompletePlayer_Level_1 {

	public static String notCompletePlayer_Level_1(String[] participant, String[] completion) {

//		// Solution 1
//		Arrays.sort(participant);
//		Arrays.sort(completion);
//		
//		int i = 0;
//		for(i=0;i<completion.length;i++) {
//			if(!participant[i].equals(completion[i])) {
//				break;
//			}
//		}
//		
//		return participant[i];
		
		// Solution 2 by Hash
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();
		for(String part : participant) {
			map.put(part, map.getOrDefault(part, 0) + 1);
		}
		for(String comp: completion) {
			map.put(comp, map.get(comp) - 1);
		}
		
		for (String key : map.keySet()) {
			if(map.get(key) != 0) {
				answer = key;
				break;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// Sample 1
		{
			String[] participant = { "leo", "kiki", "eden" };
			String[] completion = { "eden", "kiki" };
			String answer = "leo";
			String result = notCompletePlayer_Level_1(participant, completion);
			if (result.compareTo(answer) == 0) {
				System.out.println("Pass Sample-1");
			} else {
				System.out.println("Fail Sample-1");
				System.out.println("[Expected] : " + answer);
				System.out.println("[Value] : " + result);
			}
		}
		{
			// Sample 2
			String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
			String[] completion = { "josipa", "filipa", "marina", "nikola" };
			String answer = "vinko";
			String result = notCompletePlayer_Level_1(participant, completion);
			if (result.compareTo(answer) == 0) {
				System.out.println("Pass Sample-2");
			} else {
				System.out.println("Fail Sample-2");
				System.out.println("[Expected] : " + answer);
				System.out.println("[Value] : " + result);
			}
		}
		{
			// Sample 3
			String[] participant = { "mislav", "stanko", "mislav", "ana" };
			String[] completion = { "stanko", "ana", "mislav" };
			String answer = "mislav";
			String result = notCompletePlayer_Level_1(participant, completion);
			if (result.compareTo(answer) == 0) {
				System.out.println("Pass Sample-3");
			} else {
				System.out.println("Fail Sample-3");
				System.out.println("[Expected] : " + answer);
				System.out.println("[Value] : " + result);
			}
		}
	}

}
