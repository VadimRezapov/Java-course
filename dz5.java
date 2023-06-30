// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся
// имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. 
// Вывод должен быть отсортирован по убыванию числа телефонов.

// Пример:
// Иванов 1231234
// Иванов 3456345
// Иванов 5676585
// Петров 12345
// Петров 82332

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneBook {
    private final Map<String, List<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        List<String> numbers = contacts.getOrDefault(name, new LinkedList<>());
        numbers.add(phoneNumber);
        contacts.put(name, numbers);
    }

    public List<String> getNumbersByName(String name) {
        return contacts.getOrDefault(name, new LinkedList<>());
    }

    public List<String> getAllNamesSortedByNumberOfNumbers() {
        return contacts.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void show(PhoneBook phoneBook) {
        List<String> sortedNames = phoneBook.getAllNamesSortedByNumberOfNumbers();
        for(String elString : sortedNames) {
            System.out.println(elString + ": " + phoneBook.getNumbersByName(elString));}
        }
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Иванов", "1231234");
        phoneBook.addContact("Иванов", "3456345");
        phoneBook.addContact("Иванов", "5676585");
        phoneBook.addContact("Петров", "12345");
        phoneBook.addContact("Петров", "82332");
        // phoneBook.addContact("Петров", "46783");
        // phoneBook.addContact("Петров", "34589");
        // phoneBook.addContact("Петров", "22233333");
        show(phoneBook);
    }
}