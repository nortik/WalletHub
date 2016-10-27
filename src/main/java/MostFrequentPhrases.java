import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MostFrequentPhrases {
	
	public List<Map.Entry<String,Integer>> getMostFrequentPhrases(String filePath) {
        Map<String, Integer> occurrences = new HashMap<>();
		
        FileInputStream inputStream = null;
		Scanner sc = null;        
		
		try {
		    try {
				inputStream = new FileInputStream(filePath);
			} catch (FileNotFoundException e) {
				//doesn't exist
				e.printStackTrace();
			}
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
                String[] phrases = line.split("\\|");
                for (String phrase: phrases) {
                    if (!occurrences.containsKey(phrase.trim())) {
                        occurrences.put(phrase.trim(), 1);
                    } else {
                        occurrences.put(phrase.trim(), occurrences.get(phrase.trim()) + 1);
                    }
                }
		    }
		} finally {
		    if (inputStream != null) {
		        try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}

        List<Map.Entry<String, Integer>> hashMapEntries = new ArrayList<>(occurrences.entrySet());
        Collections.sort(hashMapEntries, (e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        return hashMapEntries.stream().limit(100000).collect(Collectors.toList());
    }

}
