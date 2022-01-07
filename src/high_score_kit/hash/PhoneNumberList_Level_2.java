package high_score_kit.hash;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PhoneNumberList_Level_2 {
	public static boolean phoneNumberList_Level_2(String[] phone_book) {
		boolean answer = true;

		List<String> phoneBook = Arrays.asList(phone_book);
		Collections.sort(phoneBook);

		for (int i = 0; i < phoneBook.size() - 1; i++) {
			String phone = phoneBook.get(i);
			String target = phoneBook.get(i + 1);

			if (target.startsWith(phone) == true) {
				answer = false;
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		// Sample 1
		{
			String[] phone_book = { "119", "1195524421", "97674223" };
			boolean answer = false;
			boolean result = phoneNumberList_Level_2(phone_book);
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
			String[] phone_book = { "123", "456", "789" };
			boolean answer = true;
			boolean result = phoneNumberList_Level_2(phone_book);
			if (result == answer) {
				System.out.println("Pass Sample-2");
			} else {
				System.out.println("Fail Sample-2");
				System.out.println("[Expected] : " + answer);
				System.out.println("[Value] : " + result);
			}
		}

		// Sample 3
		{
			String[] phone_book = { "12", "123", "1235", "567", "88" };
			boolean answer = false;
			boolean result = phoneNumberList_Level_2(phone_book);
			if (result == answer) {
				System.out.println("Pass Sample-3");
			} else {
				System.out.println("Fail Sample-3");
				System.out.println("[Expected] : " + answer);
				System.out.println("[Value] : " + result);
			}
		}

	}
}
