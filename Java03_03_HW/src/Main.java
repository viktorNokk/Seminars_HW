/*
На вход приходит ArrayList<Integer>. Отсортируйте в нем только четные числа.
Пример: [10, 4, 5, 6, 7, 2, 2, 9] -> [2, 2, 5, 4, 7, 6, 10, 9]
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 4, 5, 6, 7, 2, 2, 9));

        // Отсортируем четные чила в списке
        ArrayList<Integer> evenNumber = new ArrayList<>();
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumber.add(number);
            }
        }
        Collections.sort(evenNumber);

        // Заменим четные числе в исходном списке отсортироваными четными числами
        int i = 0;
        for (int j = 0; j < numbers.size(); j++) {
            if (numbers.get(j) % 2 == 0) {
                numbers.set(j, evenNumber.get(i));
                i++;
            }
        }
        System.out.println(numbers);
    }
}