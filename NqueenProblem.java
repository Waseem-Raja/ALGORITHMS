//N_QUEEN PROBLEM USING BACKTRACKING
class Backtracking
{
    int size;
    Backtracking(int n)
    {
        this.size=n;

    }

     public boolean isSafe(int board[][], int row, int col)
    {
        int i, j;
        //we are only checking for col , upper-right diagonal and upper-left diagonal because we are  filling
        //queens row by row .so we don't need to check for other directions


        //check for the same col attack
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        //check for the Upper-left diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
       // check for Upper-right diagonal
        for (i = row, j = col; j >= 0 && i < this.size; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }


    public  boolean solveNQueen(int board[][], int col)
    {
        if (col >= this.size)
            return true; //you have successfully placed queens in n rows(0 , n-1)

        //now try to place the queen in the current row and call on remaining part using recursion
        for (int i = 0; i < this.size; i++) { //iterate over all the cols of current row

            //if it is safe to place the queen at position i,col -> place it
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                //now fill the remaking  rows  using recursion
                boolean nextqueenrakhpaye=(solveNQueen(board, col + 1));

                if (nextqueenrakhpaye) //if we are able to place the next queen the return true
                    return true;

                //backtrack if the above condition is false i.e if we are not able to place the next queen
                board[i][col] = 0;
            }
        }
        //tried for all positions of the current row but could not place a queen
        return false;
    }

    public void displaySolution(int board[][]) {

        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (board[i][j] == 1)
                    System.out.print(" " + "Q"
                            + " ");
                else
                    System.out.print(" " + "."
                            + " ");
            }
            System.out.println();
        }
    }
}
public class NqueenProblem {
    public static void main(String[] args) {
        Backtracking obj= new Backtracking(4); //4*4 problem

        int chessBoard[][] =
                {
                   {0, 0, 0, 0},
                   {0, 0, 0, 0},
                   {0, 0, 0, 0},
                    {0, 0, 0, 0}
                };

        if (!obj.solveNQueen(chessBoard, 0)) {
            System.out.print("Solution does not exist");
            return;
        }

        obj.displaySolution(chessBoard);

    }
}
