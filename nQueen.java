import java.util.Scanner;
public class nQueen {
    static int n;
    static int [][]board;
    public static boolean isSafe(int row, int col){

        //1. Checking all the columns
        for(int i=0;i<row;i++){
            if(board[i][col]==1){
                return false;
            }
        }

        //2. Checking upper left diagonal
        for(int i=row-1, j=col-1;i>=0 &&j>=0;i--,j--){
            if(board[i][j]==1){
                return false;
            }
        }

        //3.Checking for upper right diagonal
        for(int i=row-1,j=col+1;i>=0 && j<n; i--,j++){
            if(board[i][j]==1){
                return false;
            }
        }
        return true;
    }

    public static boolean place(int row){
        if(row==n) return true; //Base condition where row equals to the last column!

        for(int col=0;col<n;col++){
            if (isSafe(row, col)){
                board[row][col]=1;

                if(place(row+1)){
                    return true;
                }

                //Backtracking
                board[row][col]=0;
            }
        }
        return false;
    }

    public static void display(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the Chessboard: ");
        n=sc.nextInt();

        board = new int[n][n];

        if(place(0)){
            System.out.println("Solution: ");
            display();
        } else{
            System.out.println("No solution possible!");
        }
        sc.close();
    }
}
