/* Написать функцию boolean isPrime(int number) для проверки,
 является ли число number простым числом.
*/

import java.util.Scanner;

class Program{
	public static boolean isPrime(int number){
		if (number < 2) return false;
		for(int i = 2; i < Math.sqrt(number); i++){
			if((number % i) == 0)
				return false;
		}
		return true;
	}
}

public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	number = scanner.nextInt();
	if (isPrime) {
            System.out.println("число составное ");
        } else {
            System.out.println("число  простое ");
    }
}
