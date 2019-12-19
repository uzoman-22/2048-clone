import java.util.Scanner;
/**
 * Runs a working version of the 2048 game
 *
 * @author Uzoma Ohajekwe
 * @version 1.0
 * @date 2022-02-23
 */
public class Main
{
    /**
     * Constant that stores random value used for loop bound offset variable
     */
    private static final Integer LOOP_CONDITION_OFFSET_VALUE = (int)Math.floor(Math.random() * (Integer.MAX_VALUE));

    public static void main(String[] args)
    {
        boolean inGame = true;
        Scanner sc = new Scanner(System.in);
        String finalMessage = "";
        while (inGame)
        {
            Board b1 = new Board();
            b1.initRandArray();
            boolean isGameRunning = true;
            int moveCounter = 0;
            while (isGameRunning)
            {
                String str = sc.nextLine();
                if (str.equals("d"))
                {
                    int completeSum = 0;// decides if move is valid or not
                    String burr = "";
                    for (int r = 0; r < b1.getArray().length; r++)
                    {
                        int loopSum = LOOP_CONDITION_OFFSET_VALUE;
                        int loopBound = b1.getArray()[r].length - 1;
                        while (loopSum != 0)
                        {
                            loopSum = 0;
                            for (int c = loopBound; c > 0; c--)
                            {
                                if (b1.getArray()[r][c] == 0 && b1.getArray()[r][c - 1] != 0)
                                {
                                    b1.getArray()[r][c] = b1.getArray()[r][c] + b1.getArray()[r][c - 1];
                                    loopSum += b1.getArray()[r][c] + b1.getArray()[r][c - 1];
                                    b1.getArray()[r][c - 1] = 0;
                                }
                                else if ((b1.getArray()[r][c].equals(b1.getArray()[r][c - 1])) && (b1.getArray()[r][c] != 0 && b1.getArray()[r][c] !=0))
                                {
                                    b1.getArray()[r][c] = b1.getArray()[r][c] + b1.getArray()[r][c - 1];
                                    loopSum += b1.getArray()[r][c] + b1.getArray()[r][c - 1];
                                    b1.getArray()[r][c - 1] = 0;
                                    loopBound = c - 1;
                                }
                            }
                            completeSum += loopSum;
                        }
                    }
                        if (completeSum > 0)
                    {
                        isGameRunning = b1.randPop();
                        moveCounter++;
                        burr = "This was a valid move. Key pressed was 'd'.";
                        for (int r = 0; r < b1.getArray().length; r++)
                        {
                            for (int c = 0; c < b1.getArray()[r].length; c++)
                            {
                                if (b1.getArray()[r][c] == 2048)
                                {
                                    finalMessage = "Congratulations! You win! Your high score is 2048 and the number of moves you made was " + moveCounter + ".";
                                    isGameRunning = false;
                                    inGame = false;
                                }
                            }
                        }
                    }
                    else
                    {
                        burr = "This was an invalid move. Key pressed was 'd'.";
                    }

                    if (gameAI(b1.getArray()) == 0 && isFull(b1.getArray()))
                    {
                        finalMessage = "Game over. Your high score is " + find2Dmax(b1.getArray()) + " and the number of moves you made was " + moveCounter + ".";
                        isGameRunning = false;
                        inGame = false;
                    }

                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    b1.print2Darray();
                    System.out.println(burr);
                    System.out.println("Moves made: " + moveCounter);
                    System.out.println("Highest tile: " + find2Dmax(b1.getArray()));
                }

                else if (str.equals("a"))
                {
                  int completeSum = 0;
                  String burr = "";
                  for (int r = 0; r < b1.getArray().length; r++)
                  {
                      int loopSum = LOOP_CONDITION_OFFSET_VALUE;
                      int loopBound = 0;
                      while (loopSum != 0)
                      {
                          loopSum = 0;
                          for (int c = loopBound; c < b1.getArray()[r].length-1; c++)
                          {
                              if (b1.getArray()[r][c] == 0 && b1.getArray()[r][c+1] != 0)
                              {
                                  loopSum += b1.getArray()[r][c] + b1.getArray()[r][c+1];
                                  b1.getArray()[r][c] = b1.getArray()[r][c] + b1.getArray()[r][c+1];
                                  b1.getArray()[r][c+1] = 0;
                              }
                              else if ((b1.getArray()[r][c] != 0 && b1.getArray()[r][c+1] != 0) && (b1.getArray()[r][c].equals(b1.getArray()[r][c+1])))
                              {
                                  loopSum += b1.getArray()[r][c] + b1.getArray()[r][c+1];
                                  b1.getArray()[r][c] = b1.getArray()[r][c] + b1.getArray()[r][c+1];
                                  b1.getArray()[r][c+1] = 0;
                                  loopBound = c+1;
                              }
                          }
                        completeSum += loopSum;
                      }
                  }
                    if (completeSum > 0)
                    {
                        isGameRunning = b1.randPop();
                        moveCounter++;
                        burr = "This was a valid move. Key pressed was 'a'.";
                        for (int r = 0; r < b1.getArray().length; r++)
                        {
                            for (int c = 0; c < b1.getArray()[r].length; c++)
                            {
                                if (b1.getArray()[r][c] == 2048)
                                {
                                    finalMessage = "Congratulations! You win! Your high score is 2048 and the number moves you made was " + moveCounter + ".";
                                    isGameRunning = false;
                                    inGame = false;
                                }
                            }
                        }
                    }
                    else
                    {
                        burr = "This was an invalid move. Key pressed was 'a'.";
                    }

                    if (gameAI(b1.getArray()) == 0 && isFull(b1.getArray()))
                    {
                        finalMessage = "Game over. Your high score is " + find2Dmax(b1.getArray()) + " and the number of moves you made was " + moveCounter + ".";
                        isGameRunning = false;
                        inGame = false;
                    }

                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    b1.print2Darray();
                    System.out.println(burr);
                    System.out.println("Moves made: " + moveCounter);
                    System.out.println("Highest tile: " + find2Dmax(b1.getArray()));
                }

                else if (str.equals("s"))
                {
                    int completeSum = 0;
                    String burr = "";
                    for (int c = 0; c < b1.getArray()[0].length; c++)
                    {
                        int loopSum = LOOP_CONDITION_OFFSET_VALUE;
                        int loopBound = b1.getArray().length-1;
                        while (loopSum != 0)
                        {
                            loopSum = 0;
                            for (int r = loopBound; r > 0; r--)
                            {
                                if (b1.getArray()[r][c] == 0 && b1.getArray()[r-1][c] != 0)
                                {
                                    loopSum += b1.getArray()[r][c] + b1.getArray()[r-1][c];
                                    b1.getArray()[r][c] = b1.getArray()[r][c] + b1.getArray()[r-1][c];
                                    b1.getArray()[r-1][c] = 0;
                                }
                                else if ((b1.getArray()[r][c] != 0 && b1.getArray()[r-1][c] != 0) && (b1.getArray()[r][c].equals(b1.getArray()[r-1][c])))
                                {
                                    loopSum += b1.getArray()[r][c] + b1.getArray()[r-1][c];
                                    b1.getArray()[r][c] = b1.getArray()[r][c] + b1.getArray()[r-1][c];
                                    b1.getArray()[r-1][c] = 0;
                                    loopBound = r-1;
                                }
                            }
                            completeSum += loopSum;
                        }
                    }
                    if (completeSum > 0)
                    {
                        isGameRunning = b1.randPop();
                        moveCounter++;
                        burr = "This was a valid move. Key pressed was 's'.";
                        for (int r = 0; r < b1.getArray().length; r++)
                        {
                            for (int c = 0; c < b1.getArray()[r].length; c++)
                            {
                                if (b1.getArray()[r][c] == 2048)
                                {
                                    finalMessage = "Congratulations! You win! Your high score is 2048 and the number moves you made was " + moveCounter + ".";
                                    isGameRunning = false;
                                    inGame = false;
                                }
                            }
                        }
                    }
                    else
                    {
                        burr = "This was an invalid move. Key pressed was 's'.";
                    }

                    if (gameAI(b1.getArray()) == 0 && isFull(b1.getArray()))
                    {
                        finalMessage = "Game over. Your high score is " + find2Dmax(b1.getArray()) + " and the number of moves you made was " + moveCounter + ".";
                        isGameRunning = false;
                        inGame = false;
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    b1.print2Darray();
                    System.out.println(burr);
                    System.out.println("Moves made: " + moveCounter);
                    System.out.println("Highest tile: " + find2Dmax(b1.getArray()));
                }
                else if (str.equals("w"))
                {
                    int completeSum = 0;
                    String burr = "";
                    for (int c = 0; c < b1.getArray()[0].length; c++)
                    {
                        int loopSum = LOOP_CONDITION_OFFSET_VALUE;
                        int loopBound = 0;
                        while (loopSum != 0)
                        {
                            loopSum = 0;
                            for (int r = loopBound; r < b1.getArray().length-1; r++)
                            {
                               if (b1.getArray()[r][c] == 0 && b1.getArray()[r+1][c] != 0)
                               {
                                   loopSum += b1.getArray()[r][c] + b1.getArray()[r+1][c];
                                   b1.getArray()[r][c] = b1.getArray()[r][c] + b1.getArray()[r+1][c];
                                   b1.getArray()[r+1][c] = 0;
                               }
                               else if ((b1.getArray()[r][c] != 0 && b1.getArray()[r+1][c] != 0) && (b1.getArray()[r][c].equals(b1.getArray()[r+1][c])))
                               {
                                   loopSum += b1.getArray()[r][c] + b1.getArray()[r+1][c];
                                   b1.getArray()[r][c] = b1.getArray()[r][c] + b1.getArray()[r+1][c];
                                   b1.getArray()[r+1][c] = 0;
                                   loopBound = r+1;
                               }
                            }
                            completeSum += loopSum;
                        }
                    }
                    if (completeSum > 0)
                    {
                        isGameRunning = b1.randPop();
                        moveCounter++;
                        burr = "This was a valid move. Key pressed was 'w'.";
                        for (int r = 0; r < b1.getArray().length; r++)
                        {
                            for (int c = 0; c < b1.getArray()[r].length; c++)
                            {
                                if (b1.getArray()[r][c] == 2048)
                                {
                                    finalMessage = "Congratulations! You win! Your high score is 2048 and the number moves you made was " + moveCounter + ".";
                                    isGameRunning = false;
                                    inGame = false;
                                }
                            }
                        }
                    }
                    else
                    {
                        burr = "This was an invalid move. Key pressed was 'w'.";
                    }

                    if (gameAI(b1.getArray()) == 0 && isFull(b1.getArray()))
                    {
                        finalMessage = "Game over. Your high score is " + find2Dmax(b1.getArray()) + " and the number of moves you made was " + moveCounter + ".";
                        isGameRunning = false;
                        inGame = false;
                    }

                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    b1.print2Darray();
                    System.out.println(burr);
                    System.out.println("Moves made: " + moveCounter);
                    System.out.println("Highest tile: " + find2Dmax(b1.getArray()));
                }

                else if (str.equals("r"))
                {
                    System.out.println("Are you sure you want to restart the game? Type 'r' again to confirm.");
                    String restart = sc.nextLine();

                    if (restart.equals("r"))
                    {
                        isGameRunning = false;
                    }
                }

                else if (str.equals("q"))
                {
                    System.out.println("Are you sure you want to quit the game? Type 'q' again to confirm.");
                    String quit = sc.nextLine();

                    if (quit.equals("q"))
                    {
                        finalMessage = "Game over. Your high score is " + find2Dmax(b1.getArray()) + " and the number of moves you made is " + moveCounter + ".";
                        inGame = false;
                        isGameRunning = false;
                    }
                }
                else if (str.equals(""))
                {
                    System.out.println("This was an invalid move. You did not enter a key.");
                }
                else
                {
                    System.out.println("This was an invalid move. Key pressed was '" + str.charAt(0) + "'.");
                }
            }
        }
        System.out.println(finalMessage);
    }

    /**
     * Returns the number of possible valid moves a player can make at a given time during the game.
     * Used to help decide whether it is still possible for the user to play, as zero moves indicates the player has no available moves left and the game is likely over.
     * @param arr the Integer 2D array that represents the 4X4 grid the player plays on.
     * @return the number of valid moves a player can make at a given time.
     */
    private static Integer gameAI(Integer[][] arr)
    {
        int outerCounter = 0;// decides if move is valid or not
        for (int r = 0; r < arr.length; r++) //right
        {
            int innerCounter = 0;
                for (int c = arr[r].length-1; c > 0; c--)
                {
                    if (arr[r][c] == 0 && arr[r][c - 1] != 0)
                    {
                        innerCounter++;
                    }
                    else if ((arr[r][c].equals(arr[r][c - 1])) && (arr[r][c] != 0 && arr[r][c] !=0)) //change == to .equals()
                    {
                        innerCounter++;
                    }
                }
                outerCounter += innerCounter;
        }

        for (int c = 0; c < arr[0].length; c++) //up
        {
            int innerCounter = 0;
                for (int r = 0; r < arr.length-1; r++)
                {
                    if (arr[r][c] == 0 && arr[r+1][c] != 0)
                    {
                       innerCounter++;
                    }
                    else if ((arr[r][c] != 0 && arr[r+1][c] != 0) && (arr[r][c].equals(arr[r+1][c])))
                    {
                        innerCounter++;
                    }
                }
                outerCounter += innerCounter;
            }

        for (int c = 0; c < arr[0].length; c++) //down
        {
            int innerCounter = 0;
                for (int r = arr.length-1; r > 0; r--)
                {
                    if (arr[r][c] == 0 && arr[r-1][c] != 0)
                    {
                        innerCounter++;
                    }
                    else if ((arr[r][c] != 0 && arr[r-1][c] != 0) && (arr[r][c].equals(arr[r-1][c])))
                    {
                        innerCounter++;
                    }
                }
                outerCounter += innerCounter;

        }

        for (int r = 0; r < arr.length; r++)
        {
            int innerCounter = 0;
                for (int c = 0; c < arr[r].length-1; c++)
                {
                    if (arr[r][c] == 0 && arr[r][c+1] != 0)
                    {
                        innerCounter++;
                    }
                    else if ((arr[r][c] != 0 && arr[r][c+1] != 0) && (arr[r][c].equals(arr[r][c+1])))
                    {
                        innerCounter++;
                    }
                }
                outerCounter += innerCounter;
        }
        return outerCounter;
    }

    /**
     * Traverses through a 2D Integer array, specifically that of the Board class, and decides whether the array has any empty spaces remaining or is full.
     * Empty space in Board class are represented by zeroes, so any position with a number other than zero is occupied.
     * Used to help game logic for 2048 game, as a full board can mean the user is out of possible moves or near out of possible moves.
     * @param arr the Integer 2D array that represents the 4X4 board the player plays on.
     * @return true if the board is full, false otherwise.
     */
    private static boolean isFull(Integer[][] arr)
    {
        int counter = 0;
        for (int r = 0; r < arr.length; r++)
        {
            for (int c = 0; c < arr[r].length; c++)
            {
               if (arr[r][c] != 0)
               {
                  counter++;
               }
            }
        }
        if (counter == 16)
        {
            return true;
        }
        return false;
    }

    /**
     * Returns the maximum element in a 2D Integer array
     * Used to display the maximum tile in the 2048 game
     * @return the maximum element in 2D Integer array
     */
    private static Integer find2Dmax(Integer[][] arr)
    {
        Integer max = arr[0][0];
        for (int r = 0; r < arr.length; r++)
        {
            for (int c = 0; c < arr[r].length; c++)
            {
                if (arr[r][c] > max)
                {
                    max = arr[r][c];
                }
            }
        }
        return max;
    }
}

