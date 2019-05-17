import java.util.Arrays;
 
public class Program {
    public static void main(String[] args) {
        int [] arr = {-1, 5, -3, 20, 11, 0, 2, 6};
            for (int i = arr.length-1 ; i > 0 ; i--){
            for( int j = 0 ; j < i ; j++){
            	if( arr[j] > arr[j+1]){
            		int tmp = arr[j];
            		arr[j] = arr[j+1];
            		arr[j+1] = tmp;
            	}
            } 
         }
        System.out.println(Arrays.toString(arr));
    }        
}