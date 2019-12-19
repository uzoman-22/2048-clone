import java.util.ArrayList;
/**
 * Class used to create a 4x4 board for the 2048 game. Empty spaces on the board are denoted by zeroes.
 *
 * @author Uzoma Ohajekwe
 * @version 1.0
 * @date 2019-02-22
 *
 */
public class Board
{
   /**
    * Integer[][] used to represent the 4X4 grid
    */
   private Integer[][] initboard;

   /**
    * Constructor for class Board
    */
   public Board()
   {
      initboard = new Integer[4][4];
      for (int r = 0; r < 4; r++)
      {
         for (int c = 0; c < 4; c++)
         {
            initboard[r][c] = 0;
         }
      }
   }

   /**
    * Prints out the string representation of the board to the console, where any zeroes in the array are represented by '*'.
    */
   public void print2Darray()
   {
      for (int r =  0; r < initboard.length; r++)
      {
         for (int c = 0; c < initboard[r].length; c++)
         {
            if (initboard[r][c] == 0)
            {
               System.out.print("*\t");
            }
            else
            {
               System.out.print(initboard[r][c] + "\t");
            }
         }
         System.out.println();
      }
   }

   /**
    * Places either 2 or 4 on the board randomly, where the chance of 2 being placed is higher than the chance a 4 is placed.
    */
   public void initRandArray()
   {
      int initialNumber1 = 0;
      int initialNumber2 = 0;
      if (Math.floor(Math.random() * 10) > 7)
      {
         initialNumber1 = 4;
      }
      else
      {
         initialNumber1 = 2;
      }

      if (Math.floor(Math.random() * 10) > 7)
      {
         initialNumber2 = 4;
      }
      else
      {
         initialNumber2 = 2;
      }

      int randPlace1 = (int)Math.floor(Math.random() * 16 + 1);

      if (randPlace1 % 4 == 0)
      {
         initboard [randPlace1/4-1][3] = initialNumber1;
      }
      else
      {
         initboard[randPlace1/4][randPlace1%4-1] = initialNumber1;
      }

      int randPlace2 = (int)Math.floor(Math.random() * 16 + 1);

      while (randPlace2 == randPlace1)
      {
       randPlace2 =  (int)Math.floor(Math.random() * 16 + 1);
      }

      if (randPlace2 % 4 == 0)
      {
         initboard [randPlace2/4-1][3] = initialNumber2;
      }
      else
      {
         initboard[randPlace2/4][randPlace2%4-1] = initialNumber2;
      }
      print2Darray();
   }

   /**
    * Places two numbers on the board randomly, adjusting for the number of empty spaces on the board. Numbers placed are either a two or a four, with two having a higher chance of being placed than a four. Returns true if there are spaces to place random numbers, false otherwise
    * @return true if the board is able to be populated with random numbers, false otherwise
    */
   public boolean randPop()
   {
      ArrayList<Integer> high = new ArrayList<Integer>(3);
      for (int r = 0; r < initboard.length; r++)
      {
         for (int c = 0; c < initboard[r].length; c++)
         {
            if (initboard[r][c] == 0)
            {

               high.add(4*r + (c+1));
            }
         }
      }

      if (high.size() == 0)
      {
         return false;
      }

      int newNum = 0;
      if (Math.floor(Math.random() * 10) > 7)
      {
         newNum = 4;
      }
      else
      {
         newNum = 2;
      }

      int rand = high.get((int)Math.floor(Math.random() * high.size()));

      if (rand % 4 == 0)
      {
         initboard [rand/4-1][3] = newNum;
      }
      else
      {
         initboard [rand/4][rand%4-1] = newNum;
      }
      return true;
   }

   /**
    * Returns the Integer[][] representing the board
    * @return the Integer[][] representing the board
    */
   public Integer[][] getArray()
   {
      return initboard;
   }
}



