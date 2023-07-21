//
// Declare Row as 3
// Declare Col as 3
// Delcare the board as an array of strings with the dimensions of the rows x cols
// Declares the current player as a String and sets their value to "X"
//
//
//Function main()
//  Initialize the scanner for user input
//
//  Loop:
//      Call clearBoard() to reset the board
//      Set currentPlayer to "X"
//
//      Inner Loop:
//          Call display() to print the current board
//          Get user input using the SafeInput for row and column (1-3) and stores them in row and col.
//          Subtract 1 from row and col to covert to the indices
//
//
//          Loop until isValid(row, col) returns as true
//              print error message and give the user the input again and subtract again.
//
//          Set the board to the currentPlayer
//
//          If isWin(currentPlayer) returns true:
//              Call display to print the final state of the board
//              Print "Player X or O wins!"
//              Breaks the inner loop
//
//          If isTie(currentPlayer) returns true:
//              Call display to print the final stae of the board
//              Print "Its a tie!"
//              Breaks the inner loop
//
//          Toogle currentPlayer to "X" if its "0" or "O" if its "X"
//
//      Ask the player if they want to play again (Y/N)
//      If the anser is not Y, break the loop.
// Close the Scanner
//
//Function clearBoard():
//  Loop through each row from 0 to ROW -1
//      Loop through each col from 0 to COL -1
//          Set board [row][col] to ""
//
//Function display():
//  print the board with a visual represnetation
//
//Function isValidMove(row, col)
//  if row is out of the range 0 to ROW -1 or col is out of range 0 to COL -1
//      Print error message
//      Return false
//
//  if the spot is already taken
//      print error message
//      return false
//
//  return true
//
//Function isWin(player):
//  if isRowWin(player returns true or isColWin(player) returns true or isDiagonalWins(player) returns true
//      return true
//  else
//      return false
//
//Funciton isRowWin(player):
//  Loop through each row from 0 to ROW -1
//      if all spots are in the row contain a player:
//          return true
//  return false
//
//Function isColWin(player):
//  Loop through each column from 0 to COL -1
//      if all spots in the col contain a player:
//          return true
//  return false
//
//Function isDiagonalWin(player)
//   If all cells in the main diagonal (board[0][0], board[1][1], board[2][2]) contain player:
//        Return true
//
//    If all cells in the anti-diagonal (board[0][2], board[1][1], board[2][0]) contain player:
//        Return true
//
//    return false
//
//Function isTie():
//    Loop through each row from 0 to ROW - 1:
//        Loop through each column from 0 to COL - 1:
//            If any spot is empty (contains a space):
//                return false
//
//    return true

import java.util.Scanner;

public class TicTacToe
{
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];
    private static String currentPlayer = "X";

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        while(true)
        {
            clearBoard();
            currentPlayer = "X";

            while(true)
            {
                int row, col;
                do
                {
                    row = SafeInput.getRangedInt(in,"Player " + currentPlayer + ", enter your row move between: ", 1, 3) - 1;
                    col = SafeInput.getRangedInt(in,"Player " + currentPlayer + ", enter your column move between: ", 1, 3) - 1;
                }
                while (!isValidMove(row, col));

                board[row][col] = currentPlayer;

                if (isWin(currentPlayer))
                {
                    display();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                if (isTie())
                {
                    display();
                    System.out.println("It's a tie!");
                    break;

                }
                currentPlayer = currentPlayer.equals("X") ? "O" : "X";
            }

            System.out.println("Do you want to play again? (Y/N): ");
            String playAgain = in.next().toUpperCase();
            if (!playAgain.equals("Y"))
            {
                break;
            }
        }
        in.close();
    }
    private static void clearBoard()
    {
        for (int x = 0; x < ROW; x++)
        {
            for (int y = 0; y < COL; y++)
            {
                board[x][y] = " ";
            }
        }
    }

    private static void display()
    {
        System.out.println("-------------");
        for (int x = 0; x < ROW; x++)
        {
            for (int y = 0; y < COL; y++)
            {
                System.out.print(board[x][y] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean isValidMove(int row, int col)
    {
        if (row < 0 || row >= ROW || col < 0 || col >= COL)
        {
            System.out.println("Invalid move. Try again.");
            return false;
        }

        if(!board[row][col].equals(" "))
        {
            System.out.println("Space already taken. Try again.");
            return false;
        }

        return true;
    }

    private static boolean isWin(String player)
    {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isRowWin(String player)
    {
        for (int x = 0; x < ROW; x++)
        {
            if (board[x][0].equals(player) && board[x][1].equals(player) && board[x][2].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player)
    {
        for (int x = 0; x < COL; x++)
        {
            if (board[0][x].equals(player) && board[1][x].equals(player) && board[2][x].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player)
    {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player) || board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie()
    {
        for (int x = 0; x < ROW; x++)
        {
            for (int y = 0; y < COL; y++)
            {
                if (board[x][y].equals(" "))
                {
                    return false;
                }
            }
        }
        return true;
    }
}
