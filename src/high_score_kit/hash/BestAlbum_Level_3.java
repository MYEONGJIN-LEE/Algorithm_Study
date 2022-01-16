package high_score_kit.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BestAlbum_Level_3 {

	public static int[] bestAlbum_Level_3(String[] genres, int[] plays) {
		int[] answer = {};
		List<Integer> answerList = new ArrayList<Integer>();
		
		int length = genres.length;

		// 속한 노래가 많이 재생된 장르 찾기
		HashMap<String, Integer> fnGenres = new HashMap<>();
		for (int i = 0; i < length; i++) {
			fnGenres.put(genres[i], fnGenres.getOrDefault(genres[i], 0) + plays[i]);
		}

		List<String> sortedGenres = new ArrayList<String>(fnGenres.keySet());
		Collections.sort(sortedGenres, (o1, o2) -> (fnGenres.get(o2) - fnGenres.get(o1)));

		// 장르 내에서 많이 재생된 노래
		for (String genre : sortedGenres) {
			// key : 고유번호 value : 재생횟수   
			HashMap<Integer, Integer> fnPlays = new HashMap<Integer, Integer>();
			for (int i = 0; i < length; i++) {
				if (genre.equals(genres[i])) {
					fnPlays.put(i, plays[i]);
				}
			}

			List<Integer> sortedPlays = new ArrayList<Integer>(fnPlays.keySet());
			Collections.sort(sortedPlays, (o1,o2) -> (fnPlays.get(o2)- fnPlays.get(o1)));

			for(int i=0;i<sortedPlays.size();i++) {
				answerList.add(sortedPlays.get(i));
				if(i==1) {
					break;
				}
			}
		}
		
		answer = new int[answerList.size()];
		for(int i=0;i<answerList.size();i++) {
			answer[i] = answerList.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		// Sample 1
		{
			String[] genres = { "classic", "pop", "classic", "classic", "pop" };
			int[] plays = { 500, 600, 150, 800, 2500 };
			int[] answer = { 4, 1, 3, 0 };
			int[] result = bestAlbum_Level_3(genres, plays);

			if (Arrays.equals(result, answer)) {
				System.out.println("Pass Sample-1");
			} else {
				System.out.println("Fail Sample-1");
				System.out.println("[Expected] : " + answer);
				System.out.println("[Value] : " + result);
			}
		}
	}

}
