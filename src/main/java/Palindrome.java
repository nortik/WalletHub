
public class Palindrome {
	
	 public final boolean isPalindrome(String word){
		 
	 String reverse = "";		 

     for ( int i = word.length() - 1; i >= 0; i-- )
       reverse = reverse + word.charAt(i);
	
     if (word.equals(reverse))
        return true;
     else
        return false;	 
	 }

}
