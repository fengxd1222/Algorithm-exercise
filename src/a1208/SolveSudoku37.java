package a1208;

/**
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 数独的解法需 遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 *输入：
 * board =
 * [["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]]
 * 输出：
 * [["5","3","4","6","7","8","9","1","2"],
 * ["6","7","2","1","9","5","3","4","8"],
 * ["1","9","8","3","4","2","5","6","7"],
 * ["8","5","9","7","6","1","4","2","3"],
 * ["4","2","6","8","5","3","7","9","1"],
 * ["7","1","3","9","2","4","8","5","6"],
 * ["9","6","1","5","3","7","2","8","4"],
 * ["2","8","7","4","1","9","6","3","5"],
 * ["3","4","5","2","8","6","1","7","9"]]
 */
public class SolveSudoku37 {
    public void solveSudoku(char[][] board) {
        //具体含义就是数独中第i行的数字是否出现过
        boolean[][] row = new boolean[9][10];
        //列验证表
        boolean[][] col = new boolean[9][10];
        //3*3宫格 可以将每个3*3格子看作一个位置，设置成三维数组，可以省略一个bucketIndex的计算
        //boolean[][] bucket = new boolean[9][10];int bucketIndex = i/3*3+j/3;
        boolean[][][] bucket = new boolean[3][3][10];


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]!='.'){
                    int number = board[i][j]-'0';
                    int bucketIndex = i/3*3+j/3;

                    row[i][number] = true;
                    col[j][number] = true;
                    bucket[i/3][j/3][number] = true;
                }
            }
        }

        recursion(board,0,0,row,col,bucket);
    }

    private boolean recursion(char[][] board, int i, int j, boolean[][] row, boolean[][] col, boolean[][][] bucket) {
        //顺利的处理完0-8行，当前路线正确，就算完成
        if(i==9){
            return true;
        }
        //处理换行 当j==8的时候，下一次就需要换行，j归零，i+1
        int next_i = j==8?i+1:i;
        int next_j = j==8?0:j+1;
        //如果当前位置有数字，那就递归下一个位置
        if(board[i][j]!='.'){
            return recursion(board,next_i,next_j,row,col,bucket);
        }else {
            //1-9都需要尝试
            for (int k = 1; k <= 9; k++) {
                //如果三个字典表里都没有用过，那么就可以尝试
                if(!row[i][k] && !col[j][k] && !bucket[i/3][j/3][k]){
                    //将当前这个数字先占住，防止下一次递归重复使用
                    row[i][k] = true;
                    col[j][k] = true;
                    bucket[i/3][j/3][k] = true;
                    board[i][j] = (char)(k+'0');
                    //递归之后调用有可能是错误的解，有可能是正确的，那么返回true时，后续数字不用再尝试，直接返回
                    if(recursion(board,next_i,next_j,row,col,bucket)){
                        return true;
                    }
                    //如果是false，需要将之前占用的数字解放
                    row[i][k] = false;
                    col[j][k] = false;
                    bucket[i/3][j/3][k] = false;
                    board[i][j] = '.';
                }
            }
            //遍历完所有数字，都不对，那就说明当前路线错误
            return false;
        }
    }

}
