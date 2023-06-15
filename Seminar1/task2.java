import java.util.Scanner;
import java.util.Arrays;

class RandomNumbers {
    int myInput;

    int[][] RandomTable(int myInput) {
        int[][] randomtable1 = new int[myInput][myInput];
        for (int i = 0; i < myInput; i++) {
            for (int j = 0; j < myInput; j++) {
                int randomNumber = (int) (Math.random() * 10) + 7;
                randomtable1[i][j] = randomNumber;
            }
        }
        return randomtable1;
    }
}

public class Main02 {
    public static void main(String[] args) {
        System.out.print("Введите целое число : ");
        Scanner inputStr = new Scanner(System.in);
        int myInput1 = inputStr.nextInt();
        RandomNumbers randomNumbers = new RandomNumbers();
        randomNumbers.myInput = myInput1;
        int[][] res = randomNumbers.RandomTable(randomNumbers.myInput);
        System.out.println(Arrays.deepToString(res));
        System.out.println();
        for (int i = 0; i < myInput1; i++) {
            for (int j = 0; j < myInput1; j++) {
                if (i == j || i + j == myInput1 - 1) {
                    res[i][j] = 1;
                }
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(Arrays.deepToString(res));
    }
}