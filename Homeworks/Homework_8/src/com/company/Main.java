/*
-Написать функции int sum(int array[]).
-Написать функцию int[] getVectorOfFrequency(int array[]), предполагая,
что массив array состоит из числе от 1 до 1000 вернуть вектор частот.
Если число 55 в массиве array встречается 35 раз, то результат функции - массив частот, в индексе 55 имеет значение - 35. (см. Гистограмма)
-Написать функцию double average(int array[]) - возвращает среднее арифметическое массива.
*/

package com.company;


import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Razmer Massiva: - ");
        int length = scanner.nextInt();
        int[] array = new int[length];

        System.out.println("Elements: - ");
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }


        System.out.println("Summa: - " + sum(array));
    }


    public static int sum(int array[]){
        int result = 0;
        for(int i = 0; i < array.length; i++){
            result += array[i];
        }
        return result;
    }

    public static int[] getVectorOfFrequency(int array[]){
        int[] result = new int[1000];
        for(int i = 0; i < array.length; i++){
            result[array[i]] += 1;
        }
        return result;
    }

    public static double average(int array[]){
        return (double) sum(array) / array.length;
    }
}


