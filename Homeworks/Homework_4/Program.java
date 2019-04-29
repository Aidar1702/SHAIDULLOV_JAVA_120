import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentDigit = 0;
        int Digit = 0;
        int[]arr = new int[10];

        while (currentDigit != -1) {
            currentDigit = scanner.nextInt();

            for (;currentDigit > 0; currentDigit /= 10){
                Digit = currentDigit % 10;
                arr[Digit]++;// arr[Digit]+1
                while (currentDigit <= 0) {
                    currentDigit = scanner.nextInt();

                    for (;currentDigit > 0; currentDigit /= 10){
                        Digit = currentDigit % 10;
                        arr[Digit]++;// arr[Digit]+1
                    }
                }
            }
        }
        System.out.println("numberOne " + arr[1]);
        System.out.println("numberTwo " + arr[2]);
        System.out.println("numberThree " + arr[3]);
        System.out.println("numberFour " + arr[4]);
        System.out.println("numberFive " + arr[5]);
        System.out.println("numberSix " + arr[6]);
        System.out.println("numberSeven " + arr[7]);
        System.out.println("numberEight " + arr[8]);
        System.out.println("numberNine " + arr[9]);

        scanner.close();
    }
}