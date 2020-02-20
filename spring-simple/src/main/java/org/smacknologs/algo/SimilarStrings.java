package org.smacknologs.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimilarStrings {

   /*
    * Complete the 'isSimilar' function below.
    *
    * The function is expected to return a BOOLEAN.
    * The function accepts following parameters:
    *  1. STRING_ARRAY sentence_1
    *  2. STRING_ARRAY sentence_2
    *  3. 2D_STRING_ARRAY similarity_matrix
    */

   public static boolean isSimilar(List<String> sentence_1, List<String> sentence_2, List<List<String>> similarity_matrix) {
		// Write your code here
		if (sentence_1.size() != sentence_2.size())
			return false;
		
		Map<String, String> lookUp = new HashMap<>();
		for (List<String> list : similarity_matrix) {
			lookUp.put(list.get(0), list.get(1));
		}

		Map<String, List<String>> dict =  new HashMap<>();
		
		for (String key : lookUp.keySet()) {
			List<String> words = new ArrayList<>();
			String tmp = key;
			while (lookUp.containsKey(tmp)) {
				tmp = lookUp.get(tmp);
				words.add(tmp);
			}
			dict.put(key, words);
		}

		for (int i = 0; i < sentence_1.size(); i++) {
			String one = sentence_1.get(i);
			String two = sentence_2.get(i);
			if(null != dict.get(one) && !dict.get(one).contains(two)) {
				if(null != dict.get(two) && !dict.get(two).contains(one))
					return false;
			}
			else if(null != dict.get(two) && !dict.get(two).contains(one))
					return false;
		}
		return true;
   }
   
   public static void main(String[] args) {
   	
   	List<String> one = new ArrayList<>();
   	one.add("amazing");
   	one.add("acting");
   	one.add("abilities");
   	List<String> two = new ArrayList<>();
   	two.add("fine");
   	two.add("theatrics");
   	two.add("talent");
   	
   	
   	List<List<String>> sim = new ArrayList<>();
   	sim.add(Arrays.asList(new String[] {"amazing", "fine"}));
   	sim.add(Arrays.asList(new String[] {"fine", "good"}));
   	sim.add(Arrays.asList(new String[] {"acting", "theatrics"}));
   	sim.add(Arrays.asList(new String[] {"abilities", "talent"}));
   	
   	System.out.println(isSimilar(one, two, sim));
		
	}

}