package Test03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nuonuo
 * @create 2020-08-05 9:10
 */
public class StringTest01 {
    public static void main(String[] args) {
        String str = new String("11123412451234121");
//        System.out.println(judgmentAllNumber(str));
//        mySplit("a b c d", " ");

//        System.out.println(myReplace(str, '1', '2'));
//        System.out.println(myIndexOf(str, "12"));

        System.out.println(myCompareTo("asdf", "v"));
    }

    /*
    自己实现compareTo方法
     */
    private static int myCompareTo(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int limit = Math.min(len1, len2);
        for (int i = 0; i < limit; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                continue;
            }
            return str1.charAt(i) - str2.charAt(i);
        }
        return len1 - len2;
    }

    /*
    自己实现contains方法
     */
    private static boolean myContains(String str, String s) {
        return myIndexOf(str, s) > -1;
    }

    /*
    自己实现indexOf方法
     */
    private static int myIndexOf(String str, String s) {
        if (str == null || str.length() == 0 || s == null || s.length() == 0) {
            return -1;
        }
        int i = 0, j = 0;
        for (; i < str.length(); i++, j = 0) {
            if (str.charAt(i) == s.charAt(j)) {
                boolean isSame = true;
                for (int k = j+1, l = i+1; k < s.length() || l < str.length(); k++, l++) {
                    if (l >= str.length()) { //str先遍历完
                        return -1;
                    }
                    if (k >= s.length()) { //s先遍历完
                        return i;
                    }
                    if (str.charAt(l) != s.charAt(k)) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    return i;
                }
            }

        }
        return -1;
    }
    /*
    自己实现replace方法
     */
    private static String myReplace(String str, char oldChar, char newChar) {
        if (oldChar == newChar) {
            return str;
        }
        int i = 0;
        while (i < str.length()) { //找到第一个要替换的字符
            if (str.charAt(i) == oldChar) {
                break;
            }
            i++;
        }
        if (i >= str.length()) {
            //没有要替换的字符
            return str;
        }
        char buf[] = new char[str.length()];
        for (int j = 0; j < i; j++) {
            buf[j] = str.charAt(j);
        }
        while (i < str.length()) {
            char c = str.charAt(i);
            buf[i] = (c == oldChar) ? newChar : c;
            i++;
        }
        return new String(buf);
    }

    /*
    自己实现split方法
     */
    private static String[] mySplit(String str, String reg) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (reg == null || reg.length() == 0) {
            return new String[]{str};
        }
        List<String> list = new ArrayList<>(); //将每个分割的部分存放到顺序表
        int index = str.indexOf(reg);
        while (index != -1) { //说明找到了第一次出现reg的地方
            String substring = str.substring(0, index);
            list.add(substring);
            str = str.substring(index + reg.length());
            index = str.indexOf(reg);
        }
        if (str.length() != 0) {
            list.add(str);
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        System.out.println(Arrays.toString(res));
        return res;
    }


    private static boolean judgmentAllNumber(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if ('0' > temp || temp > '9') {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {

        String res = myComcat("adf", "sad");
        System.out.println(res);

    }

    public static String myComcat(String str1, String str2) {
        if (str1 == null || str1.length() == 0) {
            return str2;
        }
        if (str2 == null || str2.length() == 0) {
            return str1;
        }
        return str1.concat(str2);

    }
}
