import java.util.Scanner;
class Program {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int array[] = new int[10];
	int currentDigit = 0;
	int currentNumber = scanner.nextInt();
		while (currentNumber != -1) {
			while (currentNumber != 0) {
				currentDigit = currentNumber % 10;
					for (int i = 1; i < 10; i++) {
						if (currentDigit == i) {
							array[i] = array[i] + 1;
						}
					}
				currentNumber = currentNumber / 10;	
			}
		currentNumber = scanner.nextInt();	
		}
	for (int i = 1; i < 10; i++) {
		if (array[i] != 0) {
		System.out.println("Digit " + i + " = " + array[i]);	
		}
	}
	}
}