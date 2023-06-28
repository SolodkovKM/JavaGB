import java.util.*;

public class Main01_v2 {
    public static Map<String, Set<String>> tel = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите команду: ");
            String input = scanner.nextLine();
            String[] split = input.split(" ");
            String command = split[0];
            switch (command) {
                case "ADD" -> addContact(split);
                case "GET" -> getNumbers(split);
                case "REMOVE" -> removeContact(split);
                case "LIST" -> listContacts();
                case "EXIT" -> {
                    System.out.println("Программа завершена.");
                    return;
                }
                default -> System.out.println("Неверная команда.");
            }
        }
    }

    public static void addContact(String[] command) {
        if (command.length < 3) {
            System.out.println("Неверный формат команды ADD.");
            return;
        }

        String lastName = command[1];
        String phoneNumber = command[2];

        Set<String> numberSet = tel.getOrDefault(lastName, new HashSet<>());
        numberSet.add(phoneNumber);
        tel.put(lastName, numberSet);

        System.out.println(tel);

    }

    public static void getNumbers(String[] command) {
        if (command.length < 2) {
            System.out.println("Неверный формат команды GET.");
            return;
        }

        String lastName = command[1];
        Set<String> numberSet = tel.get(lastName);

        if (numberSet == null) {
            System.out.println("Не найдена запись с фамилией \"" + lastName + "\"");
        } else {
            System.out.println(numberSet);
        }
    }


    public static void removeContact(String[] command) {
        if (command.length < 2) {
            System.out.println("Неверный формат команды REMOVE.");
            return;
        }

        String lastName = command[1];
        Set<String> numberSet = tel.remove(lastName);

        if (numberSet == null) {
            System.out.println("Не найдена запись с фамилией \"" + lastName + "\"");
        } else {
            System.out.println("Записи с фамилией \"" + lastName + "\" удалены.");
        }
    }

    public static void listContacts() {
        for (Map.Entry<String, Set<String>> entry : tel.entrySet()) {
            String lastName = entry.getKey();
            Set<String> numberSet = entry.getValue();
            System.out.println(lastName + " = " + numberSet);
        }
    }


}