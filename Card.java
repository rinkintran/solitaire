import java.util.*;

/**
 * A standard playing card with a rank and a suit. Card is immutable.
 * Taken from enums lab
 * 
 * @author Lincoln Tran
 * @version April 14, 2015
 */

public class Card
{
    public enum Rank
    {
        DEUCE, THREE, FOUR, FIVE, SIX,
        SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }
    
    public enum Suit
    {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }
    
    public final Rank rank;   
    public final Suit suit;
    
    /** Construct a card from its rank and suit */
    public Card (Rank rank, Suit suit)
    {
        this.rank = rank;
        this.suit = suit;
    }
       
    /** Return a printable representation of this card */
    public String toString ()
    {
        return rank + " of " + suit;
    }
    
    public Rank getRank()
    {
        return this.rank;
    }
    
    public Suit getSuit()
    {
        return this.suit;
    }
}
