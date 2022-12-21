package dp02;

/**
 * 象棋从一个位置到另一个位置的方法数
 * 象棋格子 10*9
 */
public class HorseJump {

    public static int jump(int x,int y,int rest,int a,int b){
        //约束 x(0,9) y(0,8)
        if(x<0 || x>9 || y<0 || y>8){
            return 0;
        }
        if(rest==0){
            return (x==a && y==b)?1:0;
        }
        int p1 = jump(x+2,y+1,rest-1,a,b);
        int p2 = jump(x+1,y+2,rest-1,a,b);
        int p3 = jump(x-1,y+2,rest-1,a,b);
        int p4 = jump(x-2,y+1,rest-1,a,b);
        int p5 = jump(x-2,y-1,rest-1,a,b);
        int p6 = jump(x-1,y-2,rest-1,a,b);
        int p7 = jump(x+1,y-2,rest-1,a,b);
        int p8 = jump(x+2,y-1,rest-1,a,b);
        return p1+p2+p3+p4+p5+p6+p7+p8;
    }

    public static int dp(int k,int a,int b){
        int[][][] dp = new int[10][9][k+1];

        dp[a][b][0] = 1;

        for (int rest = 1; rest <= k; rest++) {
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 9; y++) {
                    int res = pick(dp,x+2,y+1,rest-1);
                    res+= pick(dp,x+1,y+2,rest-1);
                    res+= pick(dp,x-1,y+2,rest-1);
                    res+= pick(dp,x-2,y+1,rest-1);
                    res+= pick(dp,x-2,y-1,rest-1);
                    res+= pick(dp,x-1,y-2,rest-1);
                    res+= pick(dp,x+1,y-2,rest-1);
                    res+= pick(dp,x+2,y-1,rest-1);
                    dp[x][y][rest] = res;
                }
            }
        }
        return dp[0][0][k];
    }

    public static int pick(int[][][] dp,int x,int y,int rest){
        if(x<0 || x>9 || y<0 || y>8){
            return 0;
        }
        return dp[x][y][rest];
    }

    public static void main(String[] args) {
        int x = 7;
        int y = 7;
        int step=10;

        System.out.println(jump(0,0,step,x,y));
        System.out.println(dp(step,x,y));
    }
}
