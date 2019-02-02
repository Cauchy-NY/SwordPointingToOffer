package questions;

public class Question04 {
    /**
     * 请实现一个函数，把字符串中的每个空格替换成"%20"。
     * 例如输入"We are happy"，则输出"We%20are%20happy"
     */
    public static void main(String[] args) {
        String str="We are happy";
        char[] charArray = str.toCharArray();
        System.out.println(change(charArray));
    }

    private static String change(char[] charArray) {
        int count = 0;
        for (int i = 0; i < charArray.length; i++){
            if (charArray[i] == ' ')
                count++;
        }

        if (count == 0)
            return new String(charArray);

        char[] newStr = new char[charArray.length + 2*count];
        for (int i = 0, j = 0; j < newStr.length; i++, j++) {
            if (charArray[i] == ' ') {
                newStr[j] = '0';
                newStr[j + 1] = '2';
                newStr[j + 2] = '%';
                j += 2;
            } else {
                newStr[j] = charArray[i];
            }
        }
        return new String(newStr);
    }
    /**
     * 相关题目：
     * “有两个排序的数组A1和A2，内存在A1的末尾有足够多的空余空间容纳A2。
     * 请实现一个函数，把A2中的所有数字插入到A1中并且所有的数字是排序的。”
     * 关键在A1从后到前拷贝
     */
}
