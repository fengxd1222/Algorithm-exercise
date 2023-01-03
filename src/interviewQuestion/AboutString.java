package interviewQuestion;

public class AboutString {
    public static void main(String[] args) {
        System.out.println();
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);

        try { // do something
//             System.exit(1);
             System.exit(0);
        } finally{
            System.out.println("Print from finally");
        }
//        String s = new String("1");
//        String s2 = "1";
//        s.intern();
//        System.out.println(s == s2);
//
//        String s3 = new String("1") + new String("1");
//        String s4 = "11";
//        s3.intern();
//        System.out.println(s3 == s4);
    }
}
