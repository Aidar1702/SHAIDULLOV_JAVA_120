/*
Ввести массив с консоли (также ввести его размер). 
Посчитать количество локальных максимумом и минимумов.
a[i - 1] < a[i] > a[i + 1] - локальный максимум
a[i - 1] > a[i] < a[i + 1] - локальный минимум
*/


import java.util.Scanner;

class Program {
	public static void main(String[] args){
		Scanner scanner = new Scanner (System.in);
		int length = scanner.nextInt();
		int[]a = new int[length];
		int countMax = 0;
		int countMin = 0;
		for (int i =0; i < length; i++)
			a[i] = scanner.nextInt();
		for (int i = 1; i < length - 1; i++)
			if (a[ i - 1 ] > a[i] && a[i] < a[ i + 1 ] )
				countMin++;
			else if (a[i - 1] < a[i] && a[i] > a[i + 1])
				countMax ++;
			System.out.println("LocalMax: - " + countMax);
            System.out.println("LocalMin: - " + countMin);

		}

	}


