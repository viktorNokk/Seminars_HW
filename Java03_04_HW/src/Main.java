/*
На вход приходт ArrayList<Integer> удалите из него четные числа (на итератор)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 4, 5, 6, 7, 2, 2, 9));

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (n % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println("Result: " + numbers);
    }
}