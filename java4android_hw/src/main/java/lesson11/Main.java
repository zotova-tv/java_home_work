package lesson11;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] strings = {"a", "b", "b", "c", "c", "c", "d", "D", "d", "d"};

        // Задание 1 Вариант 1
        System.out.println("Задание 1 Вариант 1");
        HashMap<String, Integer> repetitionsOfStrings = getRepetitionsOfStrings(strings);

        System.out.println("Список уникальных строк " + repetitionsOfStrings.keySet());
        for(Map.Entry<String, Integer> entry: repetitionsOfStrings.entrySet()){
            System.out.println(String.format("Строка: \"%s\", найдено: %d", entry.getKey(), entry.getValue()));
        }
        System.out.println();

        // Задание 1 Вариант 2
        System.out.println("Задание 1 Вариант 2");
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, strings);
        System.out.println("Список уникальных строк " + set);

        for(String str: set){
            System.out.println(String.format("Строка: \"%s\", найдено: %d", str, Arrays.stream(strings).filter(string -> string == str).count()));
        }

        // Задание 2
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "+7(999)111-11-11");
        phoneBook.add("Petrov", "+7(999)222-22-22");
        phoneBook.add("Sidorov", "+7(999)333-33-33");
        phoneBook.add("Petrov", "+7(999)444-44-44");

        System.out.println(phoneBook);
        System.out.println(phoneBook.get("Ivanov"));
        System.out.println(phoneBook.get("Petrov"));
    }

    private static HashMap<String, Integer> getRepetitionsOfStrings(String[] strings) {
        HashMap<String, Integer> stringsMap = new HashMap<>();
        for(String str: strings){
            if(stringsMap.get(str) == null){
                stringsMap.put(str, 1);
            }else{
                stringsMap.put(str, stringsMap.get(str) + 1);
            }
        }
        return stringsMap;
    }
}
