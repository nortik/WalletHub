import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KComplementaryTest {

    private KComplementary kComplementary;

    @Before
    public void init(){
    	kComplementary = new KComplementary();

    }

    @Test
    public void numberKComplementary() throws Exception {

    	int[] testArray = {1,3,5,10,12,14,4,8};
    	
        Assert.assertEquals(3,kComplementary.getNumberKcomplementaries(testArray, 15));
        
        Assert.assertNotEquals(4,kComplementary.getNumberKcomplementaries(testArray, 15));
        
        Assert.assertEquals(1,kComplementary.getNumberKcomplementaries(testArray, 14));

    }

}
