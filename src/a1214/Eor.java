package a1214;

/**
 *  异或练习
 */
public class Eor {

    /**
     * 数组中存在n个数，其中只有一个数出现了奇数次，
     *  *  \其他出现了偶数次，求这个出现了奇数次的数字；
     *  *  (因为偶数次的数字通过异或，最终都会是0，一个数字与0异或，是他的本身，所以异或最终剩下的数字只有奇数次的数字)
     * @param arr
     * @return
     */
    public static int eor1(int[] arr){
        int eor = 0;
        for(int i=0;i<arr.length;i++){
            eor ^=arr[i];
        }
        return eor;
    }

    /**
     *  数组中存在n个数，其中有两个数出现了奇数次，其他出现了偶数次，求这两个出现了奇数次的数字；(这里需要用到小技巧，N&(~N+1) )
     * @param arr
     */
    public static void eor2(int[] arr){
        int eor = 0;
        for(int i=0;i<arr.length;i++){
            eor ^=arr[i];
        }
        int rightOne = eor&(~eor+1);
        int newEor = 0;
        for(int i=0;i<arr.length;i++){
            if((rightOne&arr[i])!=0){
                newEor ^= arr[i];
            }
        }
        System.out.println("第一个数字是"+newEor+"，第二个数字是"+(eor^newEor));
    }


    public static void main(String[] args) {
        Eor.eor2(new int[]{1,2,3,4,5,5,6,7,1,2,3,4});
    }
}
