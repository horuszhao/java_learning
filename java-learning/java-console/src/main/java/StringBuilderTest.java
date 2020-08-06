/**
 * @author:zhaoyunxiang
 * @date:2020/6/28 8:01 下午
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("abcd|fg");
//        sb.deleteCharAt(sb.length() - 1);
//        System.out.println(sb.toString());
        StringBuilder delete = sb.delete(sb.length() - 3, sb.length());
        System.out.println(delete);
    }
}
