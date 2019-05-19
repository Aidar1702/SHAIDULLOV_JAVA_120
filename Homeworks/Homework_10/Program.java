import java.util.Arrays;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        char[] charArray;
        char[] finalCharArray;
        int[] indexArray;
        int maxCharRepetition = 0;
        int charDimension = 0;

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        charArray = str.toCharArray();

        indexArray = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray.length; j++) {

                if (charArray[i] == charArray[j]) {
                    indexArray[i]++;
                }

            }
        }

        for (int i = 0; i < charArray.length; i++) {
            if (maxCharRepetition < indexArray[i]) {
                maxCharRepetition = indexArray[i];
            }
        }

        for (int i = 0; i < charArray.length; i++) {
            if (maxCharRepetition == indexArray[i]) {
                charDimension++;
            }
        }
        finalCharArray = new char[charDimension];

        int k = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (indexArray[i] == maxCharRepetition) {
                finalCharArray[k] = charArray[i];
                k++;
            }
        }
        Arrays.sort(finalCharArray);

        System.out.println(finalCharArray[0]);
        for (int i = 0; i < charDimension - 1; i++){
            if(finalCharArray[i] != finalCharArray[i + 1]){
                System.out.println(finalCharArray[i + 1]);
            }
        }

    }
}