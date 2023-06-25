// Пусть дан произвольный список целых чисел.

// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее значение

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class App {

    public static List<Integer> create_array(int size) {
        Random random = new Random();
        List<Integer> randomList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            randomList.add(random.nextInt(100));
        }
        return randomList;
    }

    public static void print_array(List<Integer> array) {
        System.out.println(array.toString());
    }

    public static void delete_even_numbers(List<Integer> array) {
        List<Integer> even = array;
        Iterator<Integer> itr = even.iterator();
        while(itr.hasNext()) {
            int i = itr.next();
            if(i % 2 == 0) {
                itr.remove();
            }
        }
        System.out.println(array);
    }

    public static void find_min(List<Integer> array) {
        List<Integer> new_arr = array;
        Iterator<Integer> itr = new_arr.iterator();
        int min = itr.next();
        while(itr.hasNext()) {
            int i = itr.next();
            if(i < min) {
                min = i;
            }
        }
        System.out.println(min);
    }

    public static void find_max(List<Integer> array) {
        List<Integer> new_arr = array;
        Iterator<Integer> itr = new_arr.iterator();
        int max = itr.next();
        while(itr.hasNext()) {
            int i = itr.next();
            if(i > max) {
                max = i;
            }
        }
        System.out.println(max);
    }

    public static void mean(List<Integer> array) {
        List<Integer> new_arr = array;
        Iterator<Integer> itr = new_arr.iterator();
        int sum = 0;
        int len = 0;
        while(itr.hasNext()) {
            int i = itr.next();
            sum += i;
            len++;
        }
        System.out.println(sum/len);
    }

    public static void main(String[] args) throws Exception {
        List<Integer> array = create_array(10);
        print_array(array);
        delete_even_numbers(array);
        find_min(array);
        find_max(array);
        mean(array);
    }
}