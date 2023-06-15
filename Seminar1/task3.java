import java.time.LocalTime;
import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        System.out.print("Введите ваше имя : ");
        Scanner inputStr = new Scanner(System.in);
        String name = inputStr.nextLine();
        System.out.println();

        LocalTime currentTime = LocalTime.now();

        String greeting;
        if (currentTime.isAfter(LocalTime.of(5, 0)) && currentTime.isBefore(LocalTime.of(11, 59))) {
            greeting = "Доброе утро, ";
        } else if (currentTime.isAfter(LocalTime.of(12, 0)) && currentTime.isBefore(LocalTime.of(17, 59))) {
            greeting = "Добрый день, ";
        } else if (currentTime.isAfter(LocalTime.of(18, 0)) && currentTime.isBefore(LocalTime.of(22, 59))) {
            greeting = "Добрый вечер, ";
        } else {
            greeting = "Доброй ночи, ";
        }
        System.out.println(greeting + name + "!");
    }
}