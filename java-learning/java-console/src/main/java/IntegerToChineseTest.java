/**
 * @author:zhaoyunxiang
 * @date:2020/2/7 5:06 下午
 */
public class IntegerToChineseTest {


    private static final String[] chinese_nums = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    private static final String[] chinese_unit = {"", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};

    public static String int2chineseNum(int src) {
        String dst = "";
        int count = 0;
        while(src > 0) {
            dst = (chinese_nums[src % 10] + chinese_unit[count]) + dst;
            src = src / 10;
            count++;
        }
        return dst.replaceAll("零[千百十]", "零").replaceAll("零+万", "万")
                .replaceAll("零+亿", "亿").replaceAll("亿万", "亿零")
                .replaceAll("零+", "零").replaceAll("零$", "");
    }

    public static void main(String[] args) {
        System.out.println(int2chineseNum(6));
    }
}
