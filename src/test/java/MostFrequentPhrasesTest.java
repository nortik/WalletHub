import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MostFrequentPhrasesTest {

	private MostFrequentPhrases mostFrequentPhrases;

    @Before
    public void init(){
    	mostFrequentPhrases = new MostFrequentPhrases();

    }

    @Test
    public void numberKComplementary() throws Exception {
    	final String FILE_PATH = "src/main/resources/file";
    	    	
    	List<Entry<String, Integer>> aux = new ArrayList<Entry<String, Integer>>();		
		aux = mostFrequentPhrases.getMostFrequentPhrases(FILE_PATH);
    	
		Assert.assertEquals("CNET",aux.get(0).getKey());
		Assert.assertEquals(2,aux.get(1).getValue().intValue());
		Assert.assertNotEquals("TEST",aux.get(2).getKey());		
		
		/*for (Entry<String, Integer> entry : aux)
		{
		    System.out.println("key:" + entry.getKey() + " times:"+ entry.getValue());
		}*/
		
    }

}
