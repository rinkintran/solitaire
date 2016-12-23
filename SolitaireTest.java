

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SolitaireTest.
 *
 * @author  Lincoln Tran
 * @version March 14, 2015
 */
public class SolitaireTest
{
    /**
     * Default constructor for test class SolitaireTest
     */
    public SolitaireTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testFindValidMoves()
    {
        Solitaire table = new Solitaire();
        //test game
        Card[] game = new Card[6];
        game[0] = new Card(Card.Rank.DEUCE, Card.Suit.CLUBS);   //a
        game[1] = new Card(Card.Rank.TEN, Card.Suit.CLUBS);     //b
        game[2] = new Card(Card.Rank.DEUCE, Card.Suit.HEARTS);  //c
        game[3] = new Card(Card.Rank.NINE, Card.Suit.SPADES);   //d
        game[4] = new Card(Card.Rank.DEUCE, Card.Suit.CLUBS);   //e
        game[5] = new Card(Card.Rank.DEUCE, Card.Suit.HEARTS);  //f
        assertEquals("b1 e3 f1 f3", table.findValidMoves(game, 6));
        
        //test game2
        Card[] game2 = new Card[8];
        game2[0] = new Card(Card.Rank.DEUCE, Card.Suit.CLUBS);   //a
        game2[1] = new Card(Card.Rank.THREE, Card.Suit.DIAMONDS);//b
        game2[2] = new Card(Card.Rank.FOUR, Card.Suit.HEARTS);   //c
        game2[3] = new Card(Card.Rank.FIVE, Card.Suit.SPADES);   //d
        game2[4] = new Card(Card.Rank.SIX, Card.Suit.CLUBS);     //e
        game2[5] = new Card(Card.Rank.SEVEN, Card.Suit.DIAMONDS);//f
        game2[6] = new Card(Card.Rank.EIGHT, Card.Suit.HEARTS);  //g
        game2[7] = new Card(Card.Rank.NINE, Card.Suit.SPADES);   //h
        assertEquals("", table.findValidMoves(game2, 8));
    }

    @Test
    public void testPlay()
    {
        Solitaire table = new Solitaire();
        //test game
        Card[] game = new Card[5];
        game[0] = new Card(Card.Rank.DEUCE, Card.Suit.CLUBS);   //a
        game[1] = new Card(Card.Rank.TEN, Card.Suit.CLUBS);     //b
        game[2] = new Card(Card.Rank.DEUCE, Card.Suit.HEARTS);  //c
        game[3] = new Card(Card.Rank.NINE, Card.Suit.SPADES);   //d
        game[4] = new Card(Card.Rank.DEUCE, Card.Suit.CLUBS);   //e
        assertEquals(3, table.play(game, "b1 e3"));
        
        //test game2
        Card[] game2 = new Card[8];
        game2[0] = new Card(Card.Rank.DEUCE, Card.Suit.CLUBS);   //a
        game2[1] = new Card(Card.Rank.THREE, Card.Suit.DIAMONDS);//b
        game2[2] = new Card(Card.Rank.FOUR, Card.Suit.HEARTS);   //c
        game2[3] = new Card(Card.Rank.FIVE, Card.Suit.SPADES);   //d
        game2[4] = new Card(Card.Rank.SIX, Card.Suit.CLUBS);     //e
        game2[5] = new Card(Card.Rank.SEVEN, Card.Suit.DIAMONDS);//f
        game2[6] = new Card(Card.Rank.EIGHT, Card.Suit.HEARTS);  //g
        game2[7] = new Card(Card.Rank.NINE, Card.Suit.SPADES);   //h
        assertEquals(8, table.play(game2, "b1 e3 h1 b4 3b"));
    }
}


