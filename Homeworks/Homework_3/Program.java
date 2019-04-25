import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Integer result = 0;
        Integer step = 0;
        Integer inputNum;

        Scanner in = new Scanner(System.in);
        String inputString = in.next();

        while (true) {
            String[] strArray = inputString.split("");
            Integer[] numArray = new Integer[strArray.length];

            for (int i = 0; i < strArray.length; i++) {
                numArray[i] = Integer.parseInt(strArray[i]);
            }

            switch (step % 2) {
                case 0:
                    result = 0;
                    for (int i : numArray) {
                        result += i;
                    }
                    System.out.println(result);
                    step += 1;
                    break;

                case 1:
                    result = 1;
                    for (int i : numArray) {
                        result *= i;
                    }
                    System.out.println(result);
                    step += 1;
                    break;
            }

            if (result % 2 == 0) {
                inputNum = in.nextInt();
                while (inputNum % 2 != 0) {
                    System.out.println("PLEASE REPEAT");
                    inputNum = in.nextInt();
                }
                inputString = inputNum.toString();
            }else{
                inputNum = in.nextInt();
                inputString = inputNum.toString();
            }
        }
    }
}
