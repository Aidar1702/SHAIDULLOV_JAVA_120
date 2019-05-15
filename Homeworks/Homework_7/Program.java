/* Написать функцию boolean isPrime(int number) для проверки,
 является ли число number простым числом.
*/


import java.util.Scanner;

class Program {
	public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
	int number = scanner.nextInt();


	System.out.println(isPrime(number));
	}

public static boolean isPrime(int number) {
		boolean str = true;
		for (int i = 2; i < number; i++){
			if (number % i == 0){
				str = false;
				break;
			}
		}
		return str;
	}
}


