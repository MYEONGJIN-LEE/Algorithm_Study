package high_score_kit.hash;

import java.util.Collection;
import java.util.HashMap;

public class Spy_Level_2 {

	public static int spy_Level_2(String[][] clothes) {
		int answer = 1;

		HashMap<String, Integer> map = new HashMap<>();
		for (String[] cloth : clothes) {
			map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
		}

		Collection<Integer> mapValue = map.values();
		for(Integer value : mapValue) {
			answer *= (value + 1);
		}

		return answer - 1;
	}

	public static void main(String[] args) {
		// Sample 1
		{
			String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
					{ "green_turban", "headgear" } };
			int answer = 5;
			int result = spy_Level_2(clothes);

			if (result == answer) {
				System.out.println("Pass Sample-1");
			} else {
				System.out.println("Fail Sample-1");
				System.out.println("[Expected] : " + answer);
				System.out.println("[Value] : " + result);
			}
		}
		// Sample 2
		{
			String[][] clothes = { { "crowmask", "face" }, { "bluesunglasses", "face" }, { "smoky_makeup", "face" } };
			int answer = 3;
			int result = spy_Level_2(clothes);

			if (result == answer) {
				System.out.println("Pass Sample-2");
			} else {
				System.out.println("Fail Sample-2");
				System.out.println("[Expected] : " + answer);
				System.out.println("[Value] : " + result);
			}
		}
	}

}
