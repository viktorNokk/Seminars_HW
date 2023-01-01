/*
На вход методу приходят два ArrayList<Integer> и целое число num.
Проверьте, что число num встречается в обоих массивах одинаковое кол-во раз.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(10, 4, 5, 6, 7, 2, 2, 9));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2, 2, 5, 4, 7, 6, 10, 9));
        int num = 2;

        boolean result = ckeckNumber(list1, list2, num);
        System.out.println("Result: " + result);
    }

    public static boolean ckeckNumber(ArrayList<Integer> list1, ArrayList<Integer> list2, int num) {
        int count1 = 0;
        int count2 = 0;

        for (int n : list1) {
            if (n == num) {
                count1++;
            }
        }

        for (int n : list2) {
            if (n == num) {
                count2++;
            }
        }
        return count1 == count2;
    }
}