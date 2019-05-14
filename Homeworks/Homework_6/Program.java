/* Считать массив с консоли, 
поменять минимальный и максимальный элементы местами.
*/

import java.util.Scanner;
class Program{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		int a[] = new int[length];
		int maxValue = 0;
		int minValue = 0;
		for (int i = 0; i < length; i++){
			a[i] = scanner.nextInt();
			int max = a[0];
			int min = a[0];
			if (a[i] > max) maxValue = i;
			if (a[i] < min) minValue = i;
		}
		int tmp = a[maxValue];
		a[maxValue] = a[minValue];
		a[minValue] = tmp;

		for (int i = 0; i < length; i++)

        System.out.println(a[i]  + " Результат");

	}
}

