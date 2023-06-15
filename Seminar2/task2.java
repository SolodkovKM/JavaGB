import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Main02_DZ {
    public static void Logger(String fileName) throws IOException {
        Logger logger = Logger.getLogger(Main02_DZ.class.getName());
        FileHandler fh = new FileHandler(fileName);
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);

        logger.log(Level.INFO, "Test logging");
        logger.info("Test logging2");
    }

    public static int[] Bubble(int[] array,String filename) throws IOException {
        int size = array.length;
        int temp;
        for (int i = 1; i < size; i++) {
            Logger(filename);
            for (int j = size - 1; j >= i; j--) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) throws IOException {
        String fileName = "Log2.xml";
        Logger(fileName);

        int[] int1 = {2, 8, 9, 11, 0, -40};
        System.out.println(Arrays.toString(Bubble(int1 ,fileName)));
    }
}