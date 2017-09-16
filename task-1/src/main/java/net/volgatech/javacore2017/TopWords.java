package net.volgatech.javacore2017;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class TopWords {

	private static Integer m_maxFrequencyOccurrence = 0;
	private static ArrayList<HashSet<String>> m_result = new ArrayList<>();

	private static boolean isExists(ArrayList<HashSet<String>> result, Integer value) throws IndexOutOfBoundsException {

		try {

			return result.get(value) != null;

		}
		catch (IndexOutOfBoundsException e){
			return false;
		}
		
	}

	private static boolean isExists(HashMap<String, Integer> result, String value) {

		return result.get(value) != null;
		
	}

	private static HashMap<String, Integer> getWords(String fileName) throws FileNotFoundException {
			HashMap<String, Integer> hashMap = new HashMap<>();
			String ENCODING = "utf-8";

			Scanner stream = new Scanner(new File(fileName), ENCODING);

	        for(String word; stream.hasNext();) {
	            word = (stream.next()).toLowerCase();

	            Integer value = isExists(hashMap, word) ? (hashMap.get(word) + 1) : 1;

	            if (value > m_maxFrequencyOccurrence) {
	            	m_maxFrequencyOccurrence = value;
	            }

	            hashMap.put(word, value);
	        }
	        stream.close();
	        return hashMap;   	

	}


	private static void initialization() {

		for (Integer i = 0; i<(m_maxFrequencyOccurrence + 1); ++i) {
			m_result.add(null);
		}
	}

	private static void formResult(HashMap<String, Integer> hashMap) {

		 for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
		    String key = entry.getKey();
		    Integer value = entry.getValue();
		    HashSet<String> tmp = new HashSet<>();
		    
		    if(isExists(m_result, value)) {

		    	tmp = m_result.get(value);
		    }
		    tmp.add(key);
			
		    m_result.set(value, tmp);
		}
	}

	private static void printResult(Integer k) {

		 for (Integer i = k, j = m_maxFrequencyOccurrence; i != 0; --j) {

			HashSet<String> tmpRes = new HashSet<>();
			if(isExists(m_result, j)) {
		    	tmpRes = m_result.get(j);
		    	for (String word : tmpRes) {
		    		System.out.println(word + " " + j);
		    		if((--i) == 0) {break;}
		    	}
		    }

		}
	}

	
	public static void main(String[] args) {

		try {
			// если не 2 арг бросим искл 
			if (args.length != 2)
			{
				throw new Exception("incorrect number of arguments");
			}

			HashMap<String, Integer> hashMap = getWords(args[0]);

			Integer k = Integer.parseInt(args[1]);
			//
			if (k > hashMap.size())
			{
				throw new Exception("incorrect data");
			}
			initialization();
			formResult(hashMap);
			printResult(k);

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}
}