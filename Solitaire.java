import java.io.*;
import java.lang.*;
import java.util.Arrays;
import java.util.List;

/**
 * This program emulates the solitaire game on the most basic level.
 * 
 * @author Lincoln Tran
 * @version March 14, 2015
 */
public class Solitaire
{
    //instance static variable-lookup table for char to index
    static String indexWord = new String();

    /**
     * Static initializer for a lookup table of lowercase and
     * uppercase letters to convert it to the index of the table game
     */
    static
    {  
        for (char lowerCase = 'a'; lowerCase <= 'z'; lowerCase++)
        {
            indexWord += lowerCase;
        }

        for (char upperCase = 'A'; upperCase <= 'Z'; upperCase++)
        {
            indexWord += upperCase;
        }
    }

    /**
     * Constructor for objects of class Solitaire
     */
    public Solitaire()
    {
    }

    /**
     * Finds all valid moves in a given table configuration
     * 
     * @param  table   array size 1-52, filled with cards
     * @param  tableLength  how many elements are in the table
     * @return     a string containing valid 2-character moves 
     */
    public String findValidMoves(Card[] table, int tableLength)
    {
        StringBuilder validMoves = new StringBuilder();
        //loops through array of cards once
        for (int index = 0; index < tableLength; index++)
        {
            //takes the individual card from the table
            Card individualCard = new Card(table[index].getRank(), 
                    table[index].getSuit());

            //if previous card exists and is a valid move, add the move 
            //to list
            if (index - 1 >= 0)
            {
                Card previousCard = new Card(table[index-1].getRank(), 
                        table[index-1].getSuit());
                if (individualCard.getRank() == previousCard.getRank() 
                    || individualCard.getSuit() == previousCard.getSuit())
                {
                    if (validMoves.length() > 1)
                    {
                        validMoves.append(" ");
                    }
                    validMoves.append(indexWord.charAt(index));
                    validMoves.append("1");
                }
            }

            //if 3rd previous card exists and is a valid move, add move to list
            if (index - 3 >= 0)
            {
                Card threePreviousCard = new Card(table[index-3].getRank(), 
                        table[index-3].getSuit());
                if (individualCard.getRank() == threePreviousCard.getRank() || 
                    individualCard.getSuit() == threePreviousCard.getSuit())
                {
                    if (validMoves.length() > 1)
                    {
                        validMoves.append(" ");
                    }
                    validMoves.append(indexWord.charAt(index));
                    validMoves.append("3");
                }
            }

        }
        return validMoves.toString();
    }

    /**
     * Simulates playing a game
     * 
     * @param  table   array size 1-52, filled with cards
     * @param  moveSequence  a sequence of moves in order separated by a space
     * @return   number of cards left on table 
     */
    public int play(Card[] table, String moveSequence)
    {
        //breaks move sequence into an array of individual moves
        String[] individualMove = moveSequence.split(" ");
        int movesMade = 0; //initializes move to 0;
        //calls findValidMoves method to find valid moves
        String validMoves = findValidMoves(table, table.length);

        /**
         * loops through moveSequence and compares it with list of valid moves
         * increments moves made if the move in the sequence is valid
         */
        for (int move = 0; move < individualMove.length; move++)
        {
            if (validMoves.contains(individualMove[move]))
            {
                movesMade++;
            }
        }
        return table.length - movesMade; //subtracts moves made from # of cards
    }
}
