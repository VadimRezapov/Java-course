// 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

package lesson1.src;
import java.util.Scanner;
import java.io.*;
public class Task1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число n:");
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(n + " треугольное число: " + calculate(n));
    }

    public static int calculate(int n){
        return (n * (n + 1)) / 2;  
    }
}


// 2) Вывести все простые числа от 1 до 1000

package lesson1.src;
import java.util.Scanner;
import java.io.*;

public class Task2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        int number = scanner.nextInt();
        scanner.close();
        System.out.println("Простые числа до числа " + number + ":");
        for (int i = 2; i <= number; i++) {
            boolean isPrimeNumber = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }

        if(isPrimeNumber){
            System.out.print(i + ", ");
            }
        }
    System.out.println();
    }
}




// 3) Реализовать простой калькулятор


package lesson1.src;
import java.util.Scanner;
import java.io.*;

public class Task3 {
    public static void main(String[] args) throws IOException {
        System.out.println("Программа калькулятор");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Введите 0 для выхода:");
            System.out.println("Введите первое число A:");
            int first = scanner.nextInt();
            if(first == 0){break;}
            System.out.println("Введите знак (+, -, *, /):");
            String sign = scanner.next();
            System.out.println("Введите второе число B:");
            int second = scanner.nextInt();
            System.out.print("\033\143");
            switch(sign){
                case ("+"):
                    System.out.println("Ответ: " + (first + second));
                    break;
                case ("-"):
                    System.out.println("Ответ: " + (first - second));
                    break;
                case ("*"):
                    System.out.println("Ответ: " + (first * second));
                    break;
                case ("/"):
                    if (second != 0){
                        System.out.println("Ответ: " + (first / second));
                        break;
                    } else {System.out.println("На ноль делить нельзя!");}
                }
        }
        scanner.close();
        System.out.println("Выход"); 
    }
}



// 4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0.
// Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
// Требуется восстановить выражение до верного равенства.
// Знаки вопроса - одинаковые цифры.
// Предложить хотя бы одно решение или сообщить, что его нет.

package lesson1.src;
public class Task4 {
    public static void main(String[] args) {
        boolean flag = false;
        int i = 0;
        while(i < 10) {
            String n = String.valueOf(i);
            String eq = "2? + ?5 = 69";
            String replacedString = eq.replace("?", n);
            String[] words = replacedString.split(" ");
            String first = words[0];
            String second = words[2];
            String third = words[4];
            System.out.println(first + ", " + second + ", " + third);
            int f = Integer.valueOf(first);
            int s = Integer.valueOf(second);
            int t = Integer.valueOf(third);
            System.out.println(f + s + t);
            if(f + s == t){System.out.println("Есть!"); flag = true; break;}
            i++;
        }
        if(flag == false){
            System.out.println("Нет!");
        }
    }
    
}