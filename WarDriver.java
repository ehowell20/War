import java.util.Scanner;

public class WarDriver
{
    public static void main(String[] args)
    {
        int card = 0;
        // player has half deck
        int playerCards = 26;
        // computer has half deck
        int compCards = 26;
        boolean hasWon = false;
        // creates new deck of cards
        Cards deck = new Cards();
        // shuffles deck
        deck.shuffleCards();
        while (!hasWon)
        {
            // player turn
            pause();
            // picks a random card
            card = deck.pickCard();
            // print card
            printCard(card);
            // slap?
            // computer turn
            // picks a random card
            card = deck.pickCard();
            // print card
            printCard(card);
            // slap?
        }
    }
    public static void pause()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Press any key to place a card");
        in.nextLine();
    }
    public static void printCard(int card)
    {
        switch (card)
        {
            // if card value is 1, 11, 12, or 13 show face letter (A, J, Q, K)
            default:
                // print out original card value
                System.out.println(card);
                break;
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
        }
    }
}