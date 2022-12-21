package dp01;

/**
 * 题目：给定一个整型数组arr，代表数值不同的纸牌排成一条线。
 * 玩家A和玩家B依次拿走每张纸牌，规定玩家A先拿，玩家B后拿，
 * 但是每个玩家每次只能拿走最左或最右的纸牌，玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数。
 *
 * 解题思路：
 * 先手玩家
     * 如果i != j，那么此时有两种选择，
     * 一种是先拿arr[i]，
     *      如果先拿走arr[i]，那么对于剩下的arr[i+1…j]，玩家成了后拿牌的人，所以他能获得的分数为arr[i] + s(i+1, j)；
     * 一种是先拿arr[j]。
     *      同理如果先拿arr[j]，那么他能获得的分数为arr[j] + s(i, j-1)。
     *  因为玩家是决定聪明的人，所以他会选择两个决策中最优的，即max(arr[i] + s(i+1, j), arr[j] + s(i, j-1))。
 *  后手玩家
     *  如果i != j，那么此时玩家的拿牌方式其实受到对手的影响，
     *  如果对手选择的是arr[i]那么给玩家留下的就是arr[i+1…j]，对于排列arr[i+1…j]玩家成了先拿牌的人，所以他能得到的分数为f(i+1, j)。
     *  同理，如果对手选择的是arr[j]那么给玩家留下的就是arr[i…j-1]，对于排列arr[i…j-1]玩家成了先拿牌的人，所以他能得到的分数为f(i, j-1)。
     *  因为对手也是绝顶聪明的，所以留给玩家的一定是最坏的情况，所以玩家只能选择两个决策中最差的，即min(f(i+1, j), f(i, j-1))。
 */
public class CardInLine {

    /**
     * 暴力递归
     * @param arr
     * @return
     */
    public static int win1(int arr[]){
        return Math.max(f1(arr,0,arr.length-1),s1(arr,0, arr.length-1));
    }

    /**
     * 先手函数
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int f1(int[] arr, int left, int right) {
        //只剩一个数时
        if(left==right){
            return arr[left];
        }
        //多个纸牌
        int p1 = arr[left] + s1(arr,left+1,right);
        int p2 = arr[right] + s1(arr,left,right-1);
        return Math.max(p1,p2);
    }

    /**
     * 后手函数
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int s1(int[] arr, int left, int right) {
        //只剩一个纸牌，返回0 因为后手没有选择权
        if(left==right){
            return 0;
        }
        int p1 = f1(arr,left+1,right);
        int p2 = f1(arr,left,right-1);
        return Math.min(p1,p2);
    }

    /**
     * 加入缓存的递归方式
     * @param arr
     * @return
     */
    public static int win2(int arr[]){

        int length = arr.length;
        int[][] farr = new int[length][length];
        int[][] sarr = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                farr[i][j] = -1;
                sarr[i][j] = -1;
            }
        }
        return Math.max(f2(arr,0,arr.length-1,farr,sarr),s2(arr,0, arr.length-1,farr,sarr));
    }


    private static int f2(int[] arr, int left, int right, int[][] farr, int[][] sarr) {
        if(farr[left][right]!=-1){
            return farr[left][right];
        }
        int res ;
        if(left==right){
            res = arr[left];
        }else {
            res = Math.max(arr[left]+s2(arr,left+1,right,farr,sarr),arr[right]+s2(arr,left,right-1,farr,sarr) );
        }
        farr[left][right]=res;
        return res;
    }


    private static int s2(int[] arr, int left, int right, int[][] farr, int[][] sarr) {
        if(sarr[left][right]!=-1){
            return sarr[left][right];
        }
        int res=0;
        if(left!=right){
            res = Math.min(f2(arr,left+1,right,farr,sarr),f2(arr,left,right-1,farr,sarr));
        }
        sarr[left][right] = res;
        return res;
    }


    public static void main(String[] args) {
        int arr[] = {5,7,4,5,8,1,6,0,3,4,6,1,7};
        System.out.println(win1(arr));
        System.out.println(win2(arr));
    }
}
