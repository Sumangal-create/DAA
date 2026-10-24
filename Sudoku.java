import java.util.Scanner;
public class Sudoku{
    static int[][]board= new int[9][9];

    public static boolean isSafe(int row, int col, int num){

        //Check rows
        for(int i=0;i<row;i++){
            if(board[row][i]==num){
                return false;
            }
        }

        //Check Columns
        for(int j=0;j<col;j++){
            if(board[j][col]==num){
                return false;
            }
        }

        int firstRow=(row*3)/3;
        int firstCol=(col*3)/3;

        //Check for the diagonals
        for(int i=firstRow;i<firstRow+3;i++){
            for(int j=firstCol;j<firstCol+3;j++){
                if(board[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean place(){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]==0){
                    for(int num=1;num<=9;num++){
                        if(isSafe(row, col, num)){
                            board[row][col]=num;

                            if(place()){
                                return true;
                            }

                            board[row][col]=0;
                        }
                    }
                }

               
            }
        }
         return false;// No element can be placed
    }

    public static void Display(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Sudoku elements (0 for empty spaces): ");
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j]=sc.nextInt();
            }
        }

        System.out.print("Original Sudoku: ");
        Display();

        if(place()){
            System.out.println("The solved Sudoku is: ");
            Display();
        } else{
            System.out.println("There exists no soluton for this Sudoku!");
        }
    }
}