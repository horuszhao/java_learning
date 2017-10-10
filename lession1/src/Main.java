import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Beyondhost on 9/19/2017.
 */
public class Main {
    public static void main(String[] args) {
        int[] result = method1();

        System.out.println(Arrays.toString(result));
    }

    private static int[] method1()
    {
        long start = System.nanoTime();
        int[] result = new int[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            result[i] = random.nextInt(9) + i * 10;
        }
        long end = System.nanoTime();
        System.out.println(String.format("%sns",end-start));
        return result;
    }

    private static int[] method2()
    {
        long start = System.nanoTime();
        int[] result = new int[1000];
        Random random = new Random();
        int number = random.nextInt(9);

        for (int i = 0; i < 1000; i++) {
            result[i] = number + i * 10;
        }
        long end = System.nanoTime();
        System.out.println(String.format("%sns",end-start));
        return result;
    }

}
