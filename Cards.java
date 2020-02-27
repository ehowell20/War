import java.util.ArrayList;
import java.util.Collections;

public class Cards
{
    // creates arraylist
    ArrayList<Integer> cardsList = new ArrayList<Integer>();
    // creates a deck of 52 cards
    public Cards()
    {
        // fills arraylist with 52 cards (4 cards valued 1-13)
        for (int i = 1; i <= 13; i++)
        {
            for (int j = 1; j <= 4; j++)
            {
                cardsList.add(i);
            }
        }
    }
    public void shuffleCards()
    {
        // shuffles deck
        Collections.shuffle(cardsList);
    }
    public int pickCard()
    {
        // pick card from arraylist
        int card = cardsList.get(0);
        // remove chosen card from arraylist
        cardsList.remove(0);
        // return card
        return card;
    }
    // returns numbers of chances player has to place royal
    public int cardChance(int card)
    {
        switch (card)
        {
            case 1:
                return 4;
            case 11:
                return 1;
            case 12:
                return 2;
            case 13:
                return 3;
        }
        return 0;
    }
}