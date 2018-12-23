import java.util.*;

public class EightQueens  {
    public static final int VACANT = 0;
    public static final int OCCUPIED = 1;
	
    private static int boardSize = 8;
    private static int solutions;	// # of solutions

    public static int indentLevel = 0;

    public static void main(String [] args) {
	int [][] board = new int[boardSize][boardSize];
		
	for (int i = 0; i < boardSize; i++) {
	    for (int j = 0; j < boardSize; j++) {
		board[i][j] = VACANT;
	    }
	}
		
	solutions = 0;
	System.out.println("(row, col)");
	placeQueen(0, board);
		
    }
	
    public static void placeQueen(int row, int [][] bd) {
	if (row == boardSize)  {
	    printBoard(bd);
	    return;
	}

	indentLevel++;
	for (int col = 0; col < boardSize; col++) {
	    bd[row][col] = OCCUPIED;

	    if (positionIsSafe(bd, row, col)){
		//      for(int i = 0; i < indentLevel; i++)
		//          System.out.print("\t");
		//      System.out.println("("+row+","+col+")" );
		placeQueen(row + 1, bd);
	    }
			
	    bd[row][col] = VACANT;	
	}
	indentLevel--;
    }
	
    public static boolean positionIsSafe(int [][] bd, int row, int col)  {
	// Check this column in all lower rows
	for (int r = row - 1; r >=0; r--) {
	    if (bd[r][col] == OCCUPIED)
		return(false);
	}
		
	// Check diagonal down and to the right
	int downRight = col + 1;
	for (int r = row - 1; r >= 0 && downRight < boardSize; r--) {
	    if (bd[r][downRight] == OCCUPIED)
		return(false);
	    downRight++;	
	}
		
	// Check diagonal down and to the left
	int downLeft = col - 1;
	for (int r = row -1; r >= 0 && downLeft >= 0; r--) {
	    if (bd[r][downLeft] == OCCUPIED)
		return(false);
	    downLeft--;
	}
		
	return(true);
    }

    public static void printBoard(int [][] bd) {
	solutions++;
	StringBuffer s = new StringBuffer();
	s.append("+");
	for (int i = 0; i < boardSize; i++) {
	    s.append("---+");
	}
		
	System.out.println("\nSolution " + solutions + "\n" + s);
	for (int row = boardSize-1; row >= 0;row--) {
	    System.out.print("|");
	    for (int col = 0; col < boardSize; col++) {
		if (bd[row][col] == OCCUPIED)
		    System.out.print(" Q |");
		else
		    System.out.print("   |");	
	    }
	    System.out.println("\n"+s);
	}
	System.out.println("");
	//System.exit(1);
    }
}