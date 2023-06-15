import java.util.Arrays;

public class Main04v2 {
    public static void main(String[] args) {
        int[] array1  = {1,2,3,4,5};
        int n1 = 2;
        shiftArray(array1,n1);
        System.out.println();

        int[] array2 = {1,2,3,4,5};
        int n2 = -2;
        shiftArray(array2,n2);

    }
    private static void reverseArray(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(array));
    }
    public static void shiftArray(int[] array, int n) {
        int length = array.length;
        n = n % length;

        if (n < 0) {
            n = length + n;
        }
        reverseArray(array, 0, length - 1);
        reverseArray(array, 0, n - 1);
        reverseArray(array, n, length - 1);
    }
}