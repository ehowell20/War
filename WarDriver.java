import java.util.ArrayList;

public class WarDriver
{
    public static void main(String[] args)
    {
        int card = 0;
        // creates new deck of cards
        Cards deck = new Cards();
        // picks a random card
        card = deck.pickCard();
        // if card value is 1, 11, 12, or 13 show face letter (A, J, Q, K)
        switch (card)
        {
            case 1:
                System.out.println("A");
                break;
            case 11:
                System.out.println("J");
                break;
            case 12:
                System.out.println("Q");
                break;
            case 13:
                System.out.println("K");
                break;
            default:
                // print out original card value
                System.out.println(card);
        }
    }
}