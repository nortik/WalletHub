
public class KComplementary {
	
	public final int getNumberKcomplementaries(int[] arr, int K) {
		int result=0;   
		for(int i=0;i<=arr.length;i++){
	            for(int j=i;j<arr.length-1;j++){
	                if(arr[i] + arr[j+1] == K){
	                    //System.out.println("two values: " + arr[i] + " " + arr[j+1] );
	                	result++;
	                }
	            }
	        }
	    return result;
	} 
}
