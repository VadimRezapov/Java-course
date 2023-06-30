// Даны два Deque, представляющие два целых числа. 
// Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
// 1) Умножьте два числа и верните произведение в виде связанного списка.
// 2) Сложите два числа и верните сумму в виде связанного списка.
// Одно или два числа могут быть отрицательными.

// Даны два Deque, цифры в обратном порядке.
// [3,2,1,-] - пример Deque
// [5,4,3]- пример второго Deque
// 1) -123 * 345 = -42 435
// Ответ всегда - связный список, в обычном порядке
// [-,4,2,4,3,5] - пример ответа

import java.util.ArrayDeque;
import java.util.LinkedList;

public class App {

    public static ArrayDeque<String> reversed(ArrayDeque<String> deque) {
        ArrayDeque<String> reversedDeque = new ArrayDeque<>();
        while (!deque.isEmpty()) {
            reversedDeque.push(deque.pop());
        }
        return reversedDeque;
    }

    public static int retNumber(ArrayDeque<String> deque) {
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pop());
        }
        int number = Integer.parseInt(sb.toString());
        return number;
    }

    public static LinkedList<Character> numberToLinkedList(int number) {
        String numberStr = String.valueOf(number);

        LinkedList<Character> list = new LinkedList<>();
        for (char c : numberStr.toCharArray()) {
            list.addLast(c);
        }
        return list;
    }
    public static void main(String[] args) throws Exception {
        ArrayDeque<String> firstDeque = new ArrayDeque<String>();
        ArrayDeque<String> secondDeque = new ArrayDeque<String>();
        firstDeque.add("3");
        firstDeque.add("2");
        firstDeque.add("1");
        firstDeque.add("-");
        secondDeque.add("5");
        secondDeque.add("4");
        secondDeque.add("3");
        System.out.println(firstDeque);
        System.out.println(secondDeque);
        ArrayDeque<String> reversedFirst = reversed(firstDeque);
        System.out.println(reversedFirst);
        ArrayDeque<String> reversedSecond = reversed(secondDeque);
        System.out.println(reversedSecond);
        int first = retNumber(reversedFirst);
        int second = retNumber(reversedSecond);
        System.out.println(first);
        System.out.println(second);
        System.out.println(first * second);
        int result = first * second;
        System.out.println(numberToLinkedList(result));
    }
}