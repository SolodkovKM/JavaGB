public class main {
    public static void main(String[] args) {
        GetMinAndMaxFromArray();
    }
    public static void GetMinAndMaxFromArray()
    {
        int[] array = {10,3,2,4,5,6,4,3,7,3};
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) min = array[i];
            if (array[i] > max) max = array[i];
        }
        System.out.println(min + " " + max);
    }
}