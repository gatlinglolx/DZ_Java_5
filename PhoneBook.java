import java.util.*;

// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся 
// имена с разными телефонами, их необходимо считать, как одного человека с разными 
// телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();
        addContact(phoneBook, "Shakhov", "123-45-67");
        addContact(phoneBook, "Ivanov", "098-76-54");
        addContact(phoneBook, "Petrov", "134-52-67");
        addContact(phoneBook, "Ivanov", "798-76-54");
        addContact(phoneBook, "Petrov", "884-52-67");
        printPhoneBook(phoneBook);
    }

    public static void addContact (Map<String, List<String>> phoneBook, String phone, String name) {
        List<String> phones = phoneBook.get(name);
        if (phones == null) {
            phones = new ArrayList <>();
            phoneBook.put(name, phones);
        }
        phones.add(phone);
    }

    public static void printPhoneBook (Map<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> list = new ArrayList<>(phoneBook.entrySet());
        Collections.sort(list, (entry_1, entry_2) -> Integer.compare(entry_2.getValue().size(), entry_1.getValue().size()));
        for (Map.Entry<String, List<String>> entry : list) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}

