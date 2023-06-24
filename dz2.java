// 1) Дана строка sql-запроса "select * from students WHERE ". 
// Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// String input_str = "{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}"
// Ввод данных: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// вывод: select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow

public class Task1 {

    public static void split() {
        String input_str = "{'name':'Ivanov', 'country':'Russia', 'city':'Moscow', 'age':'null'}";
        String[] filters = input_str.replace("{","").replace("}","").split(", ");
        StringBuilder query = new StringBuilder();
        for (String filter : filters) {
            String[] keyValue = filter.split(":");
            String key = keyValue[0].replace("'","");
            String value = keyValue[1].replace("'","");
            if (!value.equals("null")) {
                query.append(key).append("=").append(value).append(" AND ");
            }
        }       
        if(query.isEmpty()){
            System.out.println("select * from students");
        } else {
        query.delete(query.length()-5, query.length());
        String sqlQuery = "select * from students WHERE " + query.toString();
        System.out.println(sqlQuery);
        }
    }
    public static void main(String[] args) {
        split();
    }
    
}






// 2) Реализуйте алгоритм сортировки пузырьком числового массива, 
// результат после каждой итерации запишите в лог-файл.

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task2 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Task2.class.getName());
        FileHandler fh;
        try {  
            fh = new FileHandler("MyLogFile.log");  
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);  
            logger.info("My first log");
            } catch (SecurityException e) {  
                e.printStackTrace();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }

        int arr[] = {9,3,2,5,1,7,6,4,8};
        int i = arr.length - 1;
        while(i >= 1)
        {
            int j = 0;
            while (j < i) {
                int temp;
                if(arr[j+1] < arr[j]) {temp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = temp;}
                logger.info(Arrays.toString(arr));
                j++;
                }
            i--;
        }
        for(int k : arr){System.out.println(k);}
    }
}