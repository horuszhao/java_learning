
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:zhaoyunxiang
 * @date:2020/2/6 8:34 下午
 */
public class ArraySliceTest {
    public static void main(String[] args) {
        List<Integer> integersList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        Integer[] integersArray = integersList.toArray(new Integer[integersList.size()]);

        double count = Math.ceil((double) integersArray.length / 3);

        for (int i=0;i<count;i++) {
            int to = i*3 + 3;
            if(i==count-1){
                to = integersArray.length;
            }
            Integer[] integers = Arrays.copyOfRange(integersArray, i * 3, to);
            List<String> stringList =
                    Arrays.asList(integers).stream().map(c -> String.valueOf(c)).collect(Collectors.toList());
            System.out.println(String.join(",",stringList));
        }
    }
}
