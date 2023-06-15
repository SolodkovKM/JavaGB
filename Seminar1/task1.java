public class main {
    public static void main(String[] args) {

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
    public static void FillDiagonalMatrix()
    {
        int[][] matrix = new int[6][6];
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix.length; j++)
            {
                if (i == j || i == matrix.length - j - 1) System.out.print(1 + " ");
                else System.out.print(0 + " ");
            }
            System.out.println();
        }
    }
    public static void GetHiByTime()
    {
        Date now = new Date();
    }
}