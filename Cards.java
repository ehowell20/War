import java.util.ArrayList;

public class Cards
{
    // creates arraylist
    ArrayList<Integer> cards = new ArrayList<Integer>();
    // creates a deck of 52 cards
    public Cards()
    {
        // fills arraylist with 52 cards (4 cards valued 1-13)
        for (int i = 1; i <= 13; i++)
        {
            for (int j = 1; j <= 4; j++)
            {
                cards.add(i);
            }
        }
    }
    public int pickCard()
    {
        // pick random card from arraylist
        // store in temp int
        // remove chosen card from arraylist
        // return temp int
        return 0;
    }
}