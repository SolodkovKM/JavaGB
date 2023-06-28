import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main01_DZ {
    public static void main(String[] args) {
        Deque<String> strings = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String str = "";

        while (!str.equals("exit")) {
            System.out.print("Введите строку: ");
            str = scanner.nextLine();

            if (str.equals("print")) {
                System.out.println(strings);
            } else if (str.equals("revert")) {
                if (!strings.isEmpty()) {
                    strings.removeFirst();
                } else {
                    System.out.println("revert -> throw new NoSuchElementException");
                }
            } else {
                strings.addFirst(str);
            }
        }
    }
}