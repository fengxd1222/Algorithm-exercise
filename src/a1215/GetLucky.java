package a1215;

/**
 * 给你一个由小写字母组成的字符串 s ，以及一个整数 k 。
 *
 * 首先，用字母在字母表中的位置替换该字母，将 s 转化 为一个整数（也就是，'a' 用 1 替换，'b' 用 2 替换，... 'z' 用 26 替换）。接着，将整数 转换 为其 各位数字之和 。共重复 转换 操作 k 次 。
 *
 * 例如，如果 s = "zbax" 且 k = 2 ，那么执行下述步骤后得到的结果是整数 8 ：
 *
 * 转化："zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
 * 转换 #1：262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
 * 转换 #2：17 ➝ 1 + 7 ➝ 8
 * 返回执行上述操作后得到的结果整数。
 */
public class GetLucky {
    public int getLucky(String s, int k) {
        if(s==null){
            return 0;
        }

        char[] chars = s.toCharArray();
        int length = s.length();
        int[] ints = new int[length];
        int needSum = 0;

        for (int i = 0; i < length; i++) {
            int i1 = chars[i] - 'a'+1;
            ints[i] = i1;
        }

        for (int i = 0; i < length; i++) {
            int num = ints[i];
            while (num > 0) {
                needSum += (num % 10);
                num /= 10;
            }
        }

        for (int i = 1; i < k; i++) {
            int curNumber = needSum;
            needSum = 0;
            while (curNumber>9){
                int remainder = curNumber % 10;
                curNumber = curNumber/10;
                needSum+=remainder;
            }
            needSum+=curNumber;
        }
        return needSum;
    }

    public static void main(String[] args) {
        GetLucky getLucky = new GetLucky();
//        System.out.println(getLucky.getLucky("iiii",1));
//        System.out.println(getLucky.getLucky("zbax",2));
        System.out.println(getLucky.getLucky("dbvmfhnttvr",5));
        System.out.println(getLucky.getLucky("hvmhoasabaymnmsd",1));

        int[] ints  = new int["hvmhoasabaymnmsd".toCharArray().length];
        for (int i = 0; i < "hvmhoasabaymnmsd".toCharArray().length; i++) {
            ints[i] = "hvmhoasabaymnmsd".toCharArray()[i]-'a'+1;
        }
        System.out.println(ints);
    }

}
