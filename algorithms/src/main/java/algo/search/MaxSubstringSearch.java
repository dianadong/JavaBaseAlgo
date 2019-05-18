package algo.search;

public class MaxSubstringSearch {
    /**
     * description: 寻找字符串内的最大重复子串
     * create time: 2019/5/16 22:09
     */
    public static int getMaxRepeatSubstringLength(String input) {
        if (input == null || input.equals("")) {
            return 0;
        }
        int max = 0;
        int k = 0;
        int first = 0;
        //使用两个指针，i为可能的间隔长度
        for (int i = 1; i < input.length(); i++) {
            for (int j = 0; j < input.length() - i; j++) {
                if (input.charAt(j) == input.charAt(i + j)) {//字符相等
                    k++;
                } else {//字符不相等
                    k = 0;
                }
                if (k > max) {
                    max = k;
                    first = j - k + 1;//最大字符串开始位置
                    continue;
                }
            }
        }
        System.out.println(input.substring(first, first + max));//最长字符串
        return max;
    }

    /**
     * description: 寻找两个字符串的最大公共子串
     * create time: 2019/5/16 22:18
     */
    public static String getMaxSubString(String s1, String s2) {
        String maxStr = (s1.length() > s2.length()) ? s1 : s2;
        String minStr = (maxStr == s1) ? s2 : s1;

        for (int count = 0; count < minStr.length(); count++) {
            for (int start = 0, end = minStr.length() - count; end != minStr.length() + 1; start++, end++) {
                String temp = minStr.substring(start, end);
                if (maxStr.contains(temp))
                    return temp;
            }
        }
        return "";
    }


    public static void main(String[] args) {
        String s1 = "helloworldhello";
        String s2 = "hellon";
        System.out.println(getMaxRepeatSubstringLength(s1));
        System.out.println(getMaxSubString(s1, s2));
    }
}
