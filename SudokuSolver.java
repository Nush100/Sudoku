public class SudokuSolver {
    
    private static final int GRIDE_SIZE = 9;

    public static void main(String[] args) {
        
        int[][] board = {
            {7,0,2,0,5,0,6,0,0},
            {0,0,0,0,0,3,0,0,0},
            {1,0,0,0,0,9,5,0,0},
            {8,0,0,0,0,0,0,9,0},
            {0,4,3,0,0,0,7,5,0},
            {0,9,0,0,0,0,0,0,8},
            {0,0,9,7,0,0,0,0,5},
            {0,0,0,2,0,0,0,0,0},
            {0,0,7,0,4,0,2,0,3}
        };
        
        printBoard(board);
        System.out.println();
        
        if(solveBoard(board)){
            System.out.println("Solved Successfully");
        }
        else{
            System.out.println("Unsolvable Board :(");
        }
        
        printBoard(board);
    }    
        
    private static boolean isNumberInRow(int[][] board, int row, int number){
        for(int i=0; i<GRIDE_SIZE; i++) {
            if(board[row][i] == number){
                return true;
            }
        }
        return false;
    }
    
    private static boolean isNumberInColumn(int[][] board, int column, int number){
        for(int i=0; i<GRIDE_SIZE; i++) {
            if(board[i][column] == number){
                return true;
            }
        }
        return false;
    }
    
    private static boolean isNumberInBox(int[][] board, int row,int column, int number){
        int localBoxRow = row - row%3;
        int localBoxColumn = column - column%3;
        
        for(int i=localBoxRow; i<localBoxRow+3; i++) {
            for(int j=localBoxColumn; j<localBoxColumn+3; j++){
                if(board[i][j] == number){
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean isNumberValid(int[][] board, int column, int row, int number){
        return !isNumberInRow(board, row, number) && 
               !isNumberInColumn(board, column, number) && 
               !isNumberInBox(board, row, column, number);
    }
    
    private static boolean solveBoard(int[][] board){
        for(int row = 0; row < GRIDE_SIZE; row++){
            for(int column = 0; column < GRIDE_SIZE; column++){
                if(board[row][column] == 0){
                    for(int numberToTry = 1; numberToTry <= GRIDE_SIZE; numberToTry++){
                        if(isNumberValid(board, column, row, numberToTry)){
                            board[row][column] = numberToTry;
                            
                            if(solveBoard(board)){
                                return true;
                            }
                            else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private static void printBoard(int[][] board){
        for(int i=0; i<GRIDE_SIZE; i++){
            if(i%3==0 && i!=0){
                System.out.println("----------");
            }
            for(int j=0; j<GRIDE_SIZE; j++) {
                if(j%3==0 && j!=0){
                    System.out.print("|");
                }
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
    
