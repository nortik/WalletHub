import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PalindromeTest {

    private Palindrome palindrome;

    @Before
    public void init(){
          palindrome = new Palindrome();

    }

    @Test
    public void isPalindrome() throws Exception {

        Assert.assertTrue(palindrome.isPalindrome("anna"));
        
        Assert.assertTrue(palindrome.isPalindrome("asddsa"));
        
        Assert.assertFalse(palindrome.isPalindrome("fdsfasdf2"));

    }

}
