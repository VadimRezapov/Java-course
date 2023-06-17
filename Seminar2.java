import java.nio.charset.Charset;
import java.util.Scanner;
package smr2;

// Дано четное число N (>0) и символы c1 и c2. Написать метод, который вернет строку длины N,
//которая состоит из чередующихся символов c1 и c2, начиная с c1.
//6 a b
//ababab#




public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp866");
        System.out.println("Введите первый символ: ");
        String a = sc.nextLine();
        System.out.println("Введите второй символ: ");
        String b = sc.nextLine();
        System.out.println("Введите длинну строки: ");
        int n = sc.nextInt();
        System.out.println(CreatString(a, b, n));
        

    }
    public static String CreatString(String a, String b, int n) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n/2; i++) {
                 str.append(a+b);
        }    
        return str.toString();
    }
}




/** Напишите метод, который сжимает строку. 
Пример: вход aaaabbbcddaa.
Ответ: результат - a4b3cd2a2 */
public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp866");
        System.out.println("Введите строку для сжатия: ");
        String str = sc.nextLine();
        sc.close();
        System.out.println(ZipString(str));
    }   
    public static String ZipString(String str) {
        StringBuilder zipStr = new StringBuilder(); 
        zipStr.append(str.charAt(0));
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
                 if (str.charAt(i - 1) == str.charAt(i)) {
                    count++;
                 }
                 else {
                    if (count != 1) {
                        zipStr.append("" + count);
                        count = 1;
                        zipStr.append(str.charAt(i));
                    } 
                    else {
                        zipStr.append(str.charAt(i));     
                    }
                 }
        }   
        if (count != 1) 
            zipStr.append("" + count); 
        return zipStr.toString();
    }
}